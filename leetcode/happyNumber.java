boolean happyNumber(int n) {
    HashSet<Integer> seen = new HashSet<>();
    while (!seen.contains(n)) {
        seen.add(n);
        n = sumDigitsSquared(n);
        if (n == 1) return true;
    }
    return false;
}

int sumDigitsSquared(int n) {
    int sum = 0;
    while (n > 0) {
        sum += (n % 10) * (n % 10);
        n /= 10;
    }
    return sum;
}
