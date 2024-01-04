package cn.qkl.webserver.service;

import cn.qkl.common.framework.response.PageVO;
import cn.qkl.common.framework.util.FunctionUtil;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.model.NotifyRecord;
import cn.qkl.common.repository.model.Thresholds;
import cn.qkl.common.repository.model.User;
import cn.qkl.webserver.backgroundTask.schedule.NotificationScheduleTaskV2;
import cn.qkl.webserver.common.enums.SwitchEnum;
import cn.qkl.webserver.dao.NotifyRecordDao;
import cn.qkl.webserver.dao.SwitchTableDao;
import cn.qkl.webserver.dao.ThresholdsDao;
import cn.qkl.webserver.dao.UserDao;
import cn.qkl.webserver.dto.noticification.*;
import cn.qkl.webserver.vo.notification.*;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.select;

/**
 * @Author sunxiaen
 * @Date 2023/6/30 16:28
 **/

@Service
public class NotificationService {

    @Autowired
    NotifyRecordDao notifyRecordDao;

    @Autowired
    ThresholdsDao thresholdsDao;

    @Autowired
    UserDao userDao;

    @Autowired
    SwitchTableDao switchTableDao;

    @Autowired
    NotificationScheduleTaskV2 notificationScheduleTaskV2;

    //遍历通知项，返回全部
    public NotificationNumbersVO getNotificationNumbers() {
        List<Thresholds> thresholds = thresholdsDao.select(c -> c);
        return FunctionUtil.apply(new NotificationNumbersVO(),it -> {
            it.setData(new ArrayList<>());
            it.setNames(new ArrayList<>());
            for (Thresholds threshold: thresholds) {
                Integer num = threshold.getNum();
                String name = threshold.getName();
                it.getData().add(num);
                it.getNames().add(name);
            }
        });
    }

    //获取通知项
    public List<NotificationItemVO> getNotificationItems() {
        List<Thresholds> thresholds = thresholdsDao.select(c -> c);
        return thresholds.stream().map(NotificationItemVO::transformFromThreshold).collect(Collectors.toList());
    }

    //通知项选择
    @Transactional
    public int chooseNotificationItem(ChooseNotificationDTO dto) {
        AtomicInteger rows = new AtomicInteger();
//        lambda表达式中使用的变量应该是final或者是有效的final
//        在lambda表达式中对变量的操作都是基于原变量的副本，不会影响到原变量的值。假定没有要求lambda表达式外部变量为final修饰，那么开发者会误以为外部变量的值能够在lambda表达式中被改变，而这实际是不可能的，所以要求外部变量为final是在编译期以强制手段确保用户不会在lambda表达式中做修改原变量的操作；
//        其实这就要说到JVM内存模型和线程了，因为实例变量存在堆中，而局部变量是在栈上分配，lambda表达式（匿名内部类）会在另一个线程中执行。如果在线程中要直接访问一个局部变量，可能线程执行时该局部变量已经被销毁了，而final类型的局部变量在lambda表达式（匿名类）中其实是局部变量的一个拷贝。
//        原文链接：https://blog.csdn.net/qq_42582773/article/details/126679111
        dto.getChoiceOpenList().forEach(id -> {
                int rt = thresholdsDao.update(c ->
                    c.set(Tables.thresholds.on).equalTo(1)
                    .where(Tables.thresholds.id,isEqualTo(id))
                );
                rows.set(rows.get() + rt);
            }
        );

        dto.getChoiceCloseList().forEach(id -> {
                int rt = thresholdsDao.update(c ->
                            c.set(Tables.thresholds.on).equalTo(0)
                            .where(Tables.thresholds.id,isEqualTo(id))
                );
                rows.set(rows.get() + rt);
            }
        );

        return rows.get();

    }


