package inittest;

import org.springframework.stereotype.Service;

/**
 * @author zhayang <zhayang@kuaishou.com>
 * Created on 2021-06-15
 */
@Service
public class MyTest extends Test {

    public static void main(String[] args) {
        System.out.println(4608 >> 12 & 1L);
    }

}
