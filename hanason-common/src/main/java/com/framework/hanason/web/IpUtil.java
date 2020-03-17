package com.framework.hanason.web;

/**
 * @author sorata 2020-03-17 09:42
 */
public final class IpUtil {

    private IpUtil() {
        throw new AssertionError("工具类不能使用构造函数，请使用静态方法");
    }

    public static long toIpLong(String ip) {
        if (ip == null || ip.isEmpty()) {
            return 0;
        }
        String[] split = ip.split("\\.");
        if (split.length != 4) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            int anInt = Integer.parseInt(s);
            if (anInt > 255 || anInt < 0) {
                return 0;
            }
            sb.append(toBinary(anInt, 8));
        }

        return Long.parseLong(sb.toString(), 2);
    }

    public static String toIpString(Long ip) {
        String binaryString = longToBinary(ip, 32);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            sb.append(Integer.parseInt(binaryString.substring(i * 8, i * 8 + 8), 2))
                    .append(".");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }


    /**
     * 将一个int数字转换为二进制的字符串形式。
     *
     * @param num    需要转换的int类型数据
     * @param digits 要转换的二进制位数，位数不足则在前面补0
     * @return 二进制的字符串形式
     */
    private static String toBinary(int num, int digits) {
        String cover = Integer.toBinaryString(1 << digits).substring(1);
        String s = Integer.toBinaryString(num);
        return s.length() < digits ? cover.substring(s.length()) + s : s;
    }

    /**
     * 将一个int数字转换为二进制的字符串形式。
     *
     * @param num    需要转换的int类型数据
     * @param digits 要转换的二进制位数，位数不足则在前面补0
     * @return 二进制的字符串形式
     */
    private static String longToBinary(long num, int digits) {
        String cover = Long.toBinaryString(1L << digits).substring(1);
        String s = Long.toBinaryString(num);
        return s.length() < digits ? cover.substring(s.length()) + s : s;
    }


}
