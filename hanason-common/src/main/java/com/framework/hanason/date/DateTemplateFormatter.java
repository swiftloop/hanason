package com.framework.hanason.date;


import com.framework.hanason.annotation.NotNull;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author sorata 2020-03-16 13:37
 */
public final class DateTemplateFormatter {

    private DateTemplateFormatter() {
        throw new AssertionError("工具类不能使用构造函数，请使用静态方法");
    }


    /**
     * 年月日
     */
    public static final String YYYYMMDD = "yyyyMMdd";

    /**
     * 年月日时分秒
     */
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    /**
     * 年月日文本式
     */
    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    /**
     * 年月日时分秒文本式
     */
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    @NotNull
    public static String format(String format, Date date) {
        return new SimpleDateFormat(format).format(date);
    }

    @NotNull
    public static String formatV8(String format, Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        return DateTimeFormatter.ofPattern(format).format(localDateTime);
    }

}
