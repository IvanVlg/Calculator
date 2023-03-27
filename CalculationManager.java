public class CalculationManager {

    public int addition(int a, int b) {
        return a+b;
    }

    public int subtraction(int a, int b) {
        return a-b;
    }

    public int multiplication(int a, int b) {
        return a*b;
    }

    public int division(int a, int b) {

        return a/b;
    }

    public void checkIntParams(int a, int b) {
        if (a > 10 || b > 10 || a < 0 || b < 0) {
            throw new CalculatorException("ERROR:You entered incorrect data.");
        }
    }

}
