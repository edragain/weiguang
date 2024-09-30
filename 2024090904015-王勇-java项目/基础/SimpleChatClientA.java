import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class SimpleChatClientA {
    private PrintWriter printWriter;
    private SocketChannel socketChannel;

    public void go() {
        setUpNetworking("127.0.0.1", 5000);
        sendMessage("Hello, Internet!");
    }

    private void setUpNetworking(String address, int port) {
        try {
            socketChannel = SocketChannel.open(new InetSocketAddress(address, port));
            OutputStream outputStream = socketChannel.socket().getOutputStream();
            printWriter = new PrintWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8), true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(String message) {
        printWriter.println(message);
    }

    public static void main(String[] args) {
        SimpleChatClientA simpleChatClientA = new SimpleChatClientA();
        simpleChatClientA.go();
    }
}