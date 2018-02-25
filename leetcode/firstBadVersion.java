/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    private int helper(Long left, Long right) {

        if (left > right) return -1;
        Long cur = (right + left) / 2;
        System.out.println("cur: " + cur);

        boolean badCur = isBadVersion(cur.intValue());
        boolean badPrev = cur > 1 ? isBadVersion(cur.intValue() - 1) : false;
        if (!badPrev && badCur) {
            return cur.intValue();
        } else if (!badCur) {
            return helper(cur + 1, right);
        } else {
            return helper(left, cur - 1);
        }
    }
    public int firstBadVersion(int n) {
        return helper(1L, Long.valueOf(n));
    }
}

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = start + ((end - start) / 2);
            if (!isBadVersion(mid)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}