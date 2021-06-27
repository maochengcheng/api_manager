package com.guanting.manager.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
    static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static SimpleDateFormat formatters = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");

    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

    public static String getDataForm(String str) {
        String dateString=null;
        try {
            Date date = simpleDateFormat.parse(str);
         dateString = formatter.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateString;
    }

    public static String getDataStrFormats(Date date) {
        return formatters.format(date);
    }
}
