package unittests;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// args
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    @DisplayName("Test Divider By Two Positive Numbers (for example 4 and 6)")
    void div_shouldReturnDivide() {
        int result = calculator.howManyItemsCanIGet(10, 2);

        assertEquals(result, 5, "should return 5");
        assertEquals(1, calculator.getCallsCounter(), "should return 1");
    }
    @Test
    void div_shouldReturnDivide_priceZero() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            calculator.howManyItemsCanIGet(10, 0);
        }, "Should throw ArithmeticException when total calories is zero");

        // Optional: specific check on exception message
        assertEquals("/ by zero", exception.getMessage());
        assertEquals(1, calculator.getCallsCounter(), "should return 1");
    }

    @Test
    void div_shouldReturnDivide_givenTwoNumbers() {
        int result = calculator.div(10, 3);

        assertEquals(result, 3, "should return 3");
        assertEquals(1, calculator.getCallsCounter(), "should return 1");
    }

    @Test
    void add_shouldReturnSum_givenTwoNumbers() {
        int result = calculator.add(1, 3);

        assertEquals(result, 4, "should return 4");
        int callsCounter = calculator.getCallsCounter();
        assertEquals(1, calculator.getCallsCounter(), "should return 1");
    }

    @Test
    void add_shouldReturnSum_givenOneNegativeNumber() {
        int result = calculator.add(1, -3);

        assertEquals(result, -2, "should return -2");
        int callsCounter = calculator.getCallsCounter();
        assertEquals(1, calculator.getCallsCounter(), "should return 1");
    }
}