    //通知记录
    public PageVO<NotificationRecordVO> getNotificationRecord(NotificationRecordDTO dto) {

        PageVO<NotifyRecord> notifyRecordList = new PageVO<>(dto.getPageId(),dto.getPageSize(),() ->
            notifyRecordDao.select(c -> c.orderBy(Tables.notifyRecord.createTime.descending()))
        );

        if (notifyRecordList.getData() == null || notifyRecordList.getData().isEmpty()) return new PageVO<>(notifyRecordList.getPageId(), notifyRecordList.getPageSize(), notifyRecordList.getTotalCount(), new ArrayList<>());

        List<User> users = userDao.select(c -> c);
        Map<Long, String> userId2Name = users.stream().collect(Collectors.toMap(User::getId, User::getName));
        List<Thresholds> thresholds = thresholdsDao.select(c -> c);
        Map<Long, String> thresholdId2Name = thresholds.stream().collect(Collectors.toMap(Thresholds::getId,Thresholds::getName));

        return FunctionUtil.apply(new PageVO<>(notifyRecordList.getPageId(), notifyRecordList.getPageSize(), notifyRecordList.getTotalCount(), new ArrayList<>()), pagevo -> pagevo.setData(notifyRecordList.getData().stream().map((model) -> FunctionUtil.apply(new NotificationRecordVO(), it -> {
            it.setCreateTime(model.getCreateTime());
            it.setStatus(model.getStatus());
            List<String> userNames = Arrays.stream(model.getUserIds().split(",")).map(Long::valueOf).map(userId2Name::get).collect(Collectors.toList());
            List<String> notifyNames = null;
            if (!model.getNotifyItemIds().isEmpty()) {
                notifyNames = Arrays.stream(model.getNotifyItemIds().split(",")).map(Long::valueOf).map(thresholdId2Name::get).collect(Collectors.toList());
            }
            it.setUsers(userNames);
            it.setNotifyItems(notifyNames);
        })).collect(Collectors.toList())));
    }

    //当前通知状态获取
    public CurrentStatusVO getCurrentStatus(){
        CurrentStatusVO CurrentStatus= switchTableDao.getCurrentStatus(select(
                Tables.switchTable.open,Tables.switchTable.openWeek,Tables.switchTable.startTime,Tables.switchTable.endTime, Tables.switchTable.frequency)
                .from(Tables.switchTable)
                .build()
                .render(RenderingStrategies.MYBATIS3)
        );
        return CurrentStatus;
    }

    //通知开关修改
    public void openChange(OpenDTO dto){
        int cvalue=dto.getOpenValue();
        int frequency = dto.getFrequency();
        switchTableDao.update(
                    c->c.set(Tables.switchTable.open).equalTo(cvalue)
                            .set(Tables.switchTable.frequency).equalTo(frequency)
            );
//        // 设置cron时间
//        String cron = String.format("0 */%d * * * ?", frequency);
        if (cvalue == SwitchEnum.CLOSE.getCode()) {
            notificationScheduleTaskV2.stopTask();
            return;
        }
        notificationScheduleTaskV2.changePeriod(frequency* 60L);
    }

    //周末预警修改
    public void openWeekChange(OpenWeekDTO dto){
        int cvalue=dto.getOpenWeekValue();
        switchTableDao.update(
                c->c.set(Tables.switchTable.openWeek).equalTo(cvalue)
        );
    }

    //接收时间修改
    public void receivetimeChange(ReceiveTimeDTO dto){
        Date cstart=dto.getStartTime();
        Date cend=dto.getEndTime();
        switchTableDao.update(
                c->c.set(Tables.switchTable.startTime).equalTo(cstart)
                        .set(Tables.switchTable.endTime).equalTo(cend)
        );
    }

    //文本预览
    public List<TextPreviewVO> getTextPreview(){
        List<TextPreviewVO> TextPreview=thresholdsDao.getTextPreview(select(
                Tables.thresholds.id,Tables.thresholds.nowIndex,Tables.thresholds.setIndex)
                .from(Tables.thresholds)
                .limit(5)
                .build()
                .render(RenderingStrategies.MYBATIS3)
        );
        return TextPreview;
    }


}
