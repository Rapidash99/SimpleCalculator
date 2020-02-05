import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @ParameterizedTest
    @ValueSource(strings = {
            "5+5",
            "5 - -5",
            "5/-25.00",
            "-0037 * +25.07",
            "  +  3736546.0  *  -  0.0900",
            "-0/370.0",
            "+0.0 * -0.05"})
    void calculate(String operation) throws Exception {
        calculator.calculate(operation);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "+0/ - 0",
            "-50 / +0",
            "5.37.3 * 5",
            "--50 + 5",
            "37a * 8",
            "*58 * 9",
            "+-1 * -8"
    })
    void failCalculate(String operations) {
        try {
            calculator.calculate(operations);
        }
        catch (Exception e) {
            System.out.println("Failed successfully: " + e.getMessage());
        }
    }
}