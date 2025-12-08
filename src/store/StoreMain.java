package store;

import utils.MermaidClassDiagramGenerator;

public class StoreMain {

    public static void start() {
         diagram();
        Product[] products = generateProductsList();

        float avgPrice = calculateAveragePrice(products);
        System.out.println("Average price: " + avgPrice);

        float totalValue = calculateTotalInventoryValue(products);
        System.out.println("Total inventory value: " + totalValue);

        boolean ok1 = reduceStockByName(products, "Razer Home", 10);
        boolean ok2 = reduceStockByName(products, "Pixel 9 Pro", 2);
        boolean ok3 = reduceStockByName(products, "Nokia 3310", 10);
        System.out.println("Reduce stock result: " + ok1 + " " + ok2 + " " + ok3 + " ");

        totalValue = calculateTotalInventoryValue(products);
        System.out.println("Total inventory value: " + totalValue);

        Product mostExpensive = findMostExpensiveProduct(products);
        if (mostExpensive != null) {
            System.out.println("Most expensive: " + mostExpensive.getName() +
                    " (" + mostExpensive.getPrice() + ")");
        }

        System.out.println("\n░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n");
        printProductsSummary(products);
        
    }

    /**
     * Calculates the average price of all non-null products in the array.
     */
    public static float calculateAveragePrice(Product[] products) {
        if (products == null || products.length == 0) {
            return 0f;
        }

        float sum = 0f;
        int count = 0;

        for (Product p : products) {
            if (p == null) {
                continue; // skip empty slots
            }
            sum += p.getPrice();
            count++;
        }

        if (count == 0) {
            return 0f;
        }

        return sum / count;
    }

    /**
     * Calculates the total inventory value:
     * sum of (price * amount) for all products.
     */
    public static float calculateTotalInventoryValue(Product[] products) {
        if (products == null || products.length == 0) {
            return 0f;
        }

        float total = 0f;

        for (Product p : products) {
            if (p == null) {
                continue;
            }
            total += p.getPrice() * p.getAmount();
        }

        return total;
    }

    /**
     * Reduces the stock (amount) of a product by name.
     * Returns true if the update succeeded, false otherwise.
     *
     * Rules:
     *  - If product not found -> return false.
     *  - If quantityToReduce <= 0 -> return false.
     *  - If there is not enough stock -> return false.
     *  - Otherwise, update amount and return true.
     */
    public static boolean reduceStockByName(Product[] products, String productName, int quantityToReduce) {
        if (products == null || productName == null || quantityToReduce <= 0) {
            return false;
        }

        for (Product p : products) {
            if (p == null) {
                continue;
            }

            // Using equalsIgnoreCase to make name matching more flexible
            if (p.getName().equalsIgnoreCase(productName)) {
                int currentAmount = p.getAmount();

                if (currentAmount < quantityToReduce) {
                    // Not enough stock
                    return false;
                }

                // Option 1: using reduceAmount if you implemented it in Product
                // p.reduceAmount(quantityToReduce);

                // Option 2: direct setAmount using current value (safe for all implementations)
                p.setAmount(currentAmount - quantityToReduce);
                return true;
            }
        }

        // Product with this name was not found
        return false;
    }

    /**
     * Finds the most expensive product in the array.
     * Returns null if array is empty or only contains nulls.
     */
    public static Product findMostExpensiveProduct(Product[] products) {
        if (products == null || products.length == 0) {
            return null;
        }

        Product mostExpensive = null;

        for (Product p : products) {
            if (p == null) {
                continue;
            }

            if (mostExpensive == null || p.getPrice() > mostExpensive.getPrice()) {
                mostExpensive = p;
            }
        }

        return mostExpensive;
    }

    /**
     * Prints a simple summary of all products:
     * name, amount, price, and total value per product.
     */
    public static void printProductsSummary(Product[] products) {
        if (products == null || products.length == 0) {
            System.out.println("No products.");
            return;
        }

        // header
        System.out.printf("%-25s | %8s | %10s | %12s%n",
                "Name", "Amount", "Price", "Total value");

        // separator
        System.out.println("---------------------------------------------------------------");


        for (Product p : products) {
            if (p == null) {
                continue;
            }
            float value = p.getPrice() * p.getAmount();
            // row
            System.out.printf("%-25s | %8d | %10.2f | %12.2f%n",
                    p.getName(),
                    p.getAmount(),
                    p.getPrice(),
                    value);
        }
    }
    
    private static Product[] generateProductsList() {
        Product[] products = new Product[20];

        products[0]  = new GamingPc("Razer Home",          31, 9000.0f, 8);
        products[1]  = new GamingPc("Predator Orion",      20, 8500.0f, 12);
        products[2]  = new GamingPc("MSI Aegis",           15, 7800.0f, 10);

        products[3]  = new Laptop("Dell XPS 15",           20, 5200.0f, 16);
        products[4]  = new Laptop("MacBook Pro 14",        18, 7500.0f, 16);
        products[5]  = new Laptop("Lenovo ThinkPad X1",    22, 4800.0f, 12);
        products[6]  = new Laptop("Asus ROG Zephyrus",     11, 6900.0f, 32);

        products[7]  = new Phone("Nokia 3310",             30, 200.0f);
        products[8]  = new Phone("Classic Flip",           35, 249.0f);
        products[9]  = new Phone("Business Phone",         38, 395.0f);
        products[10] = new Phone("Emergency Mini",         50, 149.0f);

        products[11] = new Iphone("iPhone 16 Pro",         24, 4999.0f, 6);
        products[12] = new Iphone("iPhone 16",             20, 4599.0f, 6);
        products[13] = new Iphone("iPhone 16 Mini",        18, 3899.0f, 4);

        products[14] = new Pixel("Pixel 9 Pro",            11, 4000.0f, 8, 34);
        products[15] = new Pixel("Pixel 9",                16, 3599.0f, 8, 34);
        products[16] = new Pixel("Pixel 9A",               24, 2499.0f, 6, 33);

        products[17] = new Samsung("Galaxy S24 Ultra",     20, 4299.0f, 8, 34);
        products[18] = new Samsung("Galaxy S24",           23, 3899.0f, 8, 34);
        products[19] = new Samsung("Galaxy A55",           30, 1899.0f, 6, 33);

        return products;
    }

    private static void diagram() {
        String mermaid = MermaidClassDiagramGenerator.generateForClasses(
                Android.class,
                Computer.class,
                Electric.class,
                GamingPc.class,
                Iphone.class,
                Laptop.class,
                Phone.class,
                Pixel.class,
                Product.class,
                Samsung.class,
                SmartPhone.class
        );
        System.out.println(mermaid);
    }
}
