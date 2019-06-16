package litan;

/**
 * Created by zhayang on 2019/1/13.
 */
public class Litan extends Animal {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Litan litan = new Litan();
        litan.setName("litan");
        test(litan);

        Dog dog = new Dog();
        dog.setWangwang("wangwang");
        test(dog);
    }

    public static void test(Animal animal) {
        if (animal.getClass() == Litan.class) {
            Litan litan = (Litan) animal;
            String name = litan.getName();
        }
        if (animal.getClass() == Dog.class) {
            Dog dog = (Dog) animal;
            String wangwang = dog.getWangwang();
        }
        Litan litan = (Litan) animal;
        String name = litan.getName();
    }
}
