package expression.simple;

import expression.utils.IntBinaryOperation;
import sheet.Cell;

import java.util.HashSet;
import java.util.Observable;
import java.util.Set;

public class NoValue implements MaybeValue {
    private static NoValue EMPTY;

    private NoValue() {}

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

    @Override
    public Set<Cell> references() {
        return new HashSet<>();
    }

    public static NoValue getEmpty() {
        if(EMPTY == null) EMPTY = new NoValue();
        return EMPTY;
    }

}
