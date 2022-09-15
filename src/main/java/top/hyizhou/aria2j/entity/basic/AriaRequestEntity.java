package top.hyizhou.aria2j.entity.basic;

import com.alibaba.fastjson2.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.hyizhou.aria2j.entity.Order;
import top.hyizhou.aria2j.entity.params.Params;
import top.hyizhou.aria2j.util.Aria2Exception;
import top.hyizhou.aria2j.util.ParamsUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * aria2 rpc调用所用的报文对象 <br/>q
 * 由于aria2调用的大部分方法参数部分都传入的是一个数组，且根据数组中元素位置来确定参数类型 <br/>
 * 因此需要将参数对象重新解析为数组后才能能进行序列化
 * @author hyizhou
 * @date 2022/8/12 15:02
 */
public class AriaRequestEntity extends RpcRequest{
    /** 通过set/get方法实现覆盖父类属性，属性不能直接被覆盖，是私有的局部的 */
    private List<Object> params;

    public AriaRequestEntity(){
        setJsonrpc("2.0");
    }

    @Override
    public List<Object> getParams() {
        return params;
    }

    /**
     * 向params列表中添加元素
     * @param obj 被添加的元素
     */
    public void addParams(Object obj){
        if (this.params == null){
            this.params = new ArrayList<>();
        }
        this.params.add(obj);
    }


    /**
     * 此方法存在主要是为了覆盖父类方法，作用以与父类方法不同，本方法将实体类的字段依次添加到params列表 <br/>
     * 传入bean对象，通过字段注解{@link Order}标定的顺序，依次将值添加到params字段表 <br/>
     * 注：本方法每次调用都会丢弃之前的params而创建新的对象，不能使用本方法多次添加多个对象
     * @param params 必须继承于{@link Params}接口
     */
    @Override
    public void setParams(Object params) {
        if (Objects.isNull(params)){
            this.params = null;
            return;
        }
        if (!(params instanceof Params)){
            throw new Aria2Exception("类型错误 -- 所给参数必须为Params接口类型");
        }
        Logger log = LoggerFactory.getLogger(AriaRequestEntity.class);
        // 添加新的参数时创建新的字段对象
        this.params = new ArrayList<>();
        // 若参数为空，则不向params中添加元素

        List<Integer> orderList = new ArrayList<>();
        Class<?> clazz = params.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields){
            log.trace("现在处理字段：{}", field.getName());
            if (field.isAnnotationPresent(Order.class)) {
                int order = field.getAnnotation(Order.class).value();
                String fieldName = field.getName();
                Object fieldValue;
                try {
                    Method method = clazz.getMethod("get"+fieldName.substring(0, 1).toUpperCase()
                            +fieldName.substring(1));
                    fieldValue = method.invoke(params);
                    if (fieldValue == null){
                        log.trace("[{}]字段值为null，跳过", fieldName);
                        continue;
                    }
                    // token字段需要特殊处理
                    if ("token".equals(fieldName)){
                        fieldValue = "token:"+fieldValue;
                    }
                    log.trace("[{}]字段获取到参数为：{}", fieldName, fieldValue);
                } catch (NoSuchMethodException e) {
                    // 若该字段没有get方法，则跳过
                    log.trace("没有找到这样的方法：", e);
                    continue;
                } catch (InvocationTargetException e) {
                    log.trace("调用异常：", e);
                    continue;
                } catch (IllegalAccessException e) {
                    log.trace("非法访问: ", e);
                    continue;
                }

                if (orderList.size() == 0){
                    orderList.add(order);
                    this.params.add(fieldValue);
                    log.trace("添加第一个元素:{} - {}",fieldName, fieldValue);
                    continue;
                }
                int orderListSize = orderList.size();
                for (int i = 0; i < orderListSize; i++) {
                    if (order < orderList.get(i)){
                        orderList.add(i, order);
                        this.params.add(i, fieldValue);
                        break;
                    }
                    // 最后一个排序值也比当前值大，则添加到尾部
                    if (i == orderListSize - 1){
                        orderList.add(order);
                        this.params.add(fieldValue);
                    }
                }
            }
        }
    }

    private static AriaRequestEntity baseCreate(String method){
        AriaRequestEntity obj = new AriaRequestEntity();
        obj.setMethod(method);
        obj.setId(UUID.randomUUID().toString().replaceAll("-",""));
        return obj;
    }

    /**
     * 供方便创建本实体类对象
     * @param method 方法名
     * @param params 参数列表，注意前后顺序
     * @return 创建完成的本对象
     */
    public static AriaRequestEntity create(String method, Object... params){
        AriaRequestEntity obj = baseCreate(method);
        obj.params = ParamsUtil.create(params);
        return obj;
    }

    /**
     * 供方便创建本对象
     * @param method 方法名
     * @param paramObj 参数对象，需要继承{@link Params}接口
     * @return 创建完成的本对象
     */
    @Deprecated
    public static AriaRequestEntity create(String method, Params paramObj){
        AriaRequestEntity obj = baseCreate(method);
        obj.setParams(paramObj);
        return obj;
    }


    /**
     * 将实体类序列化为json字符
     * @return json字符串
     */
    public String toJson(){
        return JSONObject.toJSONString(this);
    }

}
