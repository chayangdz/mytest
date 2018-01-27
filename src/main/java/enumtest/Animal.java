package enumtest;

/**
 * Created by chayang on 2016/12/22.
 */
public abstract class Animal {
    private int eye;
    public Animal(){
        System.out.println("no parameter constructor");
    }
    public Animal(int eye) {
        System.out.println("one parameter constructor");
    }

    public abstract void run();
}
