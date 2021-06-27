package com.guanting.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


public class UUIDGenerator {

    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        // 去掉"-"符号
        String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24,25);
        return temp;
    }

    //生成9随机数字
    public static Integer getOrderNo(){
        return (int)(Math.random() * (400000000 -100000000)) + 100000000;
    }

    //生成4位随机数字
    public static String getRandomNumber(){
        return String.valueOf((int) ((Math.random() * 9 + 1) * 1000));
    }

    /**
     * 获取主键序列（格式：yyMMDD+四位随机数）
     * @return Integer
     */
    public static Integer getSequence() {
        //获取年月日
        DateFormat dateFormat = new SimpleDateFormat("yyMMDD");
        String sDate = dateFormat.format(new Date());
        //获取四位随机数
        int random = (int) (Math.random() * 9000 + 1000);

        String result = sDate + random;

        return Integer.valueOf(result);
    }

    public static void main(String[] args) {
        //String abc =  getUUID();
    }
}
