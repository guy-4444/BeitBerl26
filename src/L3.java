import java.util.Random;

public class L3 {

    // For and While

    public static void start() {

        //forLoops();
        //nestedLoops();



    }

    private static void forLoops() {
        int i = 10;
        for (i = 0; i < 2; i++) {
            System.out.println(i);
        }

        System.out.println("- - - - - - - - -");

        for (; i < 4; i++) {
            System.out.println(i);
        }

        System.out.println("- - - - - - - - -");


        for (; i < 6;) {
            System.out.println(i);
            i++;
        }

        System.out.println("- - - - - - - - -");

        while (i < 8) {
            System.out.println(i);
            i++;
        }

        System.out.println("- - - - - - - - -");

        while (true) {
            System.out.println(i);
            i++;

            if (i >= 10) {
                break;
            }
        }

        System.out.println("i = " + i);
    }

    private static void nestedLoops() {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.print(i*j + " ");
            }
            System.out.println();
        }

        System.out.println("- - - - - - - - -");

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (i*j % 3 != 0) {
                    continue;
                }

                System.out.print(i * j + " ");
            }
            System.out.println();
        }


        System.out.println("- - - - - - - - -");

        Random random = new Random();
        while (true) {
            int x = random.nextInt(20);
            if (x % 2 == 0) {
                System.out.println(x);
                continue;
            }
            System.out.println(x + " not even");

            if (x == 19) {
                break;
            }
        }
    }
}




