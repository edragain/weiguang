import java.util.ArrayList;
import java.util.List;

class Song {
    private String title;
    private String artist;
    private int bpm;

    public Song(String title, String artist, int bpm) {
        this.title = title;
        this.artist = artist;
        this.bpm = bpm;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getBpm() {
        return bpm;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setBpm(int bpm) {
        this.bpm = bpm;
    }
}

class Mock {
    public List<Song> getSongList() {
        List<Song> songs = new ArrayList<>();
        songs.add(new Song("爱在西元前", " 周杰伦 ", 80));
        songs.add(new Song("找自己", "陶喆", 80));
        songs.add(new Song("茉莉雨", "林俊杰", 50));
        songs.add(new Song("花田错", "王力宏", 50));
        songs.add(new Song("三人游", "方大同", 50));
        return songs;
    }

    public static void main(String[] args) {
        Mock mock = new Mock();
        List<Song> songList = mock.getSongList();
        for (Song song : songList) {
            System.out.println("Title: " + song.getTitle()+ " Artist:" + song.getArtist()+" BPM:" + song.getBpm());
        }
    }
}