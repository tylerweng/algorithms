import java.util.*;
class Main {
    public static String strSort(String s1, String s2) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : s1.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : s2.toCharArray()) {
            if (map.containsKey(c)) {
                while (map.get(c) > 0) {
                    sb.append(c);
                    map.put(c, map.get(c) - 1);
                }
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character c = entry.getKey();
            int i = entry.getValue();
            while (i-- > 0) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(strSort("program", "grapo").equals("grrapom"));
    }
}