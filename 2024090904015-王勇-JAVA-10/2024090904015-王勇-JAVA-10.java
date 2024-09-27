import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
class Main{
    public static void main(String[] args)
    {  //基于建立客户端的socket网络编程，服务器编写与之有些类似
        try {/*--------------建立连接------------------------*/
        Socket socket = new Socket("127.0.0.1",8888);
        /*-------------------读取信息---------------------------*/
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String message = bufferedReader.readLine();
        /*-----------------------使用PrintWriter发送信息------------------------------*/
            OutputStream outputStream=socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));/*定义一个printwriter来发送信息,括号里还能设置参数true来自动刷新*/
            printWriter.write(message+"\n");/*将message和回车写入缓存区*/
            printWriter.flush();/*将缓存区内容输出出去*/
            /*
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
           bw.write(mess+"\n");
           bw.flush();根据菜鸟教程不使用printwriter，也可以使用BufferedWriter来发送信息
            */
    } catch (UnknownHostException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
        }
    }