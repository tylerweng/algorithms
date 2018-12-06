import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

class Main {

    /*
     * first value in given example has a 2/6 == 1/3 chance of being set to 1
     * second value has a (1 - 2/6) * (2 / 5) + (2/6) * (1/5) chance of being set to 1
     * == (4/6) * (2/5) + (2/6) * (1/5)
     * == (8/30) + (2/30) == (10/30) == 1/3
     */

    public static void main(String[] args) {
        int[][] matrix = new int[2][3];
        int k = 2;
        fillAtRandom(matrix, k);
        System.out.println(Arrays.deepToString(matrix));
    }
    static void fillAtRandom(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int t = m * n;
        for (int i = 0; i < m; i++) {
            if (k == 0) break;
            for (int j = 0; j < n; j++) {
                if (k == 0) break;
                int rand = ThreadLocalRandom.current().nextInt(0, t);
                if (rand < k) {
                    matrix[i][j] = 1;
                    k--;
                }
                t--;
            }
        }
    }
}