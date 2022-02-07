package io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 在流连接中使用PW
 */
public class PWDemo2 {
    public static void main(String[] args) throws FileNotFoundException {
        //文件字节输出流(是一个低级流)，向文件中写入字节数据
        FileOutputStream fos = new FileOutputStream("pw2.txt",true);
        //转换输出流(是一个高级流，且是一个字符流)。1:衔接字符与字节流 2:将写出的字符转换为字节
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        //缓冲输出流(是一个高级流，且是一个字符流)。块写文本数据加速
        BufferedWriter bw = new BufferedWriter(osw);
        //具有自动行刷新的缓冲字符输出流
        /*
            PrintWriter提供的构造器中，当第一个参数为一个流时，就支持再传入一个boolean
            型的参数表示是否自动行刷新。当该值为true时则打开了自动行刷新功能。这意味着
            每当我们调用println方法后会自动flush一次。
         */
        PrintWriter pw = new PrintWriter(bw,true);

        //完成简易记事本。控制台输入的每行字符串都按行写入文件。单独输入exit时退出。
        Scanner scanner = new Scanner(System.in);
        while(true){
            String line = scanner.nextLine();
            if("exit".equalsIgnoreCase(line)){
                break;
            }
            pw.println(line);
        }
        pw.close();
    }
}




