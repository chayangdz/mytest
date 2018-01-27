package designpatterntest;

/**
 * Created by chayang on 2017/10/8.
 * 单例模式
 * http://cantellow.iteye.com/blog/838473
 */
public class Singleton {

    /**
     * 这种是饿汉模式，一开始就实例化，之后调用getInstance的时候，直接返回。
     * 饿汉式在类创建的同时就已经创建好一个静态的对象供系统使用，以后不再改变，所以天生是线程安全的。
     */

    private static Singleton instance = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return instance;
    }

    public static void main(String[] args) {
       Singleton singleton =  Singleton.getInstance();
        System.out.println(singleton);
    }
}
