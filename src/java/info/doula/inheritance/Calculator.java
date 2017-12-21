package info.doula.inheritance;

public interface Calculator {

    static Calculator getInstance() {
        return new BasicCalculator();
    }

    int add(int first, int second);

    int subtract(int first, int second);

    int divide(int number, int divisor);

    int multiply(int first, int second);

    default int remainder(int number, int divisor) {
        return subtract(number, multiply(divisor, divide(number, divisor)));
    }
}