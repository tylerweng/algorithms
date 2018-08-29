class Main {

    public static int[] roundPrices(float[] prices, int target) {
        int roundedTotal = 0;
        float diffTotal = 0f;
        float[] deltas = new float[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int roundedPrice = Math.round(prices[i]);
            roundedTotal += roundedPrice;
            float diff = roundedPrice - prices[i];
            deltas[i] = diff;
            diffTotal += diff;
        }
        System.out.println("diffTotal: " + diffTotal);
        System.out.println("roundedTotal: " + roundedTotal);
        for (int i = 0; i < deltas.length; i++) {
            System.out.println(deltas[i]);
        }
        return new int[0];
    }
    public static void main(String[] args) {
        float[] prices = new float[3];
        prices[0] = 0.3f;
        prices[1] = 2.8f;
        prices[2] = 4.9f;
        int target = 9;
        roundPrices(prices, target);
        System.out.println("Hello world!");
    }
}