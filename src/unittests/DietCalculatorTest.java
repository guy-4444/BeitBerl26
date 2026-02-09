package unittests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class DietCalculatorTest {


    @Disabled
    @Nested
    class SimpleDietCalculatorTest {
        DietCalculator dietCalculator;

        @BeforeEach
        void init() {
            dietCalculator = new DietCalculator();
        }

        @AfterEach
        void close() {
            dietCalculator = null;
        }

        @Test
        void simple10grams() {
            int result = dietCalculator.calculateTotalCalories(10, 10, 10);
            assertEquals(170, result, "should return 170 for 10 grams each");
        }

        @RepeatedTest(3)
        void simple20grams() {
            int result = dietCalculator.calculateTotalCalories(20, 20, 20);
            assertEquals(340, result, "should return 340 for 20 grams each");
        }

        @ParameterizedTest(name = "{index} => fat={0}, protein={1}, carb={2}, expected={3}")
        @CsvSource({
                "10, 20, 30, 290",
                "0, 0, 0, 0",
                "0, 0, 2, 4",
                "5, 5, 5, 85"
        })
        void calculateTotalCalories_parameterized(int fat, int protein, int carb, int expectedCalories) {
            int result = dietCalculator.calculateTotalCalories(fat, protein, carb);
            assertEquals(expectedCalories, result);
        }
    }

    @Test
    @DisplayName("Calculate Fat Percentage Correctly")
    void calculateFatPercentage_correctlyCalculatesPercentage() {
        DietCalculator dietCalculator = new DietCalculator();

        // 1. Arrange
        int totalCalories = 1100;
        int fatGrams = 22;
        double expectedPercentage = 18.0;
        double actualPercentage = dietCalculator.calculateFatPercentage(totalCalories, fatGrams);
        assertEquals(expectedPercentage, actualPercentage, 0.001, "Fat percentage calculation should be correct");
    }

    @Test
    @DisplayName("Performance Test (Timeout)")
    void executionShouldCompleteWithinTimeout() {
        DietCalculator dietCalculator = new DietCalculator();

        assertTimeout(Duration.ofMillis(100), () -> {
            dietCalculator.calculateTotalCalories(10, 10, 10);
            // Simulate some work if needed
//             Thread.sleep(1000);
        }, "Calculation should take less than 100ms");
    }

    @Test
    void forceTestFailing() {
        fail("i want to fail");
    }
}














