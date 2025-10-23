import java.util.Scanner;

public class L1 {

    final static double VAT = 18.0;

    public static void start() {
        Scanner scanner = new Scanner(System.in);
//        double result1 = calculatePriceAfterTax(15000, "Yuri");
//        calculatePriceAfterTax(50000, "Yali");
//        calculatePriceAfterTax(20000, "Yuval");
//        calculatePriceAfterTax(30000, "Max");



//        System.out.println("enter first number:");
//        int a = scanner.nextInt();
//        System.out.println("enter second number:");
//        int b = scanner.nextInt();
//        int result = add(a, b);
//        System.out.println("Your result is: " + result);


        System.out.println("Enter product's price:");
        double price = scanner.nextDouble();
        System.out.println("Enter client's name:");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Enter client's last name:");
        String last = scanner.nextLine();

        String fullName = name + " " + last;
        calculatePriceAfterTax(price, fullName);

    }

    public static int add(int a, int b) {
        return a + b;
    }


    public static double calculatePriceAfterTax(double price, String name) {
        double priceAfter = price * (1.0 + VAT / 100);
        System.out.println(name + ", your price is: " + priceAfter);

        return priceAfter;
    }
}










