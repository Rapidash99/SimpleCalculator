public class Subtraction extends Operator {
    Subtraction(Character op) {
        super(op);
    }

    @Override
    public Double translate(Double first, Double second) {
        return first - second;
    }
}
