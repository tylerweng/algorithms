class Solution {
    public static int stringToInt(String s) {
        // assume s is made up only of whitespace, 0-9 and negative sign
        if (s == null) throw new IllegalArgumentException("String can not be null");
        char[] chars = s.toCharArray();
        int n = chars.length;
        if (n == 0) throw new IllegalArgumentException("String can not be empty");
        int res = 0;
        boolean beginProd = false;
        boolean isNeg = false;
        for (char c : chars) {
            if (!Character.isDigit(c) && beginProd) {
                throw new IllegalArgumentException("Invalid int");
            } else if (c == '-' && !beginProd) {
                if (isNeg) throw new IllegalArgumentException("String can not have multiple neg signs");
                isNeg = true;
            } else if (Character.isDigit(c) && c != '0' || beginProd) {
                beginProd = true;
                res = res * 10 + Character.getNumericValue(c);
            }
        }
        return isNeg ? -res : res;
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println(Solution.stringToInt("1001"));
    }
}