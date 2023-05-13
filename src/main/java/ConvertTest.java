import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.google.common.collect.Lists;

/**
 * @author zhayang <zhayang@kuaishou.com>
 * Created on 2021-12-23
 */
public class ConvertTest {
    public static void main(String[] args) {

        List<Long> list = Lists.newArrayList(1L, 2L, 3L, 4L);
        Long aLong = list.stream().reduce(Long::sum).get();
        System.out.println(aLong);

        int count = 73;
        double mul = 3.2223;

        long l = LocalDate.now().toEpochDay();
        long time1 = 1643173804000L;
        long time2 = System.currentTimeMillis();
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
        String format = sf.format(time1);



        long time3 = TimeUnit.MINUTES.toSeconds(30);

        if (time2 - time1 < time3 * 1000) {
            System.out.println("aaa");
        }


        String s = convertUserPickCount((int) (count * mul));
        System.out.println(s);
    }


    public static String convertUserPickCount(int count) {
        if (count < 10000) {
            if (count < 100) {
                return "100+";
            }
            return count / 100 * 100 + "+";
        }
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(1);
        String format = numberFormat.format(count / 10000.0);
        return format + "w";
    }
}
