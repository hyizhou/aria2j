package top.hyizhou.aria2j.util;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 生成请求报文中params参数的工具类
 * @author huanggc
 * @date 2022/8/25 17:17
 */
public class ParamsUtil {

    /**
     * 将所给的参数数组解析为list，并去除其中null数值
     * @param params 参数数组
     * @return 若是参数全为null或无参数，则返回null
     */
    public static List<Object> create(Object... params){
        if (Objects.isNull(params) || params.length == 0){
            return null;
        }
        // 数组中去掉null元素，然后转换成list
        List<Object> rtn = Arrays.stream(params).filter(Objects::nonNull).collect(Collectors.toList());
        // 判断转换的list中是否为空，为空则替换成null
        if (rtn.size() == 0){
            return null;
        }
        return rtn;
    }
}
