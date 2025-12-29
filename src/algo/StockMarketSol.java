package algo;

import utils.GraphView;

import javax.swing.*;

public class StockMarketSol {

    public void start() {
        double[] prices = new double[] {
                1.00, 1.24, 1.45, 1.76, 2.13, 2.51, 2.77, 2.55, 1.75, 1.37,
                1.30, 1.35, 1.55, 1.86, 2.21, 2.60, 2.96, 2.14, 1.33, 1.19,
                1.44, 1.40, 1.70, 1.69, 2.05, 2.20, 1.34, 0.95, 0.97, 1.00
        };

        double[] actions = {
                +100, 0, 0, 0, 10, 10, 0, -30, 0, -20,
                0, 10, 0, 0, 20, 20, 0, -10, -20, 20,
                10, 0, +20, 0, 0, -20, 0, 0, 0, -100

        };

        int c1 = profit(prices, actions);
        int c2 = maxPossibleProfit(prices);
        System.out.printf("%d %d\n", c1, c2);

        //drawGraph(prices);
    }

    private int profit(double[] prices, double[] actions) {
        double balance = 0.0;
        double stocks = 0;

        for (int i = 0; i < prices.length; i++) {
            balance += actions[i] * prices[i];
            stocks += actions[i];
        }

        System.out.println("balance: " + balance);
        System.out.println("stocks: " + stocks);

        return 0;
    }

    private int maxPossibleProfit(double[] prices) {
        double totalProfit = 0.0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                totalProfit += (prices[i] - prices[i - 1]);
            }
        }
        return (int) totalProfit;
    }

    private void drawGraph(double[] arr) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Stock Price (30 Days)");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new GraphView(arr));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
