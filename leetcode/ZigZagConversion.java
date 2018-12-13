class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        StringBuilder[] strings = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) strings[i] = new StringBuilder();
        int rowIdx = 0;
        boolean increasingRowIdx = false;
        for (int i = 0; i < s.length(); i++) {
            strings[rowIdx].append(s.charAt(i));
            if (rowIdx % (numRows - 1) == 0) increasingRowIdx = !increasingRowIdx;
            if (increasingRowIdx) {
                rowIdx++;
            } else {
                rowIdx--;
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < numRows; i++) res.append(strings[i]);
        return res.toString();
    }
}