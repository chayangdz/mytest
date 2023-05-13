package collectiontest;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author zhayang
 * Created on 2020-04-13
 */
public class LogTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogTest.class);

    public static String formatNumber(int number) {
        return String.format("%04d", number);
    }

    public static void main(String[] args) {

        String s  = "0021";
        int ii = Integer.parseInt(s);
        System.out.println(ii);
        NumberFormat format = NumberFormat.getInstance();
        format.setMaximumFractionDigits(2);
        double a = 7 * 1.0 /9;
        String format1 = format.format(a);
        System.out.println(format1);

        String test = "aaa";
        String test2 = Arrays.toString(test.getBytes());

        Map<byte[], byte[]> map = Maps.newHashMap();

        map.put("2".getBytes(), "b".getBytes());
        map.put("3".getBytes(), "c".getBytes());

        Integer integer =
                map.keySet().stream().map(String::new).map(Integer::parseInt).max(Integer::compareTo).get();


        Set<String> set = new HashSet<>();
        for (int i = 1; i < 120; i++) {
            set.add(String.valueOf(i));
        }

        List<String> collect =
                set.stream().map(Integer::parseInt).sorted(Integer::compareTo).map(String::valueOf)
                        .collect(Collectors.toList());

        String[] strings = collect.subList(0, collect.size() - 100).toArray(new String[collect.size() - 100]);

        System.out.println(strings);

        //        Map<Long, Boolean> map = Maps.newHashMap();
        //        for (int i = 0; i <= 90; i++) {
        //            Random random = new Random();
        //            int i1 = random.nextInt(10000);
        //            String s = formatNumber(i1);
        //            System.out.println(s);
        //        }


        //        long l = TimeUnit.HOURS.toMillis(1);
        //        long l1 = System.currentTimeMillis();
        //        System.out.println(l1 - (l1%l));
        //
        //        map.put(1L, false);
        //
        //
        //        List<Long> longs = Lists.newArrayList();
        //        longs.add(11L);
        //        LOGGER.debug("long:{}",longs);


        //        Map<Integer, List<Integer>> db2TableIds = Maps.newHashMap();
        //        for (int i = 0; i <= 9; i++) {
        //            int j = i;
        //            List<Integer> tableIds = IntStream.rangeClosed(0, 9999).filter(n -> n % 10 == j).boxed()
        //                    .collect(Collectors.toList());
        //            db2TableIds.put(j, tableIds);
        //        }
        //        System.out.println(db2TableIds);
    }
}
