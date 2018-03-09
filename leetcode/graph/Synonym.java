import java.util.*;

class Synonym {
    public String word1;
    public String word2;

    Synonym () {
    }

    Synonym (String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
    }
}

class SynonymGraph {

    public Map<String, Set<String>> map;

    SynonymGraph () {
        this.map = new HashMap<>();
    }

    SynonymGraph (Map<String, Set<String>> map) {
        this.map = map;
    }

    SynonymGraph (List<Synonym> synonyms) {
        this.map = new HashMap<>();
        for (Synonym synonym : synonyms) {
            addSynonym(synonym);
        }
    }

    public void addSynonym(Synonym synonym) {
        String word1 = synonym.word1;
        String word2 = synonym.word2;
        addWord(word1, word2);
        addWord(word2, word1);
    }

    public void addWord(String word1, String word2) {
        if (!this.map.containsKey(word1)) {
            this.map.put(word1, new HashSet<String>());
        }
        this.map.get(word1).add(word2);
    }

    public boolean matches(String word1, String word2) {
        if (word1.equals(word2)) return true;
        if (!this.map.containsKey(word1) || !this.map.containsKey(word2)) return false;
        Set<String> seen = new HashSet<>();
        Stack<String> stack = new Stack<>();
        seen.add(word1);
        stack.add(word1);
        while (!stack.isEmpty()) {
            String curr = stack.pop();
            Set<String> set = this.map.get(curr);
            for (String next : set) {
                if (!seen.contains(next)) {
                    stack.push(next);
                }
            }
            seen.addAll(set);
            if (seen.contains(word2)) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.map.toString();
    }

}
class Main {

    public static boolean matches(List<Synonym> synonyms, String q1, String q2) {
        SynonymGraph graph = new SynonymGraph(synonyms);
        String[] a1 = q1.split(" ");
        String[] a2 = q2.split(" ");
        if (a1.length != a2.length) return false;
        for (int i = 0; i < a1.length; i++) {
            String w1 = a1[i];
            String w2 = a2[i];
            if (!graph.matches(w1, w2)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Synonym synonym1 = new Synonym("diner", "restaraunt");
        Synonym synonym2 = new Synonym("diner", "eatery");
        List<Synonym> synonyms = Arrays.asList(synonym1, synonym2);
        SynonymGraph graph = new SynonymGraph(synonyms);
        System.out.println(graph.toString());

        String q1 = "I ate at the eatery";
        String q2 = "I ate at the restaraunt";
        System.out.println(matches(synonyms, q1, q2) == true);

        String q3 = "I ate at the hut";
        String q4 = "I ate at the restaraunt";
        System.out.println(matches(synonyms, q3, q4) == false);
    }
}