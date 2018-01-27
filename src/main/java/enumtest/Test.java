package enumtest;

/**
 * Created by chayang on 2016/12/22.
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("begin");
        DayEnum day1 = DayEnum.MON;
        System.out.println("end");
        System.out.println(day1);//
        System.out.println(day1.name());
        System.out.println(day1.getDesc());
        System.out.println(day1.ordinal());

        DayEnum day2 = DayEnum.valueOf("MON");
        System.out.println(day2);

        for (DayEnum dayEnum : DayEnum.values()) {
            System.out.println(dayEnum.getDesc());
        }

        Animal cat = new Animal(3) {
            @Override
            public void run() {

            }
        };

        boolean b = DayEnum.MON == DayEnum.MON;//枚举可以写成单例
        System.out.println(b);

        /**
         * 枚举就是一个特殊的类，当枚举只有一个成员的时候，就可以当成单例使用
         */
        TrafficLamp trafficLamp = TrafficLamp.GREEN;
        TrafficLamp trafficLamp2 = TrafficLamp.RED;
        TrafficLamp trafficLamp3 = TrafficLamp.YELLOW.nextLamp();
    }


}
