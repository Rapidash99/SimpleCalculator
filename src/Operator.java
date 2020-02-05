public class Operator {
    Character op;

    Operator(Character op) {
        this.op = op;
    }

    public Double translate(Double first, Double second) throws Exception {
        switch (op) {
            case '+':
                return new Addition(op).translate(first, second);
            case '-':
                return new Subtraction(op).translate(first, second);
            case '*':
                return new Multiplication(op).translate(first, second);
            case '/':
                return new Division(op).translate(first, second);
        }
        throw new Exception("Incorrect operator given");
    }
}
