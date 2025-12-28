package exceptions;

import queue.Cat;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class ExceptionGameMain {
    private Scanner scanner = new Scanner(System.in);

    public void start() {

        int pivot = ThreadLocalRandom.current().nextInt(1, 100 + 1);

        try {
            getRandomName();
        } catch (GameException e) {
            System.out.println(e.getMessage());
        }

        while (true) {
            int num = 0;
            try {
                num = getInput();
            } catch (SmallNumberException e) {
                System.out.println("invalid small input: " + e.getMessage());
                continue;
            } catch (BigNumberException e) {
                System.out.println("invalid big input: " + e.getMessage());
                continue;
            }

            if (num == pivot) {
                System.out.println("Success!");
                break;
            }

            if (num < pivot) {
                System.out.println("try bigger");
            } else {
                System.out.println("try smaller");
            }
        }



    }

    private int getInput() throws SmallNumberException, BigNumberException {
        int num = scanner.nextInt();

        if (num <= 0) {
            throw new SmallNumberException("Number smaller than 0");
        } else if (num > 100) {
            throw new BigNumberException("Number bigger than 100");
        }

        return num;
    }

    private String getRandomName() throws GameException {
        throw new GameException();
    }
}
