package inittest;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * @author zhayang <zhayang@kuaishou.com>
 * Created on 2021-06-15
 */
@Service
public class Test implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("aaa");
    }
}
