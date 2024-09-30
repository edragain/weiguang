import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class SimpleChatServer {
    private final List<PrintWriter> clientWriters = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        new SimpleChatServer().go();
    }
    public void go() throws IOException {
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.bind(new InetSocketAddress(5000));
        while(true){
            SocketChannel clientChannel = serverChannel.accept();
            Socket clientSocket = clientChannel.socket();
            OutputStream outputStream=clientSocket.getOutputStream();
            PrintWriter printWriter=new PrintWriter(new OutputStreamWriter(outputStream,StandardCharsets.UTF_8));
            clientWriters.add(printWriter);
            ClientHandler handler = new ClientHandler(clientSocket);
            Thread t = new Thread(handler);
            t.start();//创建线程
            }
        }
        public void tellEveryone(String message)/*改写成向每个客户端输出内容*/
        {
            for (PrintWriter writer : clientWriters) {
                writer.println(message);
                writer.flush();
            }
        }
    public class ClientHandler implements Runnable{
        private Socket client;
        public ClientHandler(Socket client){
            this.client = client;
        }
        public void run(){
            try {tellEveryone("hello,client!");
                InputStream inputStream = client.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String message1;
                while((message1= bufferedReader.readLine())!=null){

                    System.out.println(message1);/*接收客户端发出信息并输出*/
                }

            } catch (IOException e) {
            }
        }
    }
}