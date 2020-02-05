public class Addition extends Operator {
    Addition(Character op) {
        super(op);
    }

    @Override
    public Double translate(Double first, Double second) {
        return first + second;
    }
}
