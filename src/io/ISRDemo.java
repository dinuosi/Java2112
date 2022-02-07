package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * 使用转换流测试读取文本数据
 */
public class ISRDemo {
    public static void main(String[] args) throws IOException {
        //将osw.txt中的所有内容读取出来并输出到控制台
        FileInputStream fis = new FileInputStream("osw.txt");
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
        //读取1个字符，返回的int值内容本质上是一个char。但是若返回的int为-1则表示读取到了末尾
//        int d = isr.read();
//        System.out.println((char)d);

        int d;
        while((d = isr.read()) != -1){
            System.out.print((char)d);
        }
        isr.close();
    }
}
