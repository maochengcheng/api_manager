package com.guanting.common.utils;

import java.util.ArrayList;
import java.util.List;


public class StringUtil {

    /**
     * 将String字符串转换成任意类型的集合（前提：自己必须确定类型转换不会出错）
     *
     * @param source      源字符串
     * @param regex       切割规则
     * @param targetClass 目标类型
     * @return List
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> strArray2List(String source, String regex, Class<T> targetClass) {
        List<T> tList = new ArrayList<>();
        String[] sources = source.split(regex);
        //Integer
        if (Integer.class.equals(targetClass)) {
            for (String s : sources) {
                tList.add((T) Integer.valueOf(s));
            }
            //Long
        } else if (Long.class.equals(targetClass)) {
            for (String s : sources) {
                tList.add((T) Long.valueOf(s));
            }
            //Short
        } else if (Short.class.equals(targetClass)) {
            for (String s : sources) {
                tList.add((T) Short.valueOf(s));
            }
            //String
        } else if (String.class.equals(targetClass)) {
            for (String s : sources) {
                tList.add((T) String.valueOf(s));
            }
        }
        return tList;
    }

    /**
     * 拼接字符串转成带单引号的拼接字符串
     *
     * @param source     源字符串
     * @param splitRegex 切割规则
     * @param mergeRegex 拼接规则
     * @return String
     */
    public static String strToStrMark(String source, String splitRegex, String mergeRegex) {
        if (source == null || source.length() <= 0) {
            return "";
        }

        String[] arr = source.split(splitRegex);
        StringBuilder str = new StringBuilder("");
        for (String s : arr) {
            str.append("'").append(s).append("'").append(mergeRegex);
        }

        return str.substring(0, str.length() - 1);
    }

    /**
     * list转String
     *
     * @param list  源集合
     * @param regex 拼接规则
     * @return String
     */
    public static String list2Str(List<String> list, String regex) {
        if (list == null || list.size() <= 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (String string : list) {
            sb.append(string).append(regex);
        }

        return sb.substring(0, sb.length() - 1);
    }

    /**
     * 2,1,3,5 转 星期二,星期一,星期三,星期五
     *
     * @param source 源字符串
     * @param regex  切割规则
     * @return
     */
    public static String weekToweek(String source, String regex) {
        if (source.length() <= 0) {
            return "";
        }

        String[] week = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};
        String[] weeks = source.split(regex);

        StringBuilder sbWeek = new StringBuilder("");
        for (String s : weeks) {
            sbWeek.append(week[Integer.parseInt(s) - 1]).append(",");
        }

        return sbWeek.substring(0, sbWeek.length() - 1);
    }
}
