import java.io.*;
import java.util.Collections;
import java.util.List;

class Songs {
    public List<Song> getSongs() {
        return List.of(
                new Song("$10", "Hitchhiker", "Electronic", 2016, 183),
                new Song("Havana", "Camila Cabello", "R&B", 2017, 324),
                new Song("Cassidy", "Grateful Dead", "Rock", 1972, 123),
                new Song("50 ways", "Paul Simon", "Soft Rock", 1975, 199),
                new Song("Hurt", "Nine Inch Nails", "Industrial Rock", 1995, 257),
                new Song("Silence", "Delerium", "Electronic", 1999, 134),
                new Song("Hurt", "Johnny Cash", "Soft Rock", 2002, 392),
                new Song("Watercolour", "Pendulum", "Electronic", 2010, 155),
                new Song("The Outsider", "A Perfect Circle", "Alternative Rock", 2004, 312),
                new Song("With a Little Help from My Friends", "The Beatles", "Rock", 1967, 168),
                new Song("Come Together", "The Beatles", "Blues rock", 1968, 173),
                new Song("Come Together", "Ike & Tina Turner", "Rock", 1970, 165),
                new Song("With a Little Help from My Friends", "Joe Cocker", "Rock", 1968, 46),
                new Song("Immigrant Song", "Karen O", "Industrial Rock", 2011, 12),
                new Song("Breathe", "The Prodigy", "Electronic", 1996, 337),
                new Song("What's Going On", "Gaye", "R&B", 1971, 420),
                new Song("Hallucinate", "Dua Lipa", "Pop", 2020, 75),
                new Song("Walk Me Home", "P!nk", "Pop", 2019, 459),
                new Song("I am not a woman, I'm a god", "Halsey", "Alternative Rock", 2021, 384),
                new Song("Pasos de cero", "Pablo Alborán", "Latin", 2014, 117),
                new Song("Smooth", "Santana", "Latin", 1999, 244),
                new Song("Immigrant song", "Led Zeppelin", "Rock", 1970, 484));
    }
}
class Song implements Serializable{
    private String title;
    private  String artist;
    private  String genre;
    private int year;
    private int timeplayer;
    public Song(String title,String artist,String genre,int year,int timeplayer){
        this.title=title;
        this.artist=artist;
        this.genre=genre;
        this.year=year;
        this.timeplayer=timeplayer;
    }
    @Override
    public String toString() {
        return "Song:"+title+" "+"artist:"+artist+"genre:"+genre+"year:"+year+"timeplayer:"+timeplayer;
        /*重写toString使得输出结果更直观*/
    }}
class KL {
    public static void main(String[] args) {
        Songs songs = new Songs();
        List<Song> songList = songs.getSongs();/*创建一个对象进行写入*/
        try (FileOutputStream fileOut = new FileOutputStream("test.txt");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(songList);
        } catch (IOException i) {
            i.printStackTrace();
        }
        List<Song> Songs1 = null;
        try (FileInputStream fileIn = new FileInputStream("test.txt");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            Songs1 = (List<Song>) in.readObject();
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
        for(Song a:Songs1)
            System.out.println(a);
    }
    }
