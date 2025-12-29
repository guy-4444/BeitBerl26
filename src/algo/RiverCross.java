package algo;

public class RiverCross {

    public void start() {
        float map1[][] ={
                {1, 1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {0, 1, 1, 1, 0, 0},
                {0, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1, 1},
                {0, 0, 0, 0, 0, 0},
        } ;
        float map2[][] ={
                {1, 1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
        } ;
        float map3[][] ={
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



        return 0;
    }

    private int CanYouCrossTheRiver(float[][] map) {



        return 0;
    }
}
