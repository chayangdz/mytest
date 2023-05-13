package date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author zhayang <zhayang@kuaishou.com>
 * Created on 2021-10-09
 */
public class DateUtils {

    /**
     * 给定一个时间，获取这个时间对应的日期
     * 具体返回什么格式的日期，和formatter的pattern有关，自己定义就好，这里只是一个例子
     *
     * @param time 给定的时间
     * @return 返回的是年月日的格式，比如20211009
     */
    public static String localDateTime2Str(LocalDateTime time) {
        return time.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }

    /**
     * 给定一个时间，获取这个时间对应的时间戳
     *
     * @param time 给定的时间
     * @return 给定时间对应的时间戳
     */
    public static long getLocalDateTimeMills(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public static void main(String[] args) throws Exception {
        LocalDateTime now = LocalDateTime.now();

        now.toLocalDate();
        String format = String.format("%s个", 3);


        //        String sss = "20211011";
//        String[] split = sss.split("-");
//        System.out.println(split);
        String s = localDateTime2Str(now);
        String s2 = "202212212230";


        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

        int i = 50;
        double result = (double) 50/100;
        System.out.println(result);



        Date parse = dateFormat.parse(s);

        LocalDateTime localDateTime = LocalDateTime.ofInstant(parse.toInstant(), ZoneId.systemDefault());


        DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();



        // 获取当前时间对应的日期
        System.out.println("当前时间对应的日期：" + localDateTime2Str(now));
        // 获取当前时间对应的时间戳
        System.out.println("当前时间对应的时间戳：" + getLocalDateTimeMills(now));
        // 获取今天零点对应的时间戳
        LocalDateTime startOfDay = LocalDateTime.of(now.toLocalDate(), LocalTime.MIN);
        System.out.println("今天零点对应的时间戳：" + getLocalDateTimeMills(startOfDay));
        // 获取今天24点的时间戳
        LocalDateTime endOfDay = LocalDateTime.of(now.toLocalDate(), LocalTime.MAX);
        System.out.println("今天24点的时间戳：" + getLocalDateTimeMills(endOfDay));
        // 获取今天中午12点的时间戳
        LocalDateTime noonOfDay = LocalDateTime.of(now.toLocalDate(), LocalTime.NOON);
        System.out.println("今天中午12点的时间戳：" + getLocalDateTimeMills(noonOfDay));
        // LocalDateTime是可以进行加减运算的，所以可以计算N天前或者N天后的时间戳
        // 而且不仅仅可以按照天和星期计算，还可以按照小时，分钟，月，年计算。这里只是举几个简单的例子。
        // 获取明天24点的时间戳
        LocalDateTime tomorrowEndOfDay = LocalDateTime.of(now.plusDays(1).toLocalDate(), LocalTime.MAX);
        System.out.println("明天24点的时间戳：" + getLocalDateTimeMills(tomorrowEndOfDay));
        // 获取明天对应的日期
        System.out.println("明天对应的日期：" + localDateTime2Str(now.plusDays(1)));
        // 获取一周后对应的日期
        System.out.println("一周后对应的日期：" + localDateTime2Str(now.plusWeeks(1)));
        // 获取24小时后的时间戳
        System.out.println("24小时后的时间戳：" + getLocalDateTimeMills(now.plusDays(1)));
    }

}
