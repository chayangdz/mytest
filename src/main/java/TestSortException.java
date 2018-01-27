import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by chayang on 2016/12/20.
 */
public class TestSortException {

    public static void main(String[] args) {
        /*Person p1 = new Person();
        p1.setAge(2);
        p1.setName("2");

        Person p2 = new Person();
        p2.setAge(1);
        p2.setName("1");


        List<Person> persons = new ArrayList<Person>();
        persons.add(p1);
        persons.add(p2);

        Person p3 = new Person();
        p3.setAge(2);
        p3.setName("2");
        persons.add(p3);


        Collections.sort(persons, new Comparator<Person>() {
            public int compare(Person o1, Person o2) {
                if (o1.getAge() < o2.getAge()) {
                    return -1;
                } else {
                    return 1;
                }
//                if (o1.getAge() < o2.getAge()) {
//                    return -1;
//                }else if (o1.getName().equals(o2.getName())) {
//                    return 1;
//                }
//                return 0;
            }
        });

        for (Person person : persons) {
            System.out.println(person.getAge());
        }*/


        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        list.add(1);
        list.add(3);
        list.add(3);
        list.add(5);
        list.add(5);
        list.add(10);
        list.add(10);
        list.add(10);
        list.add(10);
        list.add(11);
        list.add(11);
        list.add(13);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(20);
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1>o2?1:-1;
            }
        });
        for (Integer i : list) {
            System.out.println(i);
        }
    }





}
