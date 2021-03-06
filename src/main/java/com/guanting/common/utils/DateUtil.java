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
     * ?????? N ???????????????
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
     * ?????????????????????????????????(firstDate???secondDate?????????)
     *
     * @param firstDate  ???????????????
     * @param secondDate ???????????????
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
     * ????????????
     *
     * @param date ??????
     * @return 1-????????????2-????????????...7-?????????
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
     * ????????????
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
     * ?????????????????????
     *
     * @param date ??????
     * @return ???????????????
     */
    public String getWeekStr(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (week < 0) {
            week = 0;
        }
        String[] weeks = new String[]{"?????????", "?????????", "?????????", "?????????", "?????????", "?????????", "?????????"};
        return weeks[week];
    }

    /**
     * ??????Date????????????????????????
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
     * ??????Date????????????????????????
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
     * date @param @return ?????? (?????????????????????????????????) @return Date ???????????? @throws
     */
    public static Date getMonthByDate(Date date, int y) {
        Calendar ca = Calendar.getInstance();// ????????????Calendar?????????
        // ca.setTime(new Date()); // ???????????????????????????
        ca.setTime(date);
        ca.add(Calendar.MONTH, -y);// ?????????1
        ca.getTime(); // ??????
        return ca.getTime();
    }

    /**
     * ??????Date????????????????????????
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
     * date???String
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
     * ?????????????????? ???????????????
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
     * ????????????????????????
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
     * ?????????????????????
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
     * ???????????????????????????????????????
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
     * ????????????????????????
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
     * ????????????????????????
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
     * ??????????????????date
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
     * birthDay @param @return @param @throws Exception ?????? @return int
     * ???????????? @throws
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
     * ?????????????????????
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
        // ????????????
        cal.set(Calendar.YEAR, year);
        // ????????????
        cal.set(Calendar.MONTH, month);
        // ????????????????????????
        int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        // ????????????????????????????????????
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        // ???????????????
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
            case "?????????":
                xq = 1;
                break;
            case "?????????":
                xq = 2;
                break;
            case "?????????":
                xq = 3;
                break;
            case "?????????":
                xq = 4;
                break;
            case "?????????":
                xq = 5;
                break;
            case "?????????":
                xq = 6;
                break;
            case "?????????":
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
                xq = "?????????";
                break;
            case "2":
                xq = "?????????";
                break;
            case "3":
                xq = "?????????";
                break;
            case "4":
                xq = "?????????";
                break;
            case "5":
                xq = "?????????";
                break;
            case "6":
                xq = "?????????";
                break;
            case "7":
                xq = "?????????";
                break;
            default:
                xq = "";
                break;
        }
        return xq;
    }

    /**
     * ????????????????????????
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
        // ????????????
        cal.set(Calendar.YEAR, year);
        // ????????????
        cal.set(Calendar.MONTH, month);
        // ????????????????????????
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        // ????????????????????????????????????
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        // ???????????????
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String lastDayOfMonth = sdf.format(cal.getTime());
        return lastDayOfMonth + " 23:59:59";
    }

    // ??????????????????????????????
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

    // ?????????????????? ???????????????????????????
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

    // // ?????????????????? ???????????????????????????
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
     * ?????????????????? ?????????
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
     * ??????????????????
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
     * ????????????????????????
     * ??
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
     * ?????? N???(???/???)????????? (yyyy-MM-dd)
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
     * ?????? N???(???/???)????????? (yyyy-MM-dd HH:mm:ss)
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
     * ??????????????????????????????
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
     * ?????????????????? ?????????
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
     * ??????18???????????????
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

    //???????????????????????????????????????
    public static List<String> getMonthBetween(String minDate, String maxDate) throws ParseException {
        ArrayList<String> list = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//??????????????????

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

    /* ???????????????????????????????????? */
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
     * ???HH:mm????????????????????????
     *
     * @param time
     * @return
     */
    public static Date timeDifference(String time) {

        SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // ????????????
        Date date = null;
        try {
            Date date1 = sdf1.parse(sdf1.format(new Date())); // ????????????
            Date date2 = sdf1.parse(time); // ????????????

            // ????????????????????????????????????
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
     * ???yyyy-MM-dd HH:mm????????????????????????
     *
     * @param time
     * @return
     */
    public static Date timeDifferences(String time) {
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        // ????????????
        Date date = null;
        Date newDate = new Date();
        try {
            Date date1 = sdf2.parse(sdf2.format(newDate)); //????????????
            Date date2 = sdf2.parse(time);    //????????????

            //?????????????????????????????????
            if (date1.equals(date2)) {
                Date time1 = sdf3.parse(time);    //????????????
                Date time2 = sdf3.parse(sdf3.format(newDate));    //????????????
                // ????????????????????????????????????
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
     * ???yyyy-MM-dd HH:mm????????????????????????
     *
     * @param time yyyy-MM-dd HH:mm
     * @return Date
     */
    public static Date timeDifferences(Date time) {
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        // ????????????
        Date date = null;
        Date newDate = new Date();
        try {
            Date date1 = sdf2.parse(sdf2.format(newDate)); //????????????
            Date date2 = sdf2.parse(sdf2.format(time));    //????????????

            //?????????????????????????????????
            if (date1.equals(date2)) {
                Date time1 = sdf3.parse(sdf3.format(newDate));    //????????????
                Date time2 = sdf3.parse(sdf3.format(time));    //????????????

                // ????????????????????????????????????
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

    //???????????????????????????(yyyy-MM-dd)
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
     * ??????????????????????????????
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


        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");//??????????????????
        String WeekEndDt = df.format(calendar.getTime());

        return WeekEndDt;
    }


    /**
     * ??????????????????????????????
     *
     * @param date
     * @return
     */
    public static String getThisWeekMonday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // ?????????????????????????????????????????????
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        // ???????????????????????????????????????????????????????????????????????????????????????
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // ?????????????????????????????????????????????
        int day = cal.get(Calendar.DAY_OF_WEEK);
        // ???????????????????????????????????????????????????????????????????????????????????????
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);


        Calendar calendar = Calendar.getInstance();
        calendar.setTime(cal.getTime());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);


        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");//??????????????????
        String WeekStartDt = df.format(calendar.getTime());


        return WeekStartDt;
    }

    public static String StringsplitDate(String string) {
        String dateString = string;
        dateString = dateString.replaceAll("-", "");


        return dateString;
    }

    /*?????????????????????????????? */
    public static String getPastDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(today);
        return result;
    }

    /**
     * ??????Date??????6???????????????????????????
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
     * ??????Date??????XX???????????????????????????
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
     * ???????????????????????????
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
     * ????????????????????????
     *
     * @param date
     * @param flag 1:date,2:String(????????????)???2:String(???????????????)
     * @param day  ??????????????????????????????
     * @return
     */
    public Object getNextSevenDays(Date date, String flag, Integer day) {
        if (date == null) {
            date = new Date();
        }
        List<Date> dateListDate = new ArrayList<>();
        //????????????
        List<String> dateListString = new ArrayList<>();
        //???????????????
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
     * ?????? 2 ???????????????????????????????????????
     *
     * @param toDate   ?????????????????????????????? fromDate
     * @param fromDate ???????????????
     * @return [???, ???, ???, ??????, ??????, ???]?????????
     */
    public static Integer[] getTimeIntervalArray(Date fromDate, Date toDate) {
        Calendar previousDate = Calendar.getInstance();
        previousDate.setTime(fromDate);
        Calendar nextDate = Calendar.getInstance();
        nextDate.setTime(toDate);
        int year = nextDate.get(Calendar.YEAR) - previousDate.get(Calendar.YEAR);
        int month = nextDate.get(Calendar.MONTH) - previousDate.get(Calendar.MONTH);
        int day = nextDate.get(Calendar.DAY_OF_MONTH) - previousDate.get(Calendar.DAY_OF_MONTH);
        int hour = nextDate.get(Calendar.HOUR_OF_DAY) - previousDate.get(Calendar.HOUR_OF_DAY);// 24?????????
        int min = nextDate.get(Calendar.MINUTE) - previousDate.get(Calendar.MINUTE);
        int second = nextDate.get(Calendar.SECOND) - previousDate.get(Calendar.SECOND);
        // "???"?????????"???"????????????
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
            // ?????????????????????????????????????????????????????????
            Calendar tempDate = (Calendar) nextDate.clone();
            tempDate.add(Calendar.MONTH, -1);// ?????????????????????????????????
            day += tempDate.getActualMaximum(Calendar.DAY_OF_MONTH);
            // nextDate???????????????????????????day=??????????????????????????????????????????????????????20160131~20160229???day=29????????????1??????
            if (!hasBorrowDay
                    && nextDate.get(Calendar.DAY_OF_MONTH) == nextDate.getActualMaximum(Calendar.DAY_OF_MONTH)// ???????????????????????????
                    && day >= nextDate.getActualMaximum(Calendar.DAY_OF_MONTH)) {// day?????????nextDate??????????????????????????????nextDate?????????????????????2???????????????28??????
                day = 0;// ?????????????????????????????????????????????????????????????????? month ?????????????????? day ??? 0
            } else {// ???month?????????
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
     * ????????????????????????
     *
     * @param year
     * @param month
     * @return
     */
    public static String getTimeDay(String simpleDateFormat, int index, int year, int month) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat(simpleDateFormat);
        calendar.set(Calendar.YEAR, year);
        //????????????
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, index);
        return format.format(calendar.getTime());
    }

    /**
     * ???????????????????????????????????????
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
        // ?????????????????????
        String data1 = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        return data1;

    }

    /**
     * ??????????????????????????????????????????
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
        // ?????????????????????
        String data2 = new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
        return data2;

    }


    /**
     * ????????????????????????
     *
     * @return
     */
    public static String getLastYearMonth() {
        DateUtil dateUtil = new DateUtil();
        //?????????????????????
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -1);
        String lastMont = dateUtil.dateFormatYm.format(c.getTime());
        return lastMont;
    }

    /**
     * @description: ??????????????????????????????
     * @author: CrazyWolf??????
     * @time: 2019/9/28 10:22
     * @Param: date
     * @return: java.util.List<java.lang.String>
     */
    public List<String> getMonthFullDay(String date) {
        List<String> fullDayList = new ArrayList<String>();
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        // ???????????????1?????????
        int day = 1;
        // ????????????????????????
        Calendar cal = Calendar.getInstance();
        // ????????????
        cal.clear();
        cal.set(Calendar.YEAR, year);
        // 1??????0??????
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
     * ???????????????????????????
     * @param year ??????
     * @return Date
     */
    public static Date getYearFirst(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        return calendar.getTime();
    }

    /**
     * @description:???????????????????????????????????????????????????
     *
     * @author:ZhangMeng
     * @time:2019/9/7 17:04
     * @param date1 ???????????????
     * @param day ??????????????????
     * @return: ?????????
     */
    public static Date addDate(String date1, long day) throws ParseException {
        Date date = new DateUtil().dateFormat.parse(date1);
        long time = date.getTime(); // ??????????????????????????????
        day = day*24*60*60*1000; // ????????????????????????????????????
        time+=day; // ???????????????????????????
        return new DateUtil().dateFormat.parse(new DateUtil().dateFormat.format(new Date(time))); // ???????????????????????????
    }


    /**
     * ????????????????????????
     * @return
     */
    public static Date getCurrYearFirst(){
        Calendar currCal=Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearFirst2(currentYear);
    }

    /**
     * ???????????????????????????
     * @return
     */
    public static Date getCurrYearLast(){
        Calendar currCal=Calendar.getInstance();
        int currentYear = currCal.get(Calendar.YEAR);
        return getYearLast(currentYear);
    }

    /**
     * ???????????????????????????
     * @param year ??????
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
     * ??????????????????????????????
     * @param year ??????
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
