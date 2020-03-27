package com.framework.hanason.common.annotation;

import java.lang.annotation.*;

/**
 * @author sorata 2020-03-16 13:58
 *
 * 标记注解 不允许为空 看到此注解的参数需要先判空才能传递
 */
@Target(value = {ElementType.ANNOTATION_TYPE,ElementType.FIELD,ElementType.LOCAL_VARIABLE,
ElementType.TYPE_PARAMETER,ElementType.METHOD,ElementType.PARAMETER})
@Retention(RetentionPolicy.CLASS)
@Documented
public @interface NotNull {
}
