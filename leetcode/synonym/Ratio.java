import java.util.*;

class Ratio {

    public String from;
    public String to;
    public double mult;

    Ratio (String from, String to, double mult) {
        this.from = from;
        this.to = to;
        this.mult = mult;
    }
}

class RatioGraph {

    public Map<String, RatioNode> map;

    RatioGraph () {
        this.map = new HashMap<>();
    }

    RatioGraph (Map<String, RatioNode> map) {
        this.map = map;
    }

    RatioGraph(List<Ratio> ratios) {
        this.map = new HashMap<>();
        for (Ratio ratio : ratios) {
            addRatio(ratio);
        }
    }

    public void addRatio(Ratio ratio) {
        String from = ratio.from;
        String to = ratio.to;
        double mult = ratio.mult;
        addRatio(from, to, mult);
        addRatio(to, from, 1/mult);
    }

    public void addRatio(String from, String to, double mult) {
        if (!this.map.containsKey(from)) {
            this.map.put(from, new RatioNode(from));
        }
        this.map.get(from).addEdge(new RatioEdge(to, mult));
    }

    public double convert(String from, String to, double amt) {
        if (!this.map.containsKey(from) || !this.map.containsKey(to)) return -1;
        Map<String, Double> ratios = new HashMap<>();
        Stack<RatioNode> stack = new Stack<>();
        ratios.put(from, amt);
        stack.add(map.get(from));
        while (!stack.isEmpty()) {
            RatioNode curr = stack.pop();
            double res = ratios.get(curr.name);
            if (curr.name.equals(to)) return res;
            for (RatioEdge edge : curr.edges) {
                System.out.println(edge);
                String next = edge.to;
                if (!ratios.containsKey(next)) {
                    stack.add(map.get(next));
                    double mult = edge.mult;
                    double tmp = mult * res;
                    ratios.put(next, tmp);
                }
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("RatioGraph {");
        for (Map.Entry<String, RatioNode> entry : this.map.entrySet()) {
            sb.append("\n").append(entry.getValue());
        }
        sb.append("\n").append("}");
        return sb.toString();
    }

}

class RatioNode {

    public String name;
    public Set<RatioEdge> edges;

    RatioNode (String name) {
        this.name = name;
        this.edges = new HashSet<>();
    }

    public void addEdge(RatioEdge edge) {
        this.edges.add(edge);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.name);
        sb.append(" : ").append(this.edges);
        return sb.toString();
    }

}

class RatioEdge {
    public String to;
    public double mult;

    RatioEdge (String to, double mult) {
        this.to = to;
        this.mult = mult;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        sb.append(this.to).append(" : ").append(this.mult).append("}");
        return sb.toString();
    }
}

class Main {

    public static double convert(List<Ratio> ratios, String from, String to, double amt) {
        RatioGraph graph = new RatioGraph(ratios);
        return graph.convert(from, to, amt);
    }
    public static void main(String[] args) {
        Ratio ratio1 = new Ratio("A", "B", 2.0);
        Ratio ratio2 = new Ratio("C", "D", 1.25);
        Ratio ratio3 = new Ratio("B", "C", 0.75);
        List<Ratio> ratios = Arrays.asList(ratio1, ratio2, ratio3);
        RatioGraph graph = new RatioGraph(ratios);
        System.out.println(graph.toString());
        System.out.println(convert(ratios, "A", "C", 2) == 3);
    }
}
