public class Division extends Operator {
    Division(Character op) {
        super(op);
    }

    @Override
    public Double translate(Double first, Double second) {
        return first / second;
    }
}
