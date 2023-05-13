package nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author zhayang <zhayang@kuaishou.com>
 * Created on 2021-09-21
 */
public class BufferTest {


    public static void main(String[] args) throws Exception {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        FileInputStream fi = new FileInputStream("");
        FileChannel fileChannel = fi.getChannel();
        fileChannel.read(buffer);
        buffer.flip();
        while (buffer.hasRemaining()) {
            byte b = buffer.get();
            System.out.println(b);
        }
        buffer.clear();
    }
}
