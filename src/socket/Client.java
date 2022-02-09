package socket;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 聊天室客户端
 */
public class Client {
    /**
     * java.net.Socket 套接字
     * Socket封装了TCP协议的通讯细节，我们使用他可以与远端计算机建立TCP链接。并
     * 基于一堆流的IO操作完成与远端计算机的数据交换。
     */
    private Socket socket;

    /**
     * 初始化客户端
     */
    public Client(){
        try {
            /*
                实例化Socket时需要传入两个参数:
                参数1:远端计算机的地址信息
                参数2:远端计算机打开的服务端口
                上述构造器实例化的过程就是与远端计算机建立链接的过程，如果成功建立链接
                则实例化成功，否则构造器会抛出异常。
                我们通过远端计算机地址(IP)可以找到网络上的远端计算机，通过服务端口可以
                链接上运行在该计算机上的服务端应用程序(就是这个程序开打的该端口等待我们
                链接的。)

                本机地址信息可以选取:
                localhost
                127.0.0.1
             */
            System.out.println("正在链接服务端...");
            socket = new Socket("localhost",8088);
            System.out.println("与服务端建立链接!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 客户端开始工作的方法
     */
    public void start(){
        try {
            /*
                通过Socket的方法：
                OutputStream getOutputStream()
                获取字节输出流写出的字节会通过网络发送给远端建立好链接的计算机
             */
            OutputStream out = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(out, StandardCharsets.UTF_8);
            BufferedWriter bw = new BufferedWriter(osw);
            PrintWriter pw = new PrintWriter(bw,true);//自动flush

            pw.println("你好，服务端");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }
}