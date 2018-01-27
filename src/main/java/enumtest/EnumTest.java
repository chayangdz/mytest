package enumtest;

import enumtest.WeekDay;

/**
 * Created by chayang on 2016/12/19.
 */
public class EnumTest {
    public static void main(String[] args) {
        WeekDay weekDay = WeekDay.MON;
        System.out.println(weekDay.nextDay());
        WeekDay weekDay1 = WeekDay.SUN;
        System.out.println(weekDay1.nextDay());
    }
}
