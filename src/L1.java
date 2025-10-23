public class L1 {

    final static double VAT = 18.0;

    public static void start() {
        System.out.println("Hello World!");

        double result1 = calculatePriceAfterTax(15000, "Yuri");
        calculatePriceAfterTax(50000, "Yali");
        calculatePriceAfterTax(20000, "Yuval");
        calculatePriceAfterTax(30000, "Max");

        int r1 = add(4, 6);

        calculate((double)  4, 5);
    }

    public static int calculate() {

        return 5;
    }

    public static int calculate(int a) {

        return a + 5;
    }

    public static int calculate(double a) {

        return (int) (a + 5);
    }

    public static int calculate(int a, int b) {

        return a + b;
    }

    public static int calculate(double a, int b) {
        return 5;
    }

    public static int calculate(int b, double a) {
        return 5;
    }






    public static int mlt(int a, int b) {
        return a * b;
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
