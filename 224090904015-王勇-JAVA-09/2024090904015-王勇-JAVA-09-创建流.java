import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
class ain {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("时代少年团，我们喜欢你");
        list.add("马嘉祺");
        list.add("丁程鑫");
        list.add("宋亚轩");
        list.stream();/*一般这样就算搞完了，但是我们可以将操作堆叠在一起比如
            .map();
            .sorted();*/
    }
}