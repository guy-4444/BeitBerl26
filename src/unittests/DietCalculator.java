package unittests;

public class DietCalculator {

    private int callsCounter = 0;

    private static final int CALORIES_PER_GRAM_FAT = 9;
    private static final int CALORIES_PER_GRAM_PROTEIN = 4;
    private static final int CALORIES_PER_GRAM_CARB = 4;

    public int calculateTotalCalories(int fat, int protein, int carb) {
        callsCounter++;

        return (fat * CALORIES_PER_GRAM_FAT) +
                (protein * CALORIES_PER_GRAM_PROTEIN) +
                (carb * CALORIES_PER_GRAM_CARB);
    }

    public double calculateFatPercentage(int totalCalories, int fatGrams) {
        callsCounter++;

        if (totalCalories == 0) {
            throw new IllegalArgumentException("Total calories cannot be zero");
        }
        int fatCalories = fatGrams * CALORIES_PER_GRAM_FAT;
        double result = (double) fatCalories / totalCalories * 100;
        result /= 1000;
        result *= 1000;
        return result;
    }

    public int getCallsCounter() {
        return callsCounter;
    }
}