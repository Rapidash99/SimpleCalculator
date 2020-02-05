public class Multiplication extends Operator {
    Multiplication(Character op) {
        super(op);
    }

    @Override
    public Double translate(Double first, Double second) {
        return first * second;
    }
}
