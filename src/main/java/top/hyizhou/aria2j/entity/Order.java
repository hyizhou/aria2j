package top.hyizhou.aria2j.entity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标注参数顺序
 * @author hyizhou
 * @date 2022/8/12 14:48
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Order {
    /** 数字越小越靠前 */
    int value();
}
