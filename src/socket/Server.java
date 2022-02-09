package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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
                实例化ServerSocket的同时需要指定打开的服务端口，客户端就是通过该端口建立链接的。
                如果该端口已经被才做系统其他应用程序占用了，那么这里会抛出异常：
                java.net.BindException:address already in use
                            绑定异常      地址    已经    被占用了
             */
            System.out.println("正在启动服务端...");
            server = new ServerSocket(8088);
            System.out.println("服务端启动完毕！");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void start(){
        try {
            /*
                SeverSocket提供的方法：
                Socket accept()
                该方法是一个阻塞方法，调用后开始等待，直到一个客户端与服务端建立链接为止，
                此时该方法会立即返回一个Socket，通过这个Socket与该客户端交互
             */
            System.out.println("等待客户端连接");
            Socket socket = server.accept();
            System.out.println("一个客户端连接了！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

}
