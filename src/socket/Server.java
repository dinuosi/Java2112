package socket;

import java.net.ServerSocket;

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

    }
    public void start(){

    }

    public static void main(String[] args) {

    }

}
