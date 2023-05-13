package spring;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zhayang <zhayang@kuaishou.com>
 * Created on 2021-10-09
 */
public class AutowiredTest {

    @Autowired
    private List<MyTest> myTests;


    @PostConstruct
    private void init() {
        System.out.println(myTests.size());
    }

    public static void main(String[] args) {
        System.out.println("FJ795GKH".hashCode());
    }


}
