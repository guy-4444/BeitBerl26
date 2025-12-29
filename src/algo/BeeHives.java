package algo;

public class BeeHives {

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

        /*
         * * complete here
         */

        return prob;
    }

    /* greedy path (Right/Down) minimizing probability */
    public float greedyBestPath(float prob[][]) {
        int ROWS = prob.length;
        int COLS = prob[0].length;

        float total = prob[0][0];

        /*
         * * complete here
         */

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
