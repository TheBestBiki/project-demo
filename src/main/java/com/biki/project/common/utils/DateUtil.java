package com.biki.project.common.utils;

import com.biki.project.common.exception.UnifiedException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2021/2/26
 *
 * GMT -> 格林威治标准时间   UTC -> 世界统一时间
 * 实际上，对于中国来说，GMT与UTC是一样的，北京时间=UTC+8=GMT+8 ， 所以一般GMT与UTC的转换，都是格式的转换，yMd Hms 都是一样的
 * GMT与UTC差别介绍：https://blog.csdn.net/hou549135295/article/details/81485999 ， https://blog.csdn.net/songjie2050/article/details/80538936
 */
public class DateUtil {

    public static void main(String[] args) throws Exception {
        //String转Date，用SimpleDateFormat自带的parse(解析)方法
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); //定义传入进来的日期字符串的格式，或者输出的字符串日期的格式
        String startDateTime="2018-05-20T00:00:00";
        String endDateTime="2018-05-24T23:59:59";

        Date startDate = simple.parse(startDateTime); //解析该格式的字符串日期
        Date endDate = simple.parse(endDateTime);
        System.out.println(startDate);
        System.out.println("-------------------");
        System.out.println(endDate);

        // Date转String，用SimpleDateFormat自带的format(格式)方法
        String startTime = simple.format(startDate);
        String endTime = simple.format(endDate);
        System.out.println(startTime);
        System.out.println("-------------------");
        System.out.println(endTime);

        Calendar calle = Calendar.getInstance(); //获得一个Calendar类型的通用对象
        calle.setTime(new Date());
        System.out.println(calle.getTime());
        calle.add(Calendar.HOUR_OF_DAY, +8); //加8小时
        System.out.println(calle.getTime());
    }

    /**
     * utc时间格式转换为常规日期类型
     * 
     * @param utcTime 时间
     * @return
     */
    public static String formatUTCStringToString(String utcTime) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US); // 因为时间是世界统一时间，地点在美国，所以这里的时区用US美国
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        TimeZone utcZone = TimeZone.getTimeZone("UTC");
        sf.setTimeZone(utcZone);
        Date date = null;
        String dateTime = "";
        try {
            date = sf.parse(utcTime);
            dateTime = sdf.format(date);
        } catch (Exception e) {
            throw UnifiedException.from("UTC时间转换为常规日期类型失败，失败原因"+e.toString());
        }
        return dateTime;
    }

    /**
     * 这个可以根据自己的需要对日期进行加减时间
     * calle.add(Calendar.HOUR_OF_DAY, +8); 表示在当前时间的基础上加上8小时，以此弥补时差，HOUR_OF_DAY 用于24小时制
     * 该方法用于：如果获取了其它地区时间，则如何转化为北京时间，用上方的方法也行，该方法则较为直接。通过比较2个地区之间的时区差，然后进行相加减
     * @param date
     * @param operation  add 增加时间 ; reduce 减少时间
     * @return
     */
    private static Date modifyTime(Date date, String operation){
        if ("add".equals(operation)){
            Calendar call = Calendar.getInstance();
            call.setTime(date);
            call.add(Calendar.HOUR_OF_DAY, +8); //加8小时
            return call.getTime();
        }
        if ("reduce".equals(operation)){
            Calendar call = Calendar.getInstance();
            call.setTime(date);
            call.add(Calendar.HOUR_OF_DAY, -8); //减8小时
            return call.getTime();
        }
        return date;
    }




}
