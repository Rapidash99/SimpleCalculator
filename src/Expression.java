public class Expression {
    private String expression;

    Expression(String expression) {
        this.expression = expression;
    }

    public Number parse() throws Exception {
        StringBuilder number = new StringBuilder(expression.length() / 2);
        boolean dot = false;
        boolean sign = false;
        boolean started = false;
        int i = 0;
        char symbol = expression.charAt(i);

        while (i < expression.length() && (!isOperator(symbol)) || !started) {
            if (symbol == ' ') {
                symbol = expression.charAt(i + 1);
                i++;
                continue;
            }
            if (isNotNumeral(symbol)) throw new Exception("Incorrect input. " +
                    "In first number neither operator nor sign nor sign nor number are given.");
            if (symbol == '.') {
                if (dot) throw new Exception("Incorrect input. Two dots in one number.");
                dot = true;
            }
            if (symbol == '+' || symbol == '-') {
                if (sign) throw new Exception("Incorrect input. Two signs in one number.");
                sign = true;
            }
            number.append(symbol);
            if (!started)
                started = true;
            symbol = expression.charAt(i + 1);
            i++;
        }
        Double first = Double.valueOf(number.toString());
        dot = false;
        sign = false;
        number = new StringBuilder(expression.length() - number.length() - 1);

        while (symbol == ' ') {
            symbol = expression.charAt(i + 1);
            i++;
        }

        Operator op = new Operator(symbol);
        i++;
        symbol = expression.charAt(i);

        while (i < expression.length()) {
            if (symbol == ' ') {
                if (i + 1 == expression.length())
                    break;
                symbol = expression.charAt(i + 1);
                i++;
                continue;
            }
            if (isNotNumeral(symbol)) throw new Exception("Incorrect input. " +
                    "In second number neither sign nor sign nor numeric are given.");
            if (symbol == '.') {
                if (dot) throw new Exception("Incorrect input. Two dots in a row.");
                dot = true;
            }
            if (symbol == '+' || symbol == '-') {
                if (sign) throw new Exception("Incorrect input. Two signs in one number.");
                sign = true;
            }
            number.append(symbol);
            if (i + 1 < expression.length())
                symbol = expression.charAt(i + 1);
            i++;
        }

        Double second = Double.valueOf(number.toString());
        if (second == 0.0 && op.op == '/')
            throw new Exception("main.Division by 0. Result is infinity.");
        Double result = op.translate(first, second);
        if (result % 1 == 0)
            return result.longValue();
        return result;
    }

    private boolean isOperator(char symbol) {
        return symbol == '/' || symbol == '*' || symbol == '+' || symbol == '-';
    }

    private boolean isNotNumeral(char symbol) {
        return symbol != '-' && symbol != '+' && symbol != '.' && (symbol < '0' || symbol > '9');
    }
}
