package chapter_freq;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Socket概述
 ①   所谓Socket通常也称作“套接字”，用于描述IP地址和端口，是一个通信链的句柄。应用程序通常通过“套接字”向网络发出请求或者应答网络请求。
 ②   Socket是连接运行在网络上的两个程序间的双向通信的端点。
 ③   网络通讯其实指的就是Socket间的通讯。
 ④   通讯的两端都有Socket，数据在两个Socket之间通过IO来进行传输。

 使用Socket进行网络通信的过程
 ①   服务器程序将一个套接字绑定到一个特定的端口，并通过此套接字等待和监听客户的连接请求。
 ②   客户程序根据服务器程序所在的主机和端口号发出连接请求。
 ③   如果一切正常，服务器接受连接请求。并获得一个新的绑定到不同端口地址的套接字。
 ④   客户和服务器通过读、写套接字进行通讯。

 * 基于TCP协议的Socket编程
 ①   创建TCP服务端步骤：
 a)         创建一个ServerSocket对象
 b)         调用accept()方法接受客户端请求
 c)         从Socket中获取I/O流
 d)         对I/O流进行读写操作，完成与客户端的交互
 e)         关闭I/O流和Socket
 ②   创建TCP客户端步骤：
 a)         创建一个Socket对象
 b)         从Socket中获取I/O流
 c)         对I/O流进行读写操作，完成与服务端的交互
 d)         关闭I/O流和Socket
 注：客户端和服务端进行数据传输时，客户端的输入流对应服务端的输出流，客户端的输出流对应服务端的输入流。
 * Created by 18710 on 2017/9/12.
 */
public class T5Socket {

    /**
     * 服务端：监听端口
     * @throws Exception
     */
    public static void server() throws Exception {
        // 1. 创建一个ServerSocket对象
        ServerSocket serverSocket = new ServerSocket(8888);
        // 2. 调用accept()方法接受客户端请求
        Socket socket = serverSocket.accept();
        System.out.println(socket.getInetAddress().getHostAddress() + "连接成功");
        // 3. 获取socket对象的输入输出流
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
        String line = null;
        // 4. 读取客户端传过来的数据
        while ((line = br.readLine()) != null) {
            if (line.equals("over")) {
                break;
            }
            System.out.println(line);
            pw.println(line.toUpperCase());
        }
        // 5. 关闭I/O流和Socket
        pw.close();
        br.close();
        socket.close();
        System.out.println(socket.getInetAddress().getHostAddress() + "断开连接");
    }

    /**
     * 客户端：发送数据
     * @throws Exception
     */
    public static void client() throws Exception {
        // 1. 创建一个Socket对象
        Socket socket = new Socket("127.0.0.1", 8888);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 2. 从Socket中获取I/O流
        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // 3. 对I/O流进行读写操作，完成与服务端的交互
        while (true) {
            String line = br.readLine();
            pw.println(line);
            if (line.equals("over")) {
                break;
            }
            System.out.println(reader.readLine());
        }
        // 4. 关闭I/O流和Socket
        reader.close();
        br.close();
        pw.close();
        socket.close();
    }

}
