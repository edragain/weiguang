import java.util.List;
import java.util.stream.Collectors;
class Song{
    private String title;
    private String artist;
    private String genre;/*这里原代码是int类型*/
    private int year;
    private int timesPlayed;
    //	利用注解或者自己创建构造器和get方法
    public Song(String title,String artist,String genre,int year,int timesPlayed){
        this.title=title;
        this.artist=artist;
        this.genre=genre;
        this.year=year;
        this.timesPlayed=timesPlayed;
    }
    public String getTitle(){
        return title;
    }
    public String getArtist(){
        return artist;
    }public String getGenre(){
        return genre;
    }
    public int getYear(){
        return year;
    }

    public int getTimesPlayed() {
        return timesPlayed;
    }//终于写好了
}
class Kol {public static void main(String[] args) {/*要命的是不知道用什么方法啊！！！前缀后缀好多功能，要晕了*/
    Songs songs = new Songs();
    List<Song> songList = songs.getSongs();/*.of创建的是一个静态的不能被修改的集合数组，所以我们要新建一个数组*/
    /*---------------------部分1-----------------------------*/
    songList.stream()
            .filter(song -> "Rock".equalsIgnoreCase(song.getGenre()))/*筛选主题为摇滚的*/
            .collect(Collectors.toList());
    /*-------------------------------------------------------*/
    /*--------------------部分2------------------------*/
    songList.stream()
            .map(Song::getGenre)/*映射每个元素到对应的结果*/
            .distinct()/*保留唯一的元素*/
            .forEach(System.out::println);

}}
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
    }}
    