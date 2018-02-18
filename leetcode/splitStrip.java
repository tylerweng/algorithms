
import java.util.*;
class Main {

    public static void main(String[] args) {
        String s = "/a/b//c///";
        String[] sa = s.split("/");
        System.out.println(Arrays.asList(sa));
        String[] sb = Arrays.stream(sa).filter(sx -> !sx.equals("")).toArray(String[]::new);
        System.out.println(Arrays.asList(sb));
    }
}