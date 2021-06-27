package com.guanting.common.utils;

import org.apache.commons.lang3.time.DateUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtil {

    public static String getDateYDMHMS() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public static String getDateYDMHMS(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

    public static String getDateYDM(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    public static String getDateYMD(Date date) {
        return new SimpleDateFormat("yyyyMMdd").format(date);
    }

    public static String getDateYM(Date date) throws ParseException {
        return new SimpleDateFormat("yyyy-MM").format(date);
    }

    public static String getDateMD(Date date) throws ParseException {
        return new SimpleDateFormat("MM-dd").format(date);
    }

    public static String getDateHm(Date date) throws ParseException {
        return new SimpleDateFormat("HH:mm").format(date);
    }

    public static Date parse(String strDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(strDate);
    }

    public static Date parseYMDHSM(String strDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.parse(strDate);
    }

    public static Date parseHSM(String strDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.parse(strDate);
    }

    public static String parseStrYMD(String strDate) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
        String nowDate = new SimpleDateFormat("yyyyMMdd").format(date);
        return nowDate;
    }

    public static Date parseDateYMD(Date date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = sdf.format(date);
        return sdf.parse(strDate);
    }

    public static Date parseDateYMDHSM(Date date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = sdf.format(date);
        return sdf.parse(strDate);
    }

    public static String getNowYear() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        return sdf.format(new Date());
    }

    /**
     * 获取 N 天前的日期
     *
     * @param day
     * @return
     */
    public static Date getDateByDay(int day) throws ParseException {
        Calendar calendar1 = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        calendar1.add(Calendar.DATE, -day);
        String date = sdf.format(calendar1.getTime());
        return sdf.parse(date);
    }

    /**
     * 比较两个日期之间的天数(firstDate比secondDate大几天)
     *
     * @param firstDate  第一个日期
     * @param secondDate 第二个日期
     * @return
     */
    public static int getDiffDaysBetween(Date firstDate, Date secondDate) {
        Calendar firstCal = Calendar.getInstance();
        firstCal.setTime(firstDate);
        Integer firstYear = firstCal.get(Calendar.YEAR);

        Calendar secondCal = Calendar.getInstance();
        secondCal.setTime(secondDate);
        Integer secondYear = secondCal.get(Calendar.YEAR);

        if (firstYear == secondYear) {
            return firstCal.get(Calendar.DAY_OF_YEAR) - secondCal.get(Calendar.DAY_OF_YEAR);
        } else if (firstYear > secondYear) {
            return ((firstYear - secondYear) * 365 + firstCal.get(Calendar.DAY_OF_YEAR))
                    - secondCal.get(Calendar.DAY_OF_YEAR);
        } else {
            return -(((secondYear - firstYear) * 365 + secondCal.get(Calendar.DAY_OF_YEAR))
                    - firstCal.get(Calendar.DAY_OF_YEAR));
        }

    }

    public static final String DATEFORMAT = "dateFormat";
    public static final String DATEFORMAT2 = "dateFormat2";
    public static final String DATETIMEFORMAT = "dateTimeFormat";
    public static final String DATETIMEFORMAT2 = "dateTimeFormat2";
    public static final String TIMEFORMAT = "timeFormat";
    public static final String TIMEFORMAT2 = "timeFormat2";
    public static final String DATETIMEFORMAT3 = "dateTimeFormat3";
    public static final String DATETIMEFORMAT4 = "dateTimeFormat4";

    public SimpleDateFormat dateFormatYm = new SimpleDateFormat("yyyy-MM");
    public SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy/MM/dd");
    public SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public SimpleDateFormat dateTimeFormat2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    public SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    public SimpleDateFormat timeFormat2 = new SimpleDateFormat("HH:mm");
    public SimpleDateFormat dateTimeFormat3 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    public SimpleDateFormat dateTimeFormat4 = new SimpleDateFormat("yyyyMMddHHmmss");

    /**
     * 获取星期
     *
     * @param date 日期
     * @return 1-星期一，2-星期二，...7-星期日
     */
    public int getWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int weekday = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (weekday <= 0) {
            weekday = 7;
        }
        return weekday;
    }

    /**
     * 获取小时
     *
     * @param date
     * @return
     */
    public int getHour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    public Date formatTime(String time) throws ParseException {
        Date date = null;
        if (time.indexOf("/") != -1) {
            date = new SimpleDateFormat("yyyy/MM/dd HH:mm").parse(time);
        } else {
            date = new SimpleDateFormat("HH:mm").parse(time);
        }
        return date;
    }

    /**
     * 获取星期字符串
     *
     * @param date 日期
     * @return 星期字符串
     */
    public String getWeekStr(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (week < 0) {
            week = 0;
        }
        String[] weeks = new String[]{"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        return weeks[week];
    }

    /**
     * 根据Date获取当天开始时间
     *
     * @param date
     * @return
     */
    public static Date getStartByDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 根据Date获取当天结束时间
     *
     * @param date
     * @return
     */
    public static Date getEndByDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    /**
     * @Title: getMonthByDate @Description:
     * date @param @return 参数 (根据时间和想要前几个月) @return Date 返回类型 @throws
     */
    public static Date getMonthByDate(Date date, int y) {
        Calendar ca = Calendar.getInstance();// 得到一个Calendar的实例
        // ca.setTime(new Date()); // 设置时间为当前时间
        ca.setTime(date);
        ca.add(Calendar.MONTH, -y);// 月份减1
        ca.getTime(); // 结果
        return ca.getTime();
    }

    /**
     * 根据Date获取当天中午时间
     *
     * @param date
     * @return
     */
    public Date getMiddleByDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public Date getMonthStartByDate(Date date) {
        return getStartByDate(DateUtils.setDays(date, 1));
    }

    /**
     * date转String
     *
     * @param date
     * @param type
     * @return
     */
    public String format(Object date, String type) {
        String dateStr = null;
        if (date == null) {
            return dateStr;
        }
        try {
            switch (type) {
                case "dateFormat":
                    dateStr = dateFormat.format(date);
                    break;
                case "dateFormat2":
                    dateStr = dateFormat2.format(date);
                    break;
                case "dateTimeFormat":
                    dateStr = dateTimeFormat.format(date);
                    break;
                case "dateTimeFormat2":
                    dateStr = dateTimeFormat2.format(date);
                    break;
                case "dateTimeFormat3":
                    dateStr = dateTimeFormat3.format(date);
                    break;
                case "dateTimeFormat4":
                    dateStr = dateTimeFormat4.format(date);
                    break;
                case "timeFormat":
                    dateStr = timeFormat.format(date);
                    break;
                case "timeFormat2":
                    dateStr = timeFormat2.format(date);
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            return dateStr;
        }

        return dateStr;
    }

    public String getDateStr(Date date) {
        return format(date, DATEFORMAT);
    }

    public int getBetween(Date start, Date end) {
        long from = getStartByDate(start).getTime();
        long to = getStartByDate(end).getTime();
        return (int) ((to - from) / (1000 * 60 * 60 * 24));
    }

    public int getBetween(String start, String end, String type) {
        long from = 0, to = 0;
        try {
            switch (type) {
                case "dateFormat":
                    from = dateFormat.parse(start).getTime();
                    to = dateFormat.parse(end).getTime();
                    break;
                case "dateFormat2":
                    from = dateFormat2.parse(start).getTime();
                    to = dateFormat2.parse(end).getTime();
                    break;
                case "dateTimeFormat":
                    from = dateTimeFormat.parse(start).getTime();
                    to = dateTimeFormat.parse(end).getTime();
                    break;
                case "dateTimeFormat2":
                    from = dateTimeFormat2.parse(start).getTime();
                    to = dateTimeFormat2.parse(end).getTime();
                    break;
                case "dateTimeFormat3":
                    from = dateTimeFormat3.parse(start).getTime();
                    to = dateTimeFormat3.parse(end).getTime();
                    break;
                case "timeFormat":
                    from = timeFormat.parse(start).getTime();
                    to = timeFormat.parse(end).getTime();
                    break;
                case "timeFormat2":
                    from = timeFormat2.parse(start).getTime();
                    to = timeFormat2.parse(end).getTime();
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            return 0;
        }
        return (int) ((to - from) / (1000 * 60 * 60 * 24));
    }

    /**
     * 获取时间差值 单位：毫秒
     *
     * @param start
     * @param end
     * @param type
     * @return
     */
    public long getBetweenTime(String start, String end, String type) {
        long from = 0, to = 0;
        try {
            switch (type) {
                case "dateFormat":
                    from = dateFormat.parse(start).getTime();
                    to = dateFormat.parse(end).getTime();
                    break;
                case "dateFormat2":
                    from = dateFormat2.parse(start).getTime();
                    to = dateFormat2.parse(end).getTime();
                    break;
                case "dateTimeFormat":
                    from = dateTimeFormat.parse(start).getTime();
                    to = dateTimeFormat.parse(end).getTime();
                    break;
                case "dateTimeFormat2":
                    from = dateTimeFormat2.parse(start).getTime();
                    to = dateTimeFormat2.parse(end).getTime();
                    break;
                case "dateTimeFormat3":
                    from = dateTimeFormat3.parse(start).getTime();
                    to = dateTimeFormat3.parse(end).getTime();
                    break;
                case "timeFormat":
                    from = timeFormat.parse(start).getTime();
                    to = timeFormat.parse(end).getTime();
                    break;
                case "timeFormat2":
                    from = timeFormat2.parse(start).getTime();
                    to = timeFormat2.parse(end).getTime();
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            return -1;
        }
        return (to - from);
    }

    /**
     * 是否在时间段之内
     *
     * @param startTime
     * @param endTime
     * @param now
     * @return
     */
    public boolean isBetween(Date startTime, Date endTime, Date now) {
        return now.after(startTime) && now.before(endTime);
    }

    /**
     * 定时器获取时间
     *
     * @param timeStr
     * @param defaultTime
     * @return
     */
    public static Date getTimerDate(String timeStr, int[] defaultTime) {
        String[] timeStrs;
        int[] times = new int[3];
        try {
            timeStrs = timeStr.split(":");
            if (timeStrs.length == 3) {
                for (int i = 0; i < times.length; i++) {
                    times[i] = Integer.parseInt(timeStrs[i]);
                }
            } else {
                times = defaultTime;
            }
        } catch (Exception ex) {
            times = defaultTime;
        }
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, times[0]);
        calendar.set(Calendar.MINUTE, times[1]);
        calendar.set(Calendar.SECOND, times[2]);
        calendar.set(Calendar.MILLISECOND, 0);
        Date startTime = calendar.getTime();
        if (date.after(startTime)) {
            startTime = DateUtils.addDays(startTime, 1);
        }
        return startTime;
    }


    /**
     * 传入当天前小时值获取时间戳
     *
     * @param hour
     * @return
     */
    public static Date getworkTime(Integer hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static void main(String[] args) throws Exception {

        DateUtil dateUtil = new DateUtil();
        Date date1 = dateUtil.dateFormat.parse("2017-5-12");
        Date date2 = dateUtil.dateFormat.parse("2017-9-12");

        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            dateUtil.getBetween(date1, date2);
        }

        long t2 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            dateUtil.getDiffDaysBetween(date1, date2);
        }

        long t3 = System.currentTimeMillis();


    }

    public static Timestamp getTimestamp(Object date) {
        if (date != null && date instanceof Date) {
            return new Timestamp(((Date) date).getTime());
        } else {
            return null;
        }
    }

    /**
     * 得到几天前的时间
     *
     * @param d
     * @param day
     * @return
     */
    public static Date getDateBefore(Date d, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
        return now.getTime();
    }

    /**
     * 得到几天后的时间
     *
     * @param d
     * @param day
     * @return
     */
    public static Date getDateAfter(Date d, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
        return now.getTime();
    }


    public static String toDate(Integer year, Integer month, Integer day, String format) {
        String date = "";
        if (year != null) {
            date = year + date;
        }
        if (month != null) {
            if (month < 10) {
                date = date + "-0" + month;
            } else {
                date = date + "-" + month;
            }
        }
        if (day != null) {
            if (day < 10) {
                date = date + "-0" + day;
            } else {
                date = date + "-" + day;
            }
        }

        return date;
    }

    /**
     * 修改字符串为date
     *
     * @param str
     * @return
     * @throws ParseException
     */
    public Date strToDateBysjc(String str) throws ParseException {
        Date date = new Date();
        int a = 4;
        int s = 6;
        int d = 8;
        int f = 10;
        int g = 12;
        int h = 14;
        if (str == null) {
            str = "000000";
            String str1 = str.substring(0, a);
            String str2 = str.substring(a, s);
            String time = str1 + "-" + str2;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
            date = sdf.parse(time);
        } else {
            if (str.length() == 6) {
                String str1 = str.substring(0, a);
                String str2 = str.substring(a, s);
                String time = str1 + "-" + str2;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
                date = sdf.parse(time);
            } else if (str.length() == 8) {
                String str1 = str.substring(0, a);
                String str2 = str.substring(a, s);
                String str3 = str.substring(s, d);
                String time = str1 + "-" + str2 + "-" + str3;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                date = sdf.parse(time);
            } else if (str.length() == 10) {
                String str1 = str.substring(0, a);
                String str2 = str.substring(a, s);
                String str3 = str.substring(s, d);
                String str4 = str.substring(d, f);
                String time = str1 + "-" + str2 + "-" + str3 + " " + str4;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
                date = sdf.parse(time);
            } else if (str.length() == 12) {
                String str1 = str.substring(0, a);
                String str2 = str.substring(a, s);
                String str3 = str.substring(s, d);
                String str4 = str.substring(d, f);
                String str5 = str.substring(f, g);
                String time = str1 + "-" + str2 + "-" + str3 + " " + str4 + ":" + str5;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                date = sdf.parse(time);
            } else if (str.length() == 14) {
                String str1 = str.substring(0, a);
                String str2 = str.substring(a, s);
                String str3 = str.substring(s, d);
                String str4 = str.substring(d, f);
                String str5 = str.substring(f, g);
                String str6 = str.substring(g, h);
                String time = str1 + "-" + str2 + "-" + str3 + " " + str4 + ":" + str5 + ":" + str6;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                date = sdf.parse(time);
            } else {
                str = "000000";
                String str1 = str.substring(0, a);
                String str2 = str.substring(a, s);
                String time = str1 + "-" + str2;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
                date = sdf.parse(time);
            }
        }
        return date;
    }

    /**
     * @Title: getAge @Description:
     * birthDay @param @return @param @throws Exception 参数 @return int
     * 返回类型 @throws
     */
    public static int getAge(Date birthDay) throws Exception {
        Calendar cal = Calendar.getInstance();
        if (cal.before(birthDay)) {
            throw new IllegalArgumentException("The birthDay is before Now.It's unbelievable!");
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthDay);

        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth)
                    age--;
            } else {
                age--;
            }
        }
        return age;
    }

    /**
     * 获得该月第一天
     *
     * @return
     */
    public static String getFirstDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date == null) {
            calendar.setTime(new Date());
        } else {
            calendar.setTime(date);
        }
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);

        Calendar cal = Calendar.getInstance();
        // 设置年份
        cal.set(Calendar.YEAR, year);
        // 设置月份
        cal.set(Calendar.MONTH, month);
        // 获取某月最小天数
        int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        // 设置日历中月份的最小天数
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        // 格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String firstDayOfMonth = sdf.format(cal.getTime());
        return firstDayOfMonth + " 00:00:00";
    }

    public static int getIntWeek(String XQ) {
        if ("".equals(XQ)) {
            int xq = 0;
            return xq;
        }
        int xq = 0;
        switch (XQ) {
            case "星期一":
                xq = 1;
                break;
            case "星期二":
                xq = 2;
                break;
            case "星期三":
                xq = 3;
                break;
            case "星期四":
                xq = 4;
                break;
            case "星期五":
                xq = 5;
                break;
            case "星期六":
                xq = 6;
                break;
            case "星期日":
                xq = 7;
                break;
            default:
                xq = 0;
                break;
        }
        return xq;
    }

    public static String getStrWeek(String XQ) {
        String xq = "";
        switch (XQ) {
            case "1":
                xq = "星期一";
                break;
            case "2":
                xq = "星期二";
                break;
            case "3":
                xq = "星期三";
                break;
            case "4":
                xq = "星期四";
                break;
            case "5":
                xq = "星期五";
                break;
            case "6":
                xq = "星期六";
                break;
            case "7":
                xq = "星期日";
                break;
            default:
                xq = "";
                break;
        }
        return xq;
    }

    /**
     * 获得该月最后一天
     *
     * @return
     */
    public static String getLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date == null) {
            calendar.setTime(new Date());
        } else {
            calendar.setTime(date);
        }
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        Calendar cal = Calendar.getInstance();
        // 设置年份
        cal.set(Calendar.YEAR, year);
        // 设置月份
        cal.set(Calendar.MONTH, month);
        // 获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        // 设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        // 格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String lastDayOfMonth = sdf.format(cal.getTime());
        return lastDayOfMonth + " 23:59:59";
    }

    // 比较两个日期大小关系
    public static int compareDate(String DATE1, String DATE2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }

    // 根据输入日期 获取一月以后的日期
    public static String subMonth(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dt = sdf.parse(date);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);

        rightNow.add(Calendar.MONTH, 1);
        Date dt1 = rightNow.getTime();
        String reStr = sdf.format(dt1);

        return reStr;
    }

    // // 根据输入日期 获取一月以后的日期
    // public static String subMonth1(String date) throws ParseException {
    // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
    // Date dt = sdf.parse(date);
    // Calendar rightNow = Calendar.getInstance();
    // rightNow.setTime(dt);
    //
    // rightNow.add(Calendar.MONTH, 1);
    // Date dt1 = rightNow.getTime();
    // String reStr = sdf.format(dt1);
    //
    // return reStr;
    // }

    /**
     * 获取当前时间 前一天
     *
     * @param date
     * @return
     */
    public static Date getNextDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        date = calendar.getTime();
        return date;
    }

    /**
     * 获取昨天日期
     *
     * @return
     */
    public static String getNextStrDay(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        return dateFormat.format(calendar.getTime());
    }

    /**
     * 得到几天前的时间
     *  
     *
     * @param date
     * @param day
     * @return
     */
    public static String getLastMonth(Date date, int day) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - day);
        return dateFormat.format(calendar.getTime());
    }

    /**
     * 获取 N天(前/后)的日期 (yyyy-MM-dd)
     *
     * @param day
     * @return
     */
    public static String getStrDateByDay(int day) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, day);
        return sdf.format(calendar.getTime());
    }

    /**
     * 获取 N天(前/后)的时间 (yyyy-MM-dd HH:mm:ss)
     *
     * @param day
     * @return
     */
    public static String getTimeByDay(int day) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, day);
        return sdf.format(calendar.getTime());
    }

    /**
     * 根据参数获取指定日期
     *
     * @param m
     * @param day
     * @return
     */
    public static String getFisrtDayOfMonth(int m, int day) {
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH);
        cal.setTime(new Date());
        cal.set(Calendar.MONTH, month - m);
        cal.set(Calendar.DAY_OF_MONTH, day);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cal.getTime());
    }

    /**
     * 获取当前时间 前七天
     *
     * @param date
     * @return
     */
    public static Date getLastWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -7);
        date = calendar.getTime();
        return date;
    }


    /**
     * 获取18年前的今天
     *
     * @param date
     * @return
     */
    public static String getPreviousYear(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, -18);
        String year = sdf.format(c.getTime());
        return year;
    }

    //获得两个日期之间的所有月份
    public static List<String> getMonthBetween(String minDate, String maxDate) throws ParseException {
        ArrayList<String> list = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月

        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();

        min.setTime(sdf.parse(minDate));
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

        max.setTime(sdf.parse(maxDate));
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

        Calendar curr = min;
        while (curr.before(max)) {
            list.add(sdf.format(curr.getTime()));
            curr.add(Calendar.MONTH, 1);
        }

        return list;
    }

    /* 判断时间类型是否满足格式 */
    public static boolean isValidDate(String date, String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateStr);
        boolean flag = true;
        try {
            sdf.setLenient(false);
            sdf.parse(date);
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 求HH:mm格式的时间毫秒差
     *
     * @param time
     * @return
     */
    public static Date timeDifference(String time) {

        SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 计划时间
        Date date = null;
        try {
            Date date1 = sdf1.parse(sdf1.format(new Date())); // 当前时间
            Date date2 = sdf1.parse(time); // 开始时间

            // 判断播放时间是否已经过了
            if (date1.compareTo(date2) > 0) {
                return date;
            } else {
                String d = sdf2.format(new Date()) + " " + time + ":00";
                return sdf3.parse(d);
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        return date;
    }

    /**
     * 求yyyy-MM-dd HH:mm格式的时间毫秒差
     *
     * @param time
     * @return
     */
    public static Date timeDifferences(String time) {
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        // 计划时间
        Date date = null;
        Date newDate = new Date();
        try {
            Date date1 = sdf2.parse(sdf2.format(newDate)); //当前时间
            Date date2 = sdf2.parse(time);    //播放时间

            //判断播放日期是否是今天
            if (date1.equals(date2)) {
                Date time1 = sdf3.parse(time);    //播放时间
                Date time2 = sdf3.parse(sdf3.format(newDate));    //当前时间
                // 判断播放时间是否已经过了
                if (time2.compareTo(time1) > 0) {
                    return date;
                } else {
                    String d = sdf3.format(time1) + ":00";
                    return sdf3.parse(d);
                }
            } else {
                return date;
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        return date;
    }

    /**
     * 求yyyy-MM-dd HH:mm格式的时间毫秒差
     *
     * @param time yyyy-MM-dd HH:mm
     * @return Date
     */
    public static Date timeDifferences(Date time) {
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        // 计划时间
        Date date = null;
        Date newDate = new Date();
        try {
            Date date1 = sdf2.parse(sdf2.format(newDate)); //当前时间
            Date date2 = sdf2.parse(sdf2.format(time));    //执行时间

            //判断播放日期是否是今天
            if (date1.equals(date2)) {
                Date time1 = sdf3.parse(sdf3.format(newDate));    //当前时间
                Date time2 = sdf3.parse(sdf3.format(time));    //执行时间

                // 判断播放时间是否已经过了
                if (time1.compareTo(time2) <= 0) {
                    String d = sdf3.format(time2) + ":00";
                    date = sdf3.parse(d);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    //提取字符串里的时间(yyyy-MM-dd)
    public static String[] splitTime(String time) {
        List<String> times = new ArrayList<>();
        if (time != null && !time.isEmpty()) {
            Pattern pattern = Pattern.compile("([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8])))");
            Matcher matcher = pattern.matcher(time);
            while (matcher.find()) {
                String group = matcher.group();
                times.add(group);
            }
        }
        String[] array = new String[times.size()];
        return times.toArray(array);
    }


    /**
     * 获取本周日的开始时间
     *
     * @param date
     * @return
     */
    public static String getThisWeekSunday(Date date) {
        Calendar c = Calendar.getInstance();
        int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0)
            day_of_week = 7;
        c.add(Calendar.DATE, -day_of_week + 7);


        Calendar calendar = Calendar.getInstance();
        calendar.setTime(c.getTime());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);


        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");//设置日期格式
        String WeekEndDt = df.format(calendar.getTime());

        return WeekEndDt;
    }


    /**
     * 获取本周一的开始时间
     *
     * @param date
     * @return
     */
    public static String getThisWeekMonday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 获得当前日期是一个星期的第几天
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int day = cal.get(Calendar.DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);


        Calendar calendar = Calendar.getInstance();
        calendar.setTime(cal.getTime());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);


        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");//设置日期格式
        String WeekStartDt = df.format(calendar.getTime());


        return WeekStartDt;
    }

    public static String StringsplitDate(String string) {
        String dateString = string;
        dateString = dateString.replaceAll("-", "");


        return dateString;
    }

    /*获取过去第几天的日期 */
    public static String getPastDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(today);
        return result;
    }

    /**
     * 根据Date获取6天前的当天结束时间
     *
     * @param date
     * @return
     */
    public static Date getLastWeekEndByDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        calendar.add(Calendar.DAY_OF_MONTH, -7);
        return calendar.getTime();
    }

    /**
     * 根据Date获取XX天前的当天结束时间
     *
     * @param date
     * @return
     */
    public static Date getLastWeekEndByDate2(Date date, int dayBefore) {
        if (date == null) {
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        calendar.add(Calendar.DAY_OF_MONTH, -dayBefore);
        return calendar.getTime();
    }


    /**
     * 获取几天之后的日期
     *
     * @param date
     * @param dayLast
     * @return
     */
    public static Date getLastDayDate(Date date, int dayLast) {
        if (date == null) {
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        calendar.add(Calendar.DAY_OF_MONTH, +dayLast);
        return calendar.getTime();
    }


    /**
     * 获取未来几天日期
     *
     * @param date
     * @param flag 1:date,2:String(有时分秒)，2:String(没有时分秒)
     * @param day  几天之后（包含今天）
     * @return
     */
    public Object getNextSevenDays(Date date, String flag, Integer day) {
        if (date == null) {
            date = new Date();
        }
        List<Date> dateListDate = new ArrayList<>();
        //有时分秒
        List<String> dateListString = new ArrayList<>();
        //没有时分秒
        List<String> dateListString2 = new ArrayList<>();

        for (int i = 0; i < day; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.HOUR_OF_DAY, 23);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.SECOND, 59);
            calendar.set(Calendar.MILLISECOND, 999);
            calendar.add(Calendar.DAY_OF_MONTH, +i);
            Date date1 = calendar.getTime();
            dateListDate.add(date1);
            dateListString.add(dateTimeFormat.format(date1));
            dateListString2.add(dateFormat.format(date1));
        }
        if ("1".equals(flag)) {
            return dateListDate;
        } else if ("2".equals(flag)) {
            return dateListString;
        } else {
            return dateListString2;
        }
    }

    /**
     * 获取 2 个时间的自然年历的时间间隔
     *
     * @param toDate   后面的时间，需要大于 fromDate
     * @param fromDate 前面的时间
     * @return [年, 月, 日, 小时, 分钟, 秒]的数组
     */
    public static Integer[] getTimeIntervalArray(Date fromDate, Date toDate) {
        Calendar previousDate = Calendar.getInstance();
        previousDate.setTime(fromDate);
        Calendar nextDate = Calendar.getInstance();
        nextDate.setTime(toDate);
        int year = nextDate.get(Calendar.YEAR) - previousDate.get(Calendar.YEAR);
        int month = nextDate.get(Calendar.MONTH) - previousDate.get(Calendar.MONTH);
        int day = nextDate.get(Calendar.DAY_OF_MONTH) - previousDate.get(Calendar.DAY_OF_MONTH);
        int hour = nextDate.get(Calendar.HOUR_OF_DAY) - previousDate.get(Calendar.HOUR_OF_DAY);// 24小时制
        int min = nextDate.get(Calendar.MINUTE) - previousDate.get(Calendar.MINUTE);
        int second = nextDate.get(Calendar.SECOND) - previousDate.get(Calendar.SECOND);
        // "时"是否向"天"借过一位
        boolean hasBorrowDay = false;

        if (second < 0) {
            second += 60;
            min--;
        }

        if (min < 0) {
            min += 60;
            hour--;
        }

        if (hour < 0) {
            hour += 24;
            day--;
            hasBorrowDay = true;
        }

        if (day < 0) {
            // 计算截止日期的上一个月有多少天，补上去
            Calendar tempDate = (Calendar) nextDate.clone();
            tempDate.add(Calendar.MONTH, -1);// 获取截止日期的上一个月
            day += tempDate.getActualMaximum(Calendar.DAY_OF_MONTH);
            // nextDate是月底最后一天，且day=这个月的天数，即是刚好一整个月，比如20160131~20160229，day=29，实则为1个月
            if (!hasBorrowDay
                    && nextDate.get(Calendar.DAY_OF_MONTH) == nextDate.getActualMaximum(Calendar.DAY_OF_MONTH)// 日期为月底最后一天
                    && day >= nextDate.getActualMaximum(Calendar.DAY_OF_MONTH)) {// day刚好是nextDate一个月的天数，或大于nextDate月的天数（比如2月可能只有28天）
                day = 0;// 因为这样判断是相当于刚好是整月了，那么不用向 month 借位，只需将 day 置 0
            } else {// 向month借一位
                month--;
            }
        }
        if (month < 0) {
            month += 12;
            year--;
        }
        return new Integer[]{year, month, day, hour, min, second};
    }

    /**
     * 获取某月最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static String getTimeDay(String simpleDateFormat, int index, int year, int month) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat(simpleDateFormat);
        calendar.set(Calendar.YEAR, year);
        //设置月份
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, index);
        return format.format(calendar.getTime());
    }

    /**
     * 获取指定日期所在周的第一天
     *
     * @param dataStr
     * @return
     * @throws ParseException
     */
    public static String getFirstDayOfWeek(String dataStr) throws ParseException {
        Calendar cal = Calendar.getInstance();

        cal.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(dataStr));

        int d = 0;
        if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
            d = -6;
        } else {
            d = 2 - cal.get(Calendar.DAY_OF_WEEK);
        }
        cal.add(Calendar.DAY_OF_WEEK, d);
        // 所在周开始日期
        String data1 = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        return data1;

    }

    /**
     * 获取指定日期所在周的最后一天
     *
     * @param dataStr
     * @return
     * @throws ParseException
     */
    public static String getLastDayOfWeek(String dataStr) throws ParseException {
        Calendar cal = Calendar.getInstance();

        cal.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(dataStr));
        //region
        int d = 0;
        if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
            d = -6;
        } else {
            d = 2 - cal.get(Calendar.DAY_OF_WEEK);
        }
        //endregion
        cal.add(Calendar.DAY_OF_WEEK, d);
        cal.add(Calendar.DAY_OF_WEEK, 6);
        // 所在周结束日期
        String data2 = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        return data2;

    }


    /**
     * 获得上个月的年月
     *
     * @return
     */
    public static String getLastYearMonth() {
        DateUtil dateUtil = new DateUtil();
        //获得当月的年月
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -1);
        String lastMont = dateUtil.dateFormatYm.format(c.getTime());
        return lastMont;
    }

    /**
     * @description: 获取日期月内所有日期
     * @author: CrazyWolf刘恒
     * @time: 2019/9/28 10:22
     * @Param: date
     * @return: java.util.List<java.lang.String>
     */
    public List<String> getMonthFullDay(String date) {
        List<String> fullDayList = new ArrayList<String>();
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        // 所有月份从1号开始
        int day = 1;
        // 获得当前日期对象
        Calendar cal = Calendar.getInstance();
        // 清除信息
        cal.clear();
        cal.set(Calendar.YEAR, year);
        // 1月从0开始
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, day);
        int count = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int j = 0; j <= (count - 1); ) {
            if (dateFormat.format(cal.getTime()).equals(new DateUtil().getLastDay(year, month))) {
                break;
            }
            cal.add(Calendar.DAY_OF_MONTH, j == 0 ? +0 : +1);
            j++;
            fullDayList.add(dateFormat.format(cal.getTime()));
        }
        return fullDayList;
    }

    public String getLastDay(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, 0);
        return dateFormat.format(cal.getTime());
    }


    /**
     * 获取某年第一天日期
     * @param year 年份
     * @return Date
     */
    public static Date getYearFirst(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        return calendar.getTime();
    }

    /**
     * @description:一个指定日期加上指定天数得到新日期
     *
     * @author:ZhangMeng
     * @time:2019/9/7 17:04
     * @param date1 指定的日期
     * @param day 需要加的天数
     * @return: 结果集
     */
    public static Date addDate(String date1, long day) throws ParseException {
        Date date = new DateUtil().dateFormat.parse(date1);
        long time = date.getTime(); // 得到指定日期的毫秒数
        day = day*24*60*60*1000; // 要加上的天数转换成毫秒数
        time+=day; // 相加得到新的毫秒数
        return new DateUtil().dateFormat.parse(new DateUtil().dateFormat.format(new Date(time))); // 将毫秒数转换成日期
    }


    /**
     * 获取当年的第一天
     * @return
     */
    public static Date getCurrYearFirst(){
        Calendar currCal=Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearFirst2(currentYear);
    }

    /**
     * 获取当年的最后一天
     * @return
     */
    public static Date getCurrYearLast(){
        Calendar currCal=Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearLast(currentYear);
    }

    /**
     * 获取某年第一天日期
     * @param year 年份
     * @return Date
     */
    public static Date getYearFirst2(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        Date currYearFirst = calendar.getTime();
        return currYearFirst;
    }

    /**
     * 获取某年最后一天日期
     * @param year 年份
     * @return Date
     */
    public static Date getYearLast(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        calendar.roll(Calendar.DAY_OF_YEAR, -1);
        Date currYearLast = calendar.getTime();
        return currYearLast;
    }
}
