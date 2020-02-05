public class Calculator {
    private String[] history = new String[5];

    public void printHistory() {
        System.out.println("Last 5 inputs from oldest to newest:");
        int i = 1;
        for (String input: history) {
            if (input != null) {
                System.out.println(i + ": " + input);
                i++;
            }
        }
        System.out.print("\n");
    }

    private void updateHistory(String last) {
        for (int i = 1; i < 5; i++) {
            if (history[i] != null)
                history[i - 1] = history[i];
        }
        history[4] = last;
    }


    public void exit() {
        System.out.println("Understandable\nHave a nice day");
    }

    public void help() {
        System.out.println("\nWrite: \n" +
                "\"h\" to view inputs history\n" +
                "\"e\" to exit\n" +
                "or operation to calculate\n");
    }

    public void calculate(String command) throws Exception {
        Number result = new Expression(command).parse();
        System.out.println(command + " = " + result);
        updateHistory(command);
    }

    public void error(Exception e) {
        System.out.println("\n" + e.getMessage());
    }
}
