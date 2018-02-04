public class Main {
    public static Integer[] arrayIntersection(Integer[] a, Integer[] b) {
        List<Integer> intersection = new ArrayList<>();
        Map<Integer, Integer> countA = new HashMap<>();
        for (Integer i : a) {
            if (!countA.containsKey(i)) {
                countA.put(i, 1);
            } else {
                countA.put(i, countA.get(i) + 1);
            }
        }
        for (Integer j : b) {
            if (countA.containsKey(j) && countA.get(j) > 0) {
                intersection.add(j);
                countA.put(j, countA.get(j) - 1);
            }
        }
        return intersection.toArray(new Integer[intersection.size()]);
    }
}
