package designpatterntest;

/**
 * Created by chayang on 2017/10/8.
 * 单例模式
 * http://cantellow.iteye.com/blog/838473
 */
public class Singleton {


    private Singleton() {
    }

    /**
     * 这种是饿汉模式，一开始就实例化，之后调用getInstance的时候，直接返回。
     * 懒汉模式是指的用到的时候再实例化。
     * 饿汉式在类创建的同时就已经创建好一个静态的对象供系统使用，以后不再改变，所以天生是线程安全的。
     */

    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton);
    }


    /**
     * 这种是懒汉模式，可以延迟初始化
     * 利用的是类加载的机制，当遇到访问静态字段的指令时，初始化该静态字段所在的类；
     * Java 虚拟机会通过加锁来确保类的 < clinit > 方法仅被执行一次。
     */
    private static class LazyHolder {
        static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance2() {
        return LazyHolder.INSTANCE;
    }

}
