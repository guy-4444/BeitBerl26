public class L2 {

    // Array
    // for Loops
    // String

    public static void start() {
        int[] points = new int[]{23, 95, 99, 60, 99, 89, 98, 99, 78};
        int[] ps = new int[]{-1, -4, -9};

        double[] prices = new double[]{12.5, 3.0, 3.4, 6.7, 10, 1, 15.0};
//        printArray(points);
//        printArray(prices);
//        average(points);
//        System.out.println("Max: " + max(points));

        String[] games = new String[]{
                "clash_royal",
                "counter_strike ",
                "age_of_empires_4",
                "  fortnite",
                " rocket_league",
                "monkeys_vs_balloons_5",
                "league_of_legends",
        };

        beautify(games);
        printArray(games);


    }

    private static void beautify(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].trim();

            String[] splits = arr[i].split("_");
            for (int j = 0; j < splits.length; j++) {
                splits[j] = capitalize(splits[j]);
            }

            arr[i] = join('_', splits);
            //arr[i] = arr[i].replaceAll("_", " ");
            arr[i] = replaceAll(arr[i], '_', ' ');
        }
    }

    public static String replaceAll(String str, char from, char to) {
        String output = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == from) {
                output += to;
            } else {
                output += str.charAt(i);
            }
        }

        return output;
    }

    public static String join(char delimiter, String[] arr) {
        if (arr.length == 0) {
            return "";
        }

        String str = arr[0];
        for (int i = 1; i < arr.length; i++) {
            str += delimiter + arr[i];
        }

        return str;
    }

    public static String capitalize(String str) {
        if (str.length() == 0) {
            return "";
        }
        if (str.equals("vs")) {
            return str;
        }
        if (str.equals("of")) {
            return str;
        }


        //String first = String.valueOf(str.charAt(0));
        String first = "" + str.charAt(0);
        first = first.toUpperCase();
        String rest = str.substring(1);
        return first + rest;
    }

    public static int max(int[] arr) {
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    public static double average(int[] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        double result = sum / arr.length;
        return result;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void printArray(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void printArray(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
