import java.util.*;
class Solution {
    public static int getRoutes(int[] a, int[] b, int[] c) {
        int n = a.length;
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        int count = 0;
        int ai = 0, bi = 0, ci = 0;
        while (ai < n && bi < n && ci < n) {
            if (a[ai] < b[bi] && b[bi] < c[ci]) {
                count += (n - ci);
                if (count > 1_000_000_000) return -1;
                ++bi;
                if (bi == n) {
                    ++ai;
                    if (ai == n) return count > 1_000_000_000 ? -1 : count;
                    bi = 0;
                }
                ci = 0;
            } else if (a[ai] >= b[bi] && b[bi] <= c[ci]) {
                while (a[ai] >= b[bi]) {
                    ++bi;
                    if (bi == n) {
                        ++ai;
                        if (ai == n) return count > 1_000_000_000 ? -1 : count;
                        bi = 0;
                    }
                }
                while (b[bi] >= c[ci]) {
                    ++ci;
                    if (ci == n) {
                        ++bi;
                        ci = 0;
                    }
                }
            } else if (a[ai] < b[bi] && b[bi] >= c[ci]) {
                ++ci;
                if (ci == n) {
                    ++bi;
                    ci = 0;
                }
            }
        }
        return count > 1_000_000_000 ? -1 : count;
    }
}
class Main {
    public static void main(String[] args) {
        int[] a = {29, 50};
        int[] b = {61, 37};
        int[] c = {37, 70};
        System.out.println(Solution.getRoutes(a, b, c));
        int[] d = {5};
        int[] e = {5};
        int[] f = {5};
        System.out.println(Solution.getRoutes(d, e, f));
        int[] g = {29, 29};
        int[] h = {61, 61};
        int[] i = {70, 70};
        System.out.println(Solution.getRoutes(g, h, i));
    }
}