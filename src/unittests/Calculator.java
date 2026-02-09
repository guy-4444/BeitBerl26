package unittests;

public class Calculator {

    private int callsCounter = 0;

    public int add(int a, int b) {
        callsCounter++;
        return a + b;
    }

    public int div(int a, int b) {
        callsCounter++;
        return a / b;
    }

    public int howManyItemsCanIGet(int money, int price) {
        callsCounter++;
        return div(money, price);
    }

    public int getCallsCounter() {
        return callsCounter;
    }
}
