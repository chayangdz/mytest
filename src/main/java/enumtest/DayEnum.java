package enumtest;

/**
 * Created by chayang on 2016/12/22.
 */
public enum DayEnum {
    MON(1, "Monday"),
    TUES(2, "Tuesday"),
    WED(3, "Wednesday"),
    THUR(4, "Thursday"),
    FRI(5, "Friday"),
    SAT(6, "Saturday"),
    SUN(7, "Sunday");

    private int code;
    private String desc;

    DayEnum(int code, String desc) {
        System.out.println("constructor");
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    /**
     * 元素列表要在最前面
     * 枚举里面的元素，相当于是静态变量，在使用枚举的时候，就会把里面的元素全都初始化
     * 在第一次使用枚举中的元素时，就会看到构造方法里的"constructor"打印七次
     * 枚举的构造方法，必须是私有的
     */
}
