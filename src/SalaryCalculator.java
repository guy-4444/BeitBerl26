import java.util.Scanner;

public class SalaryCalculator {
    static Scanner scanner = new Scanner(System.in);
    final static double SOCIAL = 0.06;

    public static void startMain() {

    }

    public static void Q1() {

        // social security payment - receive gross salary and age

        // input - gross salary(double), int age
        //

        System.out.println("Enter gross salary:");
        double gross = scanner.nextDouble();
        System.out.println("Enter age:");
        int age = scanner.nextInt();

        double result = socialSecurity(gross, age);
        System.out.println("result:" + result);
    }

    public static void Q2() {

    }

    public static void Q3() {

    }

    public static double socialSecurity(double gross, int age) {
        if (age >= 18) {
            return gross * SOCIAL;
        } else {
            return 0.0;
        }
    }
}






