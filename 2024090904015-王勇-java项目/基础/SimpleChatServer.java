import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

public class SimpleChatServer {
    private final List<PrintWriter> clientWriters = new ArrayList<>();
    private Socket socket;
    private String message1;
    public static void main(String[] args) throws IOException {
        new SimpleChatServer().go();
    }
    public void go() throws IOException {
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.bind(new InetSocketAddress(5000));
        SocketChannel clientChannel = serverChannel.accept();
            Socket clientSocket = clientChannel.socket();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            message1=bufferedReader.readLine();
            tellEveryone(message1);/*
            while ((message1= bufferedReader.readLine()) != null) {
                tellEveryone(message1);
                如果有多行需要输出可以用这个
            }*/
        }

        public void tellEveryone(String message)
        {
            System.out.println(message);
        }
}