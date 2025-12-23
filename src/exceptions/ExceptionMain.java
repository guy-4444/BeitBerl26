package exceptions;

import queue.Cat;

import java.util.ArrayList;
import java.util.Scanner;

public class ExceptionMain {
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        int count = 0;
        int sum = 0;

        while (true) {
            String input = scanner.nextLine();
            int num = 0;
            String connection;
            try {
                connection = "open";
                input = input.toLowerCase();
                num = Integer.valueOf(input);
                if (num == -1) {
                    break;
                }

                num = 100 / num;
                sum += num;
            } catch (NumberFormatException ex ) {
                ex.printStackTrace();
                System.out.println("please provide valid value");
            } catch (ArithmeticException ex) {
                ex.printStackTrace();
                System.out.println("cannot divide by 0");
            } finally {
                count++;
                connection = "close";
            }


        }

        System.out.println("sum= " + sum);
        System.out.println("count= " + count);

        ArrayList<Cat> a1 = new ArrayList<>();
        Cat[] a2 = new Cat[0];




    }
}
