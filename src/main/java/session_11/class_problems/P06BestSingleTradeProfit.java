package session_11.class_problems;

/** Finds the best profit from one buy followed by one later sell. */
public class P06BestSingleTradeProfit {
    public static final class Trade {
        public final int profit;
        public final int buyDay;
        public final int sellDay;

        private Trade(int profit, int buyDay, int sellDay) {
            this.profit = profit;
            this.buyDay = buyDay;
            this.sellDay = sellDay;
        }
    }

    /** One-pass scan: O(n) time and O(1) extra space. */
    public static Trade bestTrade(int[] prices) {
        int minimumPrice = Integer.MAX_VALUE;
        int minimumDay = -1;
        Trade best = new Trade(0, -1, -1);
        for (int day = 0; day < prices.length; day++) {
            if (prices[day] < minimumPrice) {
                minimumPrice = prices[day];
                minimumDay = day;
            }
            int profit = prices[day] - minimumPrice;
            if (profit > best.profit) best = new Trade(profit, minimumDay, day);
        }
        return best;
    }

    /** Brute force: O(n^2) time and O(1) extra space. */
    public static int maxProfitBruteForce(int[] prices) {
        int best = 0;
        for (int buy = 0; buy < prices.length; buy++) {
            for (int sell = buy + 1; sell < prices.length; sell++) {
                best = Math.max(best, prices[sell] - prices[buy]);
            }
        }
        return best;
    }

    public static int maxProfit(int[] prices) {
        return bestTrade(prices).profit;
    }

    public static void main(String[] args) {
        Trade trade = bestTrade(new int[] {7, 1, 5, 3, 6, 4});
        System.out.printf("%d (buy at %d, sell at %d)%n", trade.profit, trade.buyDay, trade.sellDay);
        System.out.println(maxProfit(new int[] {7, 6, 4, 3, 1}));
    }
}
