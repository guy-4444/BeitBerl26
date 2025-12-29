package utils;

import javax.swing.*;
import java.awt.*;

public class GraphView extends JPanel {

    private final double[] prices;

    public GraphView(double[] prices) {
        this.prices = prices;
        setPreferredSize(new Dimension(900, 350));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();

        int padLeft = 60, padRight = 20, padTop = 20, padBottom = 50;

        // Background
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, w, h);

        // Find min/max
        double min = prices[0], max = prices[0];
        for (double p : prices) {
            if (p < min) min = p;
            if (p > max) max = p;
        }
        double range = Math.max(1e-9, max - min); // avoid division by zero

        // Axes
        int x0 = padLeft;
        int y0 = h - padBottom;
        int x1 = w - padRight;
        int y1 = padTop;

        g2.setColor(Color.DARK_GRAY);
        g2.drawLine(x0, y0, x1, y0); // X axis
        g2.drawLine(x0, y0, x0, y1); // Y axis

        // Labels
        g2.drawString("Day", (x0 + x1) / 2, h - 15);
        g2.drawString("Price ($)", 10, (y0 + y1) / 2);

        // Convert price -> y pixel
        int n = prices.length;
        double dx = (double) (x1 - x0) / (n - 1);

        // Grid (optional)
        g2.setColor(new Color(0, 0, 0, 30));
        int gridLines = 5;
        for (int i = 1; i <= gridLines; i++) {
            int gy = y0 - (int) ((double) i / gridLines * (y0 - y1));
            g2.drawLine(x0, gy, x1, gy);
        }

        // Draw line
        g2.setColor(Color.BLUE);
        g2.setStroke(new BasicStroke(2f));

        int prevX = x0;
        int prevY = y0 - (int) ((prices[0] - min) / range * (y0 - y1));

        for (int i = 1; i < n; i++) {
            int x = x0 + (int) Math.round(i * dx);
            int y = y0 - (int) ((prices[i] - min) / range * (y0 - y1));
            g2.drawLine(prevX, prevY, x, y);
            prevX = x;
            prevY = y;
        }

        // Points
        g2.setColor(Color.RED);
        for (int i = 0; i < n; i++) {
            int x = x0 + (int) Math.round(i * dx);
            int y = y0 - (int) ((prices[i] - min) / range * (y0 - y1));
            g2.fillOval(x - 3, y - 3, 6, 6);
        }

        // Min/Max text
        g2.setColor(Color.DARK_GRAY);
        g2.drawString(String.format("min: %.2f", min), x0 + 5, y1 + 15);
        g2.drawString(String.format("max: %.2f", max), x0 + 120, y1 + 15);
    }
}
