package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

/**
 * 聊天室服务端
 */
public class Server {
    /**
     * java.net.ServerSocket
     * ServerSocket是运行在服务端的，它的主要工作:
     * 1:打开服务端口(客户端就是通过这个端口与服务端建立链接)
     * 2:监听该服务端口，一旦一个客户端链接，则会返回一个Socket实例，并通过这个
     *   Socket实例与链接的客户端进行交互
     *
     * 如果我们将Socket比喻为"电话"，那么ServerSocket相当于是"总机"。
     *
     */
    private ServerSocket server;

    public Server(){
        try {
            /*
                实例化ServerSocket的同时需要指定打开的服务端口，客户端就是通过该
                端口建立链接的。
                如果该端口已经被操作系统其他程序占用了，那么这里会抛出异常:
                java.net.BindException:address already in use
                         绑定异常        地址    已经     被占用了
             */
            System.out.println("正在启动服务端...");
            server = new ServerSocket(8088);
            System.out.println("服务端启动完毕!");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void start(){
        try {
            /*
                ServerSocket提供的方法:
                Socket accept()
                该方法是一个阻塞方法，调用后开始等待，直到一个客户端与服务端建立链接
                为止，此时该方法会立即返回一个Socket，通过这个Socket与该客户端交互
             */
            while (true) {
                System.out.println("等待客户端链接...");
                Socket socket = server.accept();
                System.out.println("一个客户端链接了!");
            }
            /*
                通过Socket的方法:
                InputStream getInputStream()
                获取一个字节输入流，可以读取来自远端计算机发送过来的字节数据
             */
/*            InputStream in = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);

            String line ;
            while((line = br.readLine())!=null){
                System.out.println("客户端说:" + line);
            }*/
//        } catch (SocketException e){
//            System.out.println("异常断开");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

}
