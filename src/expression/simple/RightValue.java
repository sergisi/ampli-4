package expression.simple;

import expression.utils.IntBinaryOperation;
import sheet.Cell;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class RightValue implements EitherValue {

    private final int value;

    public RightValue(int value) {
        this.value = value;
    }

    @Override
    public boolean hasValue() {
        return true;
    }

    @Override
    public EitherValue liftA2(EitherValue val2, IntBinaryOperation op) {
        return val2.liftA2(this, op);
    }

    @Override
    public EitherValue liftA2(RightValue val1, IntBinaryOperation op) {
        try {
            return new RightValue(op.operate(val1.getValue(), this.getValue()));
        } catch (Exception e) {
            return new LeftError(e.getMessage());
        }
    }

    @Override
    public EitherValue evaluate() {
        return this;
    }

    @Override
    public Set<Cell> references() {
        return new HashSet<>();
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RightValue someValue = (RightValue) o;
        return value == someValue.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "SomeValue{" +
                "value=" + value +
                '}';
    }


}
