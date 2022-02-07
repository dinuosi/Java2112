package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * 缓冲字符流
 * java.io.BufferedWriter和BufferedReader
 * 缓冲字符流内部维护一个数组，可以块读写文本数据来进行读写性能的提升。
 *
 * java.io.PrintWriter是具有自动行刷新功能的缓冲字符输出流，内部总是连接BufferedWriter
 * 实际开发中缓冲字符输出流我们都使用它。
 * 特点:
 * 1:可以按行写字符串
 * 2:可以自动行刷新
 * 3:可以提高写出字符的效率(实际由内部连接的BufferedWriter完整)
 *
 */
public class PWDemo {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        //向文件pw.txt中写入文本数据
        /*
            PrintWriter提供了直接对文件做操作的构造器
            PrintWriter(String fileName)
            PrintWriter(File file)

            以上两种构造器都支持一个重载，允许再传入一个String类型的参数用来指定字符集。
            需要注意字符集名字的拼写，大小写均可，但是拼写错误会抛出异常:
            UnsupportedEncodingException
            Unsupported:不支持
            Encoding:编码
         */
        PrintWriter pw = new PrintWriter("./pw.txt", "UTF-8");
//        File file = new File("./pw.txt");
//        PrintWriter pw = new PrintWriter(file);
        pw.println("该配合你演出的我演视而不见。");
        pw.println("别逼一个最爱你的人即兴表演。");
        System.out.println("写出完毕!");
        pw.close();


    }
}




