package enumtest;

/**
 * Created by zhayang on 2018/9/2.
 */
public class Day {

    private String name;
    private DayEnum dayEnum;
    private Class aClass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DayEnum getDayEnum() {
        return dayEnum;
    }

    public void setDayEnum(DayEnum dayEnum) {
        this.dayEnum = dayEnum;
    }


    public static void main(String[] args) {
        Day day = new Day();
        day.setName("monday");
        day.setDayEnum(DayEnum.MON);


        DayEnum dayEnum = day.getDayEnum();
        System.out.println(dayEnum);
        System.out.println(dayEnum.getDesc());





    }
}
