package com.framework.hanason.common.random;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author sorata 2020-03-24 15:08
 */
public class IdGenerator {

    private static final ZoneId ZONE_ID = ZoneId.of("UTC+8");

    private static final char[] NUMBERS = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

    private static final char[] CHARS = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z'};


    public static String getOrderId(String tag) {
        return tag + DateTimeFormatter.ofPattern("yyyyMMddHHmmss", Locale.CHINA).
                format(LocalDateTime.now(ZONE_ID)) + RandomUtil.randStr(6);
    }

    public static String randStr(int len) {
        if (len <= 0) {
            return "";
        }
        char[] chars = new char[len];
        for (int i = 0; i < len; i++) {
            chars[i] = CHARS[ThreadLocalRandom.current().nextInt(CHARS.length)];
        }
        return new String(chars);
    }

    public static String randStr2(int len) {
        if (len <= 0) {
            return "";
        }
        char[] chars = new char[len];
        for (int i = 0; i < len; i++) {
            chars[i] = CHARS[new Random().nextInt(CHARS.length)];
        }
        return new String(chars);
    }


}
