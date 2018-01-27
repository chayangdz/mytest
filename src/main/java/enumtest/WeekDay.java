package enumtest;

/**
 * Created by chayang on 2016/12/19.
 */
public abstract class WeekDay {
    private WeekDay() {}

    public static final WeekDay SUN = new WeekDay(){
        public WeekDay nextDay() {
            return MON;
        }
    };
    public static final WeekDay MON = new WeekDay(){
        @Override
        public WeekDay nextDay() {
            return SUN;
        }
    };

    public abstract WeekDay nextDay();

    /*public enumtest.WeekDay nextDay() {
        if (this == SUN) {
            return MON;
        } else {
            return SUN;
        }
    }*/

    @Override
    public String toString() {
        if (this == SUN) {
            return "星期天";
        }else {
            return "星期一";
        }
    }
}
