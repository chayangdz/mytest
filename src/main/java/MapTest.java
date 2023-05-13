import static com.kuaishou.framework.util.ObjectMapperUtils.fromJson;
import static com.kuaishou.framework.util.ObjectMapperUtils.toJSON;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.collect.Maps;

/**
 * @author zhayang <zhayang@kuaishou.com>
 * Created on 2021-12-03
 */
public class MapTest {

    public static void main(String[] args) {

        Map<Integer, String> winNumberMap = Maps.newHashMap();

        String number = "1234";
        char[] chars = number.toCharArray();

        for (int i = 1; i < 1001; i++) {
            winNumberMap.put(i, String.format("%04d", new Random().nextInt(10000)));
        }

        Map<Integer, Long> collect = IntStream.range(1, 1000)
                .mapToObj(winNumberMap::get)
                .map(String::toCharArray)
                .map(m -> Integer.parseInt(String.valueOf(m)))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(collect);

        Map<Integer, AtomicInteger> numberCountMap = Maps.newHashMap();
        for (int i = 0; i < 10; i++) {
            numberCountMap.put(i, new AtomicInteger(0));
        }
        Map<Integer, String> resultMap = Maps.newHashMap();
        for (int i = 1; i < 1001; i++) {
            String winningNumber = winNumberMap.get(i);
            for (int j = 0; j < 4; j++) {
                Integer key = Integer.parseInt(String.valueOf(winningNumber.charAt(j)));
                numberCountMap.get(key).addAndGet(1);
            }
            resultMap.put(i, numberCountMap.toString());
        }

    }
}
