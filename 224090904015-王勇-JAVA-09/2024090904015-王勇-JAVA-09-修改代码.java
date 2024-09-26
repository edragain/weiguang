import java.util.List;
import java.util.stream.Stream;
class Main {
    public static void main(String[] args) {
        List<String> strings = List.of("I", "am", "a", "list", "of", "Strings");
        Stream<String> stream = strings.stream();
        Stream<String> limit = stream.limit(4);
        limit.forEach(System.out::println);
        }
    }