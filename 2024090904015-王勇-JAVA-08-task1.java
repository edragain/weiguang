import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class MockSongs {
    public static List<String> getSongStrings(){
        List<String> songs = new ArrayList<>();

        songs.add("sunrise");
        songs.add("noprice");
        songs.add("thanks");
        songs.add("$100");
        songs.add("havana");
        songs.add("114514");
        Collections.sort(songs);
        return songs;
    }
}
class Main {
    public static void main(String[] args) {
        List<String> songs = MockSongs.getSongStrings();
        for (String song : songs) {
            System.out.println(song);
        }
    }
}