import java.util.*;

public class Main {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        int mIdx = (n1 + n2) / 2;
        if ((n1 + n2) % 2 == 0) {
            int firstVal = 0;
            while (i + j <= mIdx + 1) {
                if (i + j == mIdx + 1) {
                    return (float) (firstVal + Math.min(nums1[i], nums2[j]) / 2);
                }
                if (i + j == mIdx) {
                    firstVal = Math.min(nums1[i], nums2[j]);
                }
                if (nums1[i] < nums2[j] && i + 1 < nums1.length) {
                    i++;
                } else {
                    j++;
                }
            }
        } else {
            while (i + j <= mIdx) {
                if (i + j == mIdx) {
                    return Math.min(nums1[i], nums2[j]);
                }
                if (nums1[i] < nums2[j] && i + 1 < nums1.length) {
                    i++;
                } else {
                    j++;
                }
            }
        }
    }
    public static void main(String[] args) {

    }
}