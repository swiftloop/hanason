package com.framework.hanason.common.random;

import com.alibaba.fastjson.JSON;
import com.framework.hanason.common.exception.NumberAccessException;

import java.util.Arrays;

/**
 * @author sorata 2020-03-17 11:04
 */
public final class RandomUtil {

    private RandomUtil() {
        throw new AssertionError("工具类不能使用构造函数，请使用静态方法");
    }

    /**
     * 获取一个随机的数字，位数不大于9
     * @param len 数字的位数
     * @return int
     */
    public static int ofInt(int len) {
        if (len > 9){
            throw new NumberAccessException(500,"超出随机范围");
        }
        double random = Math.random();
        while (random < 0.1f) {
            random = Math.random();
        }
        return (int) (random * Math.pow(10, len));
    }


    public static long ofLong(long len){
        if (len > 15){
            throw new NumberAccessException(500,"超出随机范围");
        }
        double random = Math.random();
        while (random < 0.1f) {
            random = Math.random();
        }
        return (long) (random * Math.pow(10, len));
    }



    public static String randStr(int len){
        return String.valueOf(ofInt(len));
    }




    public static void main(String[] args) {
        System.out.println(Math.random());
        System.out.println(ofInt(9));
        System.out.println(ofLong(14L));
        System.out.println(3 << 2 | 1 << 1);
        // long 64位 int 32
        System.out.println(127 << 24 | 255 << 16 | 255<< 8 | 255);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(255 << 8);
        System.out.println(Integer.toBinaryString(255 << 8));

        String ip = "8.8.8.8";
        String[] nodes = ip.split("\\.");
        System.out.println(JSON.toJSONString(nodes));
        long a = Integer.parseInt(nodes[0]) << 24 | Integer.parseInt(nodes[1]) << 16 |
                Integer.parseInt(nodes[2]) << 8 | Integer.parseInt(nodes[3]);
        System.out.println( a);
        //System.out.println(IpUtil.toIpString(a));
        System.out.println(Arrays.toString(new long[]{a >> 24,a >>16 & 0xff,a >>8 &0xff, a & 0xff }));
        System.out.println(Long.toBinaryString(a >> 24));
        System.out.println(Long.toBinaryString(a >> 16));
        System.out.println(Long.toBinaryString( a >> 16 & 0xff));

        int e = 1, b=2,c =3;
        System.out.println("e = " + e + "  b=" +b );
        e = e ^ b;
        System.out.println( e);
        b = e ^ b;
        System.out.println(b);
        e = e ^ b;
        System.out.println(e);
        System.out.println("e = " + e + "  b=" +b );

        int code[] = {11,32,42,1,34,22};
        byte key[] = "a%%d@!eEdHGGF2323#@$52accdiasjdhuhwuhduad21i321h4UHGFUIGEOIEJee".getBytes();


        int[] ints = new int[code.length];
        for (int i = 0; i < code.length; i++) {
            ints[i] = code[i] ^  (( i > key.length) ? (int) key[i & key.length] : (int) key[i]);
        }
        System.out.println(Arrays.toString(ints));
        for (int i = 0; i < ints.length; i++) {
            ints[i] = ints[i] ^ (( i > key.length) ? (int) key[i & key.length] : (int) key[i]);
        }
        System.out.println(Arrays.toString(ints));
        System.out.println(11 ^ 6 ^ 11);



    }



}
