package cn.qkl.common.framework.util;

import cn.qkl.common.framework.exception.ServerException;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.SqlColumn;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author wangjun
 * @date 2022/4/27 19:30
 */
public class SqlUtil {

    /**
     * 把数据库表所有列转换为逗号分割的字符串
     *
     * <pre>
     *     示例：
     *     allColumn(xxxMapper.selectList)  -> "id, xxx_xxx, xxx_xxx"
     *
     *     定义：
     *     <code>@</code>Select("select ${columns} from xxx where column = ${condition}")
     *     T selectXxx(String columns, String condition);
     *
     *     调用：
     *     selectXxx(allColumn(xxxMapper.selectList), condition);
     * </pre>
     *
     * @param columns 数据库列数组
     * @return 逗号分割的数据库原生字符串
     */
    public static String allColumn(BasicColumn[] columns) {
        if (columns == null || columns.length == 0) {
            throw new ServerException("目标列不能为空");
        }
        return Arrays.stream(columns).map(c ->
                ((SqlColumn<?>) c).name()
        ).collect(Collectors.joining(","));
    }

    /**
     * 把数据库表选择的列转换为逗号分割的字符串
     *
     * <pre>
     *     示例：
     *     selectColumn(Tables.xxx.id, Tables.xxx.xxx, Tables.xxx.xxx)  -> "id, xxx_xxx, xxx_xxx"
     *
     *     定义：
     *     <code>@</code>Select("select ${columns} from xxx where column = ${condition}")
     *     T selectXxx(String columns, String condition);
     *
     *     调用：
     *     selectXxx(selectColumn(Tables.xxx.id, Table.xxx.userName, ...), condition);
     * </pre>
     *
     * @param columns 数据库列数组
     * @return 数据库分割的原生字符串
     */
    public static String selectColumn(SqlColumn<?>... columns) {
        if (columns == null || columns.length == 0) {
            throw new ServerException("目标列不能为空");
        }
        return Arrays.stream(columns).map(SqlColumn::name).collect(Collectors.joining(","));
    }

    /**
     * @param value 待过滤字符串
     * @return 转义后的字符串
     */
    public static String likeValueFilter(String value) {
        return Objects.requireNonNull(value).trim().replace("\\", "\\\\")
                .replace("'", "\\'")
                .replace("%", "\\%")
                .replace("_", "\\_");
    }

    /**
     * 根据目标字符串，返回模糊匹配字符串表达式(全模糊)
     * <pre>
     *     null  ->  null
     *     ""    ->  null
     *     "xxx" ->  "%xxx%"
     *
     *     使用方式：
     *     select(c -> c
     *          .where(Tables.xxx.xxx, isLikeWhenPresent(allLike(xxx)))
     *     );
     *
     * </pre>
     *
     * @param columnValue 目标字符串
     * @return 模糊匹配表达式
     */
    public static String allLike(String columnValue) {
        return columnValue == null || columnValue.equals("") ? null : "%" + likeValueFilter(columnValue) + "%";
    }

    public static String allLike(Long columnValue) {
        return columnValue == null ? null : "%" + columnValue + "%";
    }

    /**
     * 根据目标字符串，返回模糊匹配字符串表达式(左模糊)
     * <pre>
     *     null  ->  null
     *     ""    ->  null
     *     "xxx" ->  "%xxx"
     *
     *     使用方式：
     *     select(c -> c
     *          .where(Tables.xxx.xxx, isLikeWhenPresent(leftLike(xxx)))
     *     );
     * </pre>
     *
     * @param columnValue 目标字符串
     * @return 模糊匹配表达式
     */
    public static String leftLike(String columnValue) {
        return columnValue == null || columnValue.equals("") ? null : "%" + likeValueFilter(columnValue);
    }

    /**
     * 根据目标字符串，返回模糊匹配字符串表达式(右模糊)
     * <pre>
     *     null  ->  null
     *     ""    ->  null
     *     "xxx" ->  "xxx%"
     *
     *     使用方式：
     *     select(c -> c
     *          .where(Tables.xxx.xxx, isLikeWhenPresent(rightLike(xxx)))
     *     );
     * </pre>
     *
     * @param columnValue 目标字符串
     * @return 模糊匹配表达式
     */
    public static String rightLike(String columnValue) {
        return columnValue == null || columnValue.equals("") ? null : likeValueFilter(columnValue) + "%";
    }

    /**
     * 调用元素的<code>toString()</code>方法，把列表转换成<code>in</code>表达式
     * <pre>
     *     列表不能为空
     *     [aaa, bbb, ccc] -> (aaa, bbb, ccc)
     *
     *     定义：
     *     <code>@</code>Select("select * from xxx where column in ${listStr}")
     *     T selectXxx(String listStr);
     *
     *     调用：
     *     selectXxx(list2InStr(list));
     * </pre>
     *
     * @param list 目标列表
     * @return 目标字符串
     */
    public static String list2InStr(List<? extends Number> list) {
        if (list == null || list.size() == 0) {
            throw new ServerException("列表不能为空");
        }
        return list.stream().map(Object::toString)
                .collect(Collectors.joining(",", "(", ")"));
    }
}
