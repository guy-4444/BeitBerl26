package algo;

public class BeeHivesSol {

    public void start() {
        System.out.println("- - Welcome to the Beehives - -\n");
        float map[][] = {
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0},
        };


        printHiveMap(map);
        float[][] prob = buildProbabilityMap(map);
        printProbMap(prob);
        float total = greedyBestPath(prob);
        System.out.printf("\nTotal risk sum: %.1f\n", total);
    }

    public float[][] buildProbabilityMap(float hive[][]) {
        int ROWS = hive.length;
        int COLS = hive[0].length;

        float[][] prob = new float[ROWS][COLS];

        // assume prob is initialized with zeros and matches hive dimensions
        for (int r = 0; r < ROWS; ++r) {
            for (int c = 0; c < COLS; ++c) {
                if (hive[r][c] != 0.0f) {
                    // hive cell
                    prob[r][c] = 1.0f;

                    for (int i = -2; i <= 2; i++) {
                        for (int j = -2; j <= 2; j++) {
                            int rr = r + i, cc = c + j;
                            if (rr < 0 || rr >= ROWS || cc < 0 || cc >= COLS) continue;

                            int d = Math.max(Math.abs(i), Math.abs(j));
                            if (d == 1) {
                                prob[rr][cc] += 0.5f;
                            } else if (d == 2) {
                                prob[rr][cc] += 0.2f;
                            }
                        }
                    }
                }
            }
        }

        // clamp to [0, 1]
        for (int r = 0; r < ROWS; ++r) {
            for (int c = 0; c < COLS; ++c) {
                prob[r][c] = min(prob[r][c], 1.0f);
            }
        }

        return prob;
    }

    /* greedy path (Right/Down) minimizing probability */
    public float greedyBestPath(float prob[][]) {
        int ROWS = prob.length;
        int COLS = prob[0].length;

        int r = 0, c = 0;
        float total = prob[0][0];

        System.out.printf("Greedy path (Right/Down), from (0,0) to (%d,%d):", ROWS - 1, COLS - 1);
                System.out.printf("(%d,%d)", r, c);

        while (r != ROWS - 1 || c != COLS - 1) {
            boolean canRight = (c + 1 < COLS);
            boolean canDown = (r + 1 < ROWS);

            if (canRight && canDown) {
                if (prob[r][c + 1] <= prob[r + 1][c]) {
                    c += 1;
                } else {
                    r += 1;
                }
            } else if (canRight) {
                c += 1;
            } else {
                r += 1;
            }

            total += prob[r][c];
            System.out.printf("(%d,%d)", r, c);
        }

        return total;
    }

    public void printHiveMap(float map[][]) {
        int ROWS = map.length;
        int COLS = map[0].length;
        System.out.printf("Hive map (%dx%d):\n", ROWS, COLS);
        for (int r = 0; r < ROWS; ++r) {
            for (int c = 0; c < COLS; ++c) {
                System.out.print(map[r][c] != 0.0f ? 'H' : '.');
                if (c < COLS - 1) {
                    System.out.print(' ');
                }
            }
            System.out.print('\n');
        }
    }

    public void printProbMap(float prob[][]) {
        int ROWS = prob.length;
        int COLS = prob[0].length;
        System.out.println("Probability map:\n");
        for (int r = 0; r < ROWS; ++r) {
            for (int c = 0; c < COLS; ++c) {
                System.out.printf("%4.1f", prob[r][c]);
                if (c < COLS - 1){
                    System.out.print(' ');
                }
            }
            System.out.print('\n');
        }
    }

    public float max(float a, float b) {
        if (a > b) return a;
        return b;
    }

    public float min(float a, float b) {
        if (a < b) return a;
        return b;
    }
}
