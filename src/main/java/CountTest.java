import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.google.common.collect.Lists;

/**
 * @author zhayang
 * Created on 2020-04-16
 */
public class CountTest {
    public static void main(String[] args) {
        int ttlSeconds = (int) TimeUnit.MINUTES.toSeconds(1); // ttl = 1分钟
        System.out.println(ttlSeconds);
        ttlSeconds = (int) TimeUnit.HOURS.toSeconds(1); // ttl = 1小时
        System.out.println(ttlSeconds);
        ttlSeconds = (int) TimeUnit.DAYS.toSeconds(1); // ttl = 1天
        System.out.println(ttlSeconds);


        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            String key = String.format("%04d", i);
            map.put(key, new Random().nextInt(1000));
        }

        List<Entry<String, Integer>> collect =
                map.entrySet().stream().sorted(Comparator.comparingInt(Entry::getValue)).collect(Collectors.toList());

        List<Entry<String, Integer>> entries = collect.subList(0, 9);
        List<Entry<String, Integer>> entries1 = collect.subList(collect.size() - 10, collect.size());

        System.out.println(collect);

        AtomicInteger integer = new AtomicInteger(1);
        int i1 = integer.addAndGet(3);
        integer.addAndGet(4);
        System.out.println(integer);

        String number = "1030";
        try {
            int i = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }


    }


}
