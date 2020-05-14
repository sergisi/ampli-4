package expression.simple;

import expression.utils.IntBinaryOperation;

public class NoValue extends MaybeValue {
    public static NoValue EMPTY;

    @Override
    public boolean hasValue() {
        return false;
    }

    @Override
    public MaybeValue liftA2(MaybeValue val2, IntBinaryOperation op) {
        return getEmpty();
    }

    @Override
    public MaybeValue liftA2(SomeValue val1, IntBinaryOperation op) {
        return getEmpty();
    }

    @Override
    public MaybeValue evaluate() {
        return getEmpty();
    }

    public static NoValue getEmpty() {
        if(EMPTY == null) EMPTY = new NoValue();
        return EMPTY;
    }
}
