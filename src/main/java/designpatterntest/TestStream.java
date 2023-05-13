package designpatterntest;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author zhayang <zhayang@kuaishou.com>
 * Created on 2021-04-10
 */
public class TestStream {

    public static void main(String[] args) throws Exception {
        InputStream in = new FileInputStream("");
        InputStream bin = new BufferedInputStream(in);
        DataInputStream dataInputStream = new DataInputStream(bin);

    }
}
