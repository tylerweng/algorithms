import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

class Reservoir {

    /*
     * first value in given example has a 2/6 == 1/3 chance of being set to 1
     * second value has a (1 - 2/6) * (2 / 5) + (2/6) * (1/5) chance of being set to 1
     * == (4/6) * (2/5) + (2/6) * (1/5)
     * == (8/30) + (2/30) == (10/30) == 1/3
     * this continues ad nausea giving each pos in our matrix a 1/3 chance og being set to 1
     */


    public static void main(String[] args) {
        int m = 2;
        int n = 3;
        int[][] tally = new int[m][n];
        int[][] matrix = new int[m][n];
        int k = 2;
        int numSamples = 600;
        for (int i = 0; i < numSamples; i++) {
            fillAtRandom(matrix, k);
            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    if (matrix[x][y] == 1) tally[x][y]++;
                }
            }
            for (int z = 0; z < m; z++) {
                Arrays.fill(matrix[z], 0);
            }
        }
        System.out.println(String.format("Tally after %d samples", numSamples));
        System.out.println(Arrays.deepToString(tally));
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