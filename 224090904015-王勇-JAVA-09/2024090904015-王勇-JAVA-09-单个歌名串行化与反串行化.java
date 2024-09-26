import java.io.*;

class Song implements Serializable {
    private static final long serialVersionUID = 2L;/*建议自行建立一个uid*/
    private String title;
    private  String artist;
    private String genre;
    int year;
    int timesPlayed;
    public Song(String title,String artist,String genre,int year,int timesPlayed){
        this.title=title;
        this.artist=artist;
        this.genre=genre;
        this.year=year;
        this.timesPlayed=timesPlayed;
    }
}
class KL {
    public static void main(String[] args) {
        Song a = new Song("爱爱爱", "方大同", "RNB", 114, 514);
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("test.txt"))) {
            objectOutputStream.writeObject(a);//串流化写入
            objectOutputStream.close();/*关闭输出流*/
        } catch (IOException e) {
            System.out.println("输入错误");/*刚编译时显示“必须对其进行捕获或声明以便抛出”于是就写了个trycatch*/}
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("test.txt"));){
            Object object =objectInputStream.readObject();
            Song s1 = (Song) object;
            System.out.println(s1);
        } catch (FileNotFoundException e){
            System.out.println("文件找不到");//这里也是需要trycatch
        }
        catch (IOException e){System.out.println("输入错误");}
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    }
