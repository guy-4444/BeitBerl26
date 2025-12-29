package algo;

public class RiverCrossSol {

    public void start() {
        float[][] map1 ={
                {1, 1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {0, 1, 1, 1, 0, 0},
                {0, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1, 1},
                {0, 0, 0, 0, 0, 0},
        } ;
        float[][] map2 ={
                {1, 1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
        } ;
        float[][] map3 ={
                {1, 1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {0, 1, 1, 1, 0, 1},
                {0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 0},
        } ;


        int c1 = CanYouCrossTheRiver(map1);
        int c2 = CanYouCrossTheRiver(map2);
        int c3 = CanYouCrossTheRiver(map3);
        System.out.printf("%d %d %d\n", c1, c2, c3);

        int f1 = CanFitBoat(map1, 5);
        int f2 = CanFitBoat(map2, 5);
        int f3 = CanFitBoat(map3, 5);
        System.out.printf("%d %d %d\n", f1, f2, f3);
    }

    private int CanFitBoat(float[][] map, int size) {
        int ROWS = map.length;
        int COLS = map[0].length;

        for (int i = 0; i < ROWS; ++i) {
            for (int j = 0; j < COLS; ++j) {
                if (map[i][j] != 0) continue;

                // Check vertical only if (i,j) is the top of a vertical run
                if (i == 0 || map[i - 1][j] != 0) {
                    int n = 0;
                    while (i + n < ROWS && map[i + n][j] == 0) {
                        n++;
                    }
                    if (n >= size) return 1;
                }

                // Check horizontal only if (i,j) is the left of a horizontal run
                if (j == 0 || map[i][j - 1] != 0) {
                    int n = 0;
                    while (j + n < COLS && map[i][j + n] == 0) {
                        n++;
                    }
                    if (n >= size) return 1;
                }
            }
        }
        return 0;
    }

    private int CanYouCrossTheRiver(float[][] map) {
        int ROWS = map.length;
        int COLS = map[0].length;

        int i = 0, j = 0;
        while (true) {
            if (j == COLS - 1) {
                return 1;
            }

            if (i < ROWS - 1 && map[i + 1][j] == 1) {
                i++;
            } else if (j < COLS - 1 && map[i][j + 1] != 0) {
                j++;
            } else {
                return 0;
            }
        }
    }
}
