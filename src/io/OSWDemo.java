package io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * java IO将流按照读写单位划分为字节流与字符流
 * java.io.InputStream和OutputStream是所有字节输入与输出流的超类，读写最小单位是字节
 * 而
 * java.io.Reader和Writer则是所有字符输入流与输出流的超类，读写单位最小为字符。
 * 因此注意:字符流仅适合读写文本数据(字符或字符串)。读写文件仅读写文本文件。
 *
 * 字符流底层本质还是读写字节，只是字符与字节的转换由字符流自行完成。
 *
 * 转换流是一对常用的字符流实现类:
 * java.io.InputStreamReader和OutputStreamWriter
 * 实际应用中我们不直接操作这一对流，但是在读写文本数据而组建流连接时他们是非常重要的
 * 一环。
 * 这对流是一对高级流，作用有两个:
 * 1:在流连接中衔接其他高级字符流与下面的字节流(这也是转换流名字的由来)
 * 2:负责将字符与对应的字节按照指定的字符集自动转换方便读写操作。
 *
 */
public class OSWDemo {
    public static void main(String[] args) throws IOException {
        //向文件osw.txt中写入文本年数据
        FileOutputStream fos = new FileOutputStream("osw.txt");
        //在创建转换流时通常需要指定第二个参数，明确使用的字符集。
        OutputStreamWriter osw = new OutputStreamWriter(fos,StandardCharsets.UTF_8);
//        String line = "我可以接受你的所有，所有小脾气。";
//        byte[] data = line.getBytes(StandardCharsets.UTF_8);
//        fos.write(data);

        //字符输出流支持直接写出字符串的write方法
        osw.write("我可以接受你的所有，所有小脾气。");
        osw.write("我可以带你去吃很多，很多好东西。");
        System.out.println("写出完毕!");
        osw.close();
    }
}
