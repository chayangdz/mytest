import com.daojia.open.platform.common.security.utils.MD5;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * Created by chayang on 2017/7/18.
 */
public class SignTest {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("accessToken", "aaa");
        map.put("serviceKey", "aaa");
        map.put("format", "aaa");
        map.put("timestamp", "aaa");
        map.put("daojiaJson", "aaa");

        String serviceSecret = "aaa";

        String sign = getSign(map, serviceSecret);//得到了sign
    }

    /**
     * 生成加密值
     * @param map map中含有accessToken，serviceKey，format，timestamp，daojiaJson这五个参数
     * @param serviceSecret 商家的秘钥
     * @return 加密值
     */
    private static String getSign(Map<String, String> map, String serviceSecret) {
        SortedMap<String, String> sortMap = new TreeMap<String, String>(map);

        String sortParam = getSortParam(sortMap);

        String sign = StringUtils.upperCase(MD5.encode(serviceSecret + sortParam + serviceSecret));

        return sign;
    }

    // 参数排序
    public static String getSortParam(SortedMap<String, String> map) {
        StringBuffer buffer = new StringBuffer();
        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            buffer.append(key + value);
        }
        return buffer.toString();
    }


}
