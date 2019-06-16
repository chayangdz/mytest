


import com.sun.org.apache.xml.internal.security.utils.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;
import java.util.*;


/**
 * Created by chayang on 2017/5/23.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        String mobile = decrypt("6kD9DVSAXexoEMC8KzwRLQ==".getBytes(), "On1CGiKQ;IyJ^$56MG;U");
        System.out.println(mobile);

        List<Integer> list = Arrays.asList(1,2);

        Integer[] cityIds = {1,3,16,25,22,12};

        for (int i = 0; i < cityIds.length; i++) {
//            list.add(cityIds[i]);
        }

        Map<String, String > map = new HashMap<String, String>();
        map.put("aa", "a");

        Person p = (Person) null;


        String s = "ADVsda_dwe123";
        System.out.println(s.toLowerCase());

        Set<String> set = new HashSet<String>();
        set.add("abc");
        set.add("add");
        set.add("asd");
        set.add("add");

        System.out.println(set.toString());

        List<String> list1 = new ArrayList<String>();
        list1.add("acb");
        list1.add("sd");
        list1.add("acsdab");
        list1.add("ds");
        String ada = list1.toString();
        System.out.println(ada);

    }
    public static String decrypt(byte[] src, String password) throws Exception {
        SecureRandom random = new SecureRandom();
        DESKeySpec desKey = new DESKeySpec(password.getBytes());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKey);
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey, random);
        byte[] b = cipher.doFinal(Base64.decode(new String(src)));
        return new String(b, "utf-8");

    }

    public static void test(int i) {

    }

    public static void test(String i) {

    }


}
