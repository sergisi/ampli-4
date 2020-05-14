package expression.simple;

import expression.utils.IntBinaryOperation;

import java.util.Objects;

public class SomeValue extends MaybeValue {

    private final int value;

    public SomeValue(int value) {
        this.value = value;
    }

    @Override
    public boolean hasValue() {
        return true;
    }

    @Override
    public MaybeValue liftA2(MaybeValue val2, IntBinaryOperation op) {
        return val2.liftA2(this, op);
    }

    @Override
    public MaybeValue liftA2(SomeValue val1, IntBinaryOperation op) {
        return new SomeValue(op.operate(val1.getValue(), this.getValue()));
    }

    @Override
    public MaybeValue evaluate() {
        return this;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SomeValue someValue = (SomeValue) o;
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
