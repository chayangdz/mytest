package enumtest;

/**
 * Created by chayang on 2016/12/24.
 */
public enum TrafficLamp {
    RED(30) {
        public TrafficLamp nextLamp() {
            return null;
        }
    },
    GREEN(45) {
        public TrafficLamp nextLamp() {
            return null;
        }
    },
    YELLOW(5) {
        public TrafficLamp nextLamp() {
            return null;
        }
    };

    private int time;

    TrafficLamp(int time) {
        this.time = time;
    }

    public abstract TrafficLamp nextLamp();

    public int getTime() {
        return time;
    }
    /**
     * 定义了一个抽象的方法nextLamp()
     * 而对于枚举类的每个元素(RED,GREEN,YELLOW)，都是一个实例对象
     * 所以每个枚举城成员都需要实现nextLamp()这个方法
     */
}
