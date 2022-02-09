package io;

import java.io.*;

/**
 * 缓冲字符输入流:java.io.BufferedReader
 * 1:块读文本数据加速
 * 2:可以按行读取字符串
 */
public class BRDemo {
    public static void main(String[] args) throws IOException {
        //将当前程序的源代码输出到控制台上
        //文件字节输入流，低级流，字节流。功能:从文件中读取字节
        FileInputStream fis = new FileInputStream("./src/io/BRDemo.java");
        //转换输入流，高级流，字符流。功能:1衔接字节与其他字符流  2:将读取的字节转换为字符
        InputStreamReader isr = new InputStreamReader(fis);
        //缓冲字符输入流，高级流，字符流。功能:1块读文本数据加速 2:按行读取字符串
        BufferedReader br = new BufferedReader(isr);
        /*
            缓冲字符输入流提供的读取一行字符串的方法:
            String readLine()
            该方法会连续读取若干字符，到换行符为止，然后将换行符之前的内容以一个字符串形式
            返回。注意:返回的字符串中不含有最后的换行符。
            如果单独读取了空行(此行内容只有一个换行符，比如当前源代码中的第二行就是空行)，
            那么会返回一个空字符串。
            当方法返回值为null时，表示流读取到了末尾。
         */
        String line;
        while((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();



    }
}


