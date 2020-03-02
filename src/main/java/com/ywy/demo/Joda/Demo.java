package com.ywy.demo.Joda;

import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;

/**
 * @author ve
 * @date 2020/3/2 0:56
 */
public class Demo {
    public static void main(String[] args) {
        // 创建某个特定日期的时间2020/3/2 01:02
        DateTime dateTime = new DateTime(2020, 3, 2, 1, 2);
        System.out.println(dateTime.getMillis());
//        System.out.println(System.currentTimeMillis());
        System.out.println(dateTime);
        // 当前时间的毫秒值
        System.out.println("当前时间的毫秒值: " + new DateTime().getMillis());
        // 明天
        System.out.println("明天: " + new DateTime().plusDays(1));
        // 十分钟之后
        System.out.println("十分钟之后: " + new DateTime().plusMinutes(10));
        // 这周的最后一天
        System.out.println("这周最后一天" + new DateTime().dayOfWeek().withMaximumValue());
        // 这个月的最后一天
        System.out.println("这个月最后一天" + new DateTime().dayOfMonth().withMaximumValue());
        // 今年的最后一天
        System.out.println("今年最后一天" + new DateTime().dayOfYear().withMaximumValue());
        // 二月的最后一天
        System.out.println("二月最后一天" + new DateTime().withMonthOfYear(2).dayOfMonth().withMaximumValue());
        DateTime d = new DateTime();
        // false
        System.out.println("==比较: " + (d.plusDays(1).minusDays(1) == d));
        // true
        System.out.println("equal比较: " + (d.plusDays(1).minusDays(1).equals(d)));

        // 不可变性,每次修改都返回一个新对象,类似于String
        // 瞬间性,指时间线上面的某个唯一的点,精确到毫秒.类似于Date epoch 为1970-01-01 00:00:00 UTC
        // 局部性:时间的一部分片段,比如3月2日,可以代表任何一年,所以这是一个可选的日期,每年只有一个
        //     new DateTime().dayOfYear(),表示当前时间的年范围日期,所以下面这个
        //     new DateTime().dayOfYear().withMaximumValue(),表示当前时间的年范围的最大一天(即今年最后一天的这个时间点)
        /*
         年表
         Joda 本质 — 以及其设计核心 — 的关键就是年表（它的含义由一个同名抽象类捕捉）。从根本上讲，年表是一种日历系统 — 一种计算时间的特殊方式 — 并且是一种在其中执行日历算法的框架。受 Joda 支持的年表的例子包括：
            ISO（默认）
            Coptic
            Julian
            Islamic
            Joda-Time 1.6 支持 8 种年表，每一种都可以作为特定日历系统的计算引擎。
          */
        // 时区DateTimeZone

        // 格式化时间
        System.out.println("格式化: ");
        System.out.println(dateTime.toString(ISODateTimeFormat.basicDateTime()));
        System.out.println(dateTime.toString(ISODateTimeFormat.basicDateTimeNoMillis()));
        System.out.println(dateTime.toString(ISODateTimeFormat.basicOrdinalDateTime()));
        System.out.println(dateTime.toString(ISODateTimeFormat.basicWeekDateTime()));
        System.out.println(dateTime.toString("MM/dd/yyyy hh:mm:ss.SSSa"));
        System.out.println(dateTime.toString("dd-MM-yyyy HH:mm:ss"));
        System.out.println(dateTime.toString("MM/dd/yyyy HH:mm ZZZZ"));
        System.out.println(dateTime.toString("EEEE dd MMMM, yyyy HH:mm:ssa"));
        System.out.println(dateTime.toString("MM/dd/yyyy HH:mm Z"));

    }
}
