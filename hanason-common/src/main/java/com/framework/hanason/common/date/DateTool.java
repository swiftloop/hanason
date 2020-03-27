package com.framework.hanason.common.date;



import com.framework.hanason.common.annotation.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * @author sorata 2020-03-16 14:52
 */
public final class DateTool {

    private DateTool() {
        throw new AssertionError("工具类不能使用构造函数，请使用静态方法");
    }

    @NotNull
    public static Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    @NotNull
    public static Date toDate(LocalDate localDate) {
        return Date.from(localDate.atTime(0, 0, 0, 0).atZone(ZoneId.systemDefault()).toInstant());
    }

    @NotNull
    public static LocalDateTime toLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    @NotNull
    public static LocalDate toLocalDate(Date date) {
        return LocalDate.from(LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()));
    }


    @NotNull
    public static String format(String format, TemporalAccessor date) {
        return DateTimeFormatter.ofPattern(format).format(date);
    }
}
