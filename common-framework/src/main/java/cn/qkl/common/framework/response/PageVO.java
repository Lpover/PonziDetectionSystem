package cn.qkl.common.framework.response;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Data
public class PageVO<T> {
    // 当前页码
    private int pageId;
    // 页尺寸
    private int pageSize;
    // 总页数
    private int pageCount;
    // 总条数
    private int totalCount;
    // 当页数据
    private List<T> data;

    public PageVO() {

    }

    public PageVO(int pageSize) {
        pageId = 1;
        if (pageSize <= 0) {
            pageSize = 10;
        }
        this.pageSize = pageSize;
        this.totalCount = 0;
        this.pageCount = 0;
        this.data = new ArrayList<>();
    }

    public PageVO(int pageId, int pageSize, Supplier<List<T>> supplier) {
        if (pageId <= 0) {
            pageId = 1;
        }
        if (pageSize <= 0) {
            pageSize = 10;
        }

        PageInfo<T> pageInfo = PageHelper.startPage(pageId, pageSize).doSelectPageInfo(supplier::get);
        this.pageId = pageId;
        this.pageSize = pageSize;
        this.totalCount = (int) pageInfo.getTotal();
        this.pageCount = pageInfo.getPages();
        this.data = pageInfo.getList();
        PageHelper.clearPage();
    }

    public PageVO(int pageId, int pageSize, int totalCount, List<T> data) {
        if (pageId <= 0) {
            pageId = 1;
        }
        if (pageSize <= 0) {
            pageSize = 10;
        }
        this.pageId = pageId;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.data = data;
        this.pageCount = this.totalCount / this.pageSize + (this.totalCount % this.pageSize == 0 ? 0 : 1);
    }

    /**
     * 分页查询 直接对list处理
     * 例子：PageVO.getPageData(req.getPageNo(), req.getPageSize(), list);
     *
     * @param pageId   页数
     * @param pageSize 每页大小
     * @param list     结果集
     * @param <T>      放回对象
     * @return PageData
     */
    public static <T> PageVO<T> getPageData(int pageId, int pageSize, List<T> list) {
        //创建Page类
        Page<T> page = new Page<>(pageId, pageSize);
        //为Page类中的total属性赋值
        page.setTotal(list.size());
        //计算当前需要显示的数据下标起始值
        int startIndex = (pageId - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, list.size());
        //从链表中截取需要显示的子链表，并加入到Page
        page.addAll(list.subList(startIndex, endIndex));
        //以Page创建PageInfo
        PageInfo<T> pageInfo = new PageInfo<>(page);
        return new PageVO<T>(pageId, pageSize, (int) pageInfo.getTotal(), pageInfo.getList());
    }

    public static <T> PageVO<T> getPageData(int pageId, int pageSize, Supplier<List<T>> supplier) {
        if (pageId > 0 && pageSize > 0) {
            PageHelper.startPage(pageId, pageSize);
        }
        List<T> list = supplier.get();
        PageHelper.clearPage();
        PageInfo<T> pageRes = new PageInfo<>(list);
        return new PageVO<>(pageId, pageSize, (int) pageRes.getTotal(), pageRes.getList());
    }


    public static <T, R> PageVO<R> getPageData(int pageId, int pageSize, Supplier<List<T>> supplier, Function<T, R> transfer) {
        if (pageId > 0 && pageSize > 0) {
            PageHelper.startPage(pageId, pageSize);
        }
        List<T> list = supplier.get();
        PageHelper.clearPage();
        PageInfo<T> pageRes = new PageInfo<>(list);
        return new PageVO<>(pageId, pageSize, (int) pageRes.getTotal(), list.stream().map(transfer).collect(Collectors.toList()));
    }
}
