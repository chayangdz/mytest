package threadtest;

import com.google.common.util.concurrent.RateLimiter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhayang on 2019/9/16.
 */
public class RateLimiterTest {
    public static void main(String[] args) {

        RateLimiter rateLimiter = RateLimiter.create(2.0);


        ExecutorService executorService = Executors.newFixedThreadPool(1);


        final long prev = System.currentTimeMillis();
        for (int i=0;i<20;i++) {
            rateLimiter.acquire();

            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    long curr = System.currentTimeMillis();
                    System.out.println(curr );

                }
            });
        }

    }
}
