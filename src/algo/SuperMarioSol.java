package algo;

public class SuperMarioSol {

    public void start() {
        float[][] map1 ={
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0},
        } ;
        float[][] map2 = new float[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0},
        };
        float[][] map3 = new float[][]{
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0},
        };


        int c1 = canWin(map1, 3);
        int c2 = canWin(map2, 3);
        int c3 = canWin(map3, 3);
        System.out.printf("%d %d %d\n", c1, c2, c3);
    }

    private int canWin(float[][] map, int jump) {
        for (int j = 0; j < map[0].length - 1; j++) {
            int currentHeight = getHeight(map, j);
            int nextHeight = getHeight(map, j+1);
            if (Math.abs(currentHeight - nextHeight) > jump) {
                return 0;
            }
        }
        return 1;
    }

    private int getHeight(float[][] map, int j) {
        System.out.println("" + j);
        int height = 0;
        for (int i = map.length - 1; i >= 0; i--) {
            System.out.println(i + "," + j);
            if (map[i][j] == 0) {
                break;
            }
            height++;
        }
        return height;
    }

}
