import com.google.common.collect.Lists;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by zhayang on 2019/8/4.
 */
public class ExceptionTest {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionTest.class);

    public static void main(String[] args) {

        try {
            List<String> list = Lists.newArrayList();
            list.add("s");
            list.get(2);
            System.out.println("hahahha");
            list.wait();
        } catch (Exception e) {
            logger.debug("hahah", e);
        }


    }

}
