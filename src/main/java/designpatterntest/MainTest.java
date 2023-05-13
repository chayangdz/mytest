package designpatterntest;

import designpatterntest.Config.ConfigBuilder;

/**
 * @author zhayang <zhayang@kuaishou.com>
 * Created on 2021-11-27
 */
public class MainTest {

    public static void main(String[] args) {
        Config config = ConfigBuilder.aConfig()
                .withName("name")
                .withCreateTime(System.currentTimeMillis())
                .withConfig1(1)
                .withConfig2(2).build();
    }
}
