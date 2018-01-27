package genericitytest;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chayang on 2017/1/15.
 */
public class Test {

    public static void main(String[] args) throws Exception {
        /**
         * 泛型是去类型化的
         * 编译器编译时会进行类型检查，编译完之后会擦除类型信息
         * 可以通过反射来跳过编译的检查，往泛型里面放其它类型的数据
         */
        ArrayList<Integer> list = new ArrayList<Integer>();
        Method method = list.getClass().getMethod("add", Object.class);
        method.invoke(list, "abc");
        System.out.println(list.get(0));

        /**
         * 泛型是去类型化的，所以编译完之后，就无法知道这个参数里面具体放了什么类型的数据
         * 但是可以以泛型的形式获取方法的参数列表
         * Type 是 Java 编程语言中所有类型的公共高级接口。
         * Type 包括原始类型、参数化类型、数组类型、类型变量和基本类型。
         * Class就是Type的一个实现类
         * ParameterizedType 表示参数化类型，继承自Type
         */
        Method method1 = Test.class.getMethod("test", List.class);
        //getGenericParameterTypes可以获取泛型的参数类型，返回的是数组，因为可能有多个参数
        Type[] types = method1.getGenericParameterTypes();
        //test方法只有一个入参，获取第0个元素，就是test方法的参数了
        ParameterizedType parameterizedType = (ParameterizedType) types[0];
        System.out.println(parameterizedType);
        System.out.println(parameterizedType.getRawType());
        System.out.println(parameterizedType.getActualTypeArguments()[0]);
    }

    public static void test(List<Integer> list) {
    }

//    public static void test(List<String> list) {
//    }
}
