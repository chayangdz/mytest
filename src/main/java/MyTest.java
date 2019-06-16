import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhayang on 2018/3/26.
 */
public class MyTest {

    public static void main(String[] args) {


        List<String> strings = null;
        for (String s : strings) {
            System.out.println(s.toString());
        }

        Method[] methods = MyTest.class.getMethods();
        for (Method method : methods) {
            if (method.getName().equals("change") ) {
                Type[] types = method.getGenericParameterTypes();

//                Class clazz = (Class) types[0];

                if (types[0] instanceof ParameterizedType) {
                    Type trueType =  ((ParameterizedType)types[0]).getActualTypeArguments()[0];
                    System.out.println(trueType);
                }

                System.out.println(types[0]);
            }

        }
    }

    public static void change(List<Person> person) {

    }
}
