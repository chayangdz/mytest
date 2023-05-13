package jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;

/**
 * @author zhayang
 * Created on 2020-04-09
 */
public class StreamTest {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("a", "b", "c", "", "e");
        stringList.stream().filter(s -> StringUtils.isNotBlank(s)).forEach(s -> System.out.println(s));

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());


    }
}
