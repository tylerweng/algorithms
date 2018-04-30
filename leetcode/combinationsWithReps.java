public class Main {

    public static void main(String[] args) throws IOException {
        LinkedList<char[]> items = new LinkedList<char[]>();
        char[] item = new char[3];
        char[] input = {'A', 'B'};
        rep(items, input, item, 0);


        for (char[] rep : items) {
            System.out.println(rep);
        }
    }

    private static void rep(LinkedList<char[]> reps, char[] input, char[] item, int count){
        if (count < item.length){
            for (int i = 0; i < input.length; i++) {
                item[count] = input[i];
                rep(reps, input, item, count+1);
            }
        }else{
            reps.add(item.clone());
        }
    }

}