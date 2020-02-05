import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            calculator.help();
            input = scanner.nextLine();
            if (input.equals("e")) {
                calculator.exit();
                break;
            }
            if (input.equals("h"))
                calculator.printHistory();
            else {
                try {
                    calculator.calculate(input);
                }
                catch (Exception e) {
                    calculator.error(e);
                    System.out.println("Write correct operation to calculate");
                }
            }
        }
    }
}
