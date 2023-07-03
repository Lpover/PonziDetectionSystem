package cn.qkl.webserver.service;

import cn.qkl.common.framework.response.PageVO;
import cn.qkl.common.framework.util.FunctionUtil;
import cn.qkl.common.repository.Tables;
import cn.qkl.common.repository.model.NotifyRecord;
import cn.qkl.common.repository.model.Thresholds;
import cn.qkl.common.repository.model.User;
import cn.qkl.webserver.dao.NotifyRecordDao;
import cn.qkl.webserver.dao.ThresholdsDao;
import cn.qkl.webserver.dao.UserDao;
import cn.qkl.webserver.dto.noticification.ChooseNotificationDTO;
import cn.qkl.webserver.dto.noticification.NotificationRecordDTO;
import cn.qkl.webserver.vo.notification.NotificationItemVO;
import cn.qkl.webserver.vo.notification.NotificationNumbersVO;
import cn.qkl.webserver.vo.notification.NotificationRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

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
                    c.set(Tables.thresholds.on).equalTo((byte) 1)
                    .where(Tables.thresholds.id,isEqualTo(id))
                );
                rows.set(rows.get() + rt);
            }
        );

        dto.getChoiceCloseList().forEach(id -> {
                int rt = thresholdsDao.update(c ->
                            c.set(Tables.thresholds.on).equalTo((byte) 0)
                            .where(Tables.thresholds.id,isEqualTo(id))
                );
                rows.set(rows.get() + rt);
            }
        );

        return rows.get();

    }


    //通知记录
    public PageVO<NotificationRecordVO> getNotificationRecord(NotificationRecordDTO dto) {
        List<User> users = userDao.select(c -> c);
        Map<Long, String> userId2Name = users.stream().collect(Collectors.toMap(User::getId, User::getName));
        List<Thresholds> thresholds = thresholdsDao.select(c -> c);
        Map<Long, String> thresholdId2Name = thresholds.stream().collect(Collectors.toMap(Thresholds::getId,Thresholds::getName));

        PageVO<NotifyRecord> notifyRecordList = new PageVO<>(dto.getPageId(),dto.getPageSize(),() ->
            notifyRecordDao.select(c -> c)
        );
        return FunctionUtil.apply(new PageVO<>(notifyRecordList.getPageId(), notifyRecordList.getPageSize(), notifyRecordList.getTotalCount(), null), pagevo -> {
            pagevo.setData(notifyRecordList.getData().stream().map((model) -> FunctionUtil.apply(new NotificationRecordVO(), it -> {
                it.setCreateTime(model.getCreateTime());
                it.setStatus(model.getStatus());
                List<String> userNames = Arrays.stream(model.getUserIds().split(",")).map(Long::valueOf).map(userId2Name::get).collect(Collectors.toList());
                List<String> notifyNames = Arrays.stream(model.getNotifyItemIds().split(",")).map(Long::valueOf).map(thresholdId2Name::get).collect(Collectors.toList());
                it.setUsers(userNames);
                it.setNotifyItems(notifyNames);
            })).collect(Collectors.toList()));
        });
    }
}
