package expression.simple;

import expression.utils.IntBinaryOperation;
import sheet.Cell;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class LeftError implements EitherValue {

    private final String error;
    private static LeftError EMPTY;

    public LeftError(String error) {
        this.error = error;
    }

    @Override
    public boolean hasValue() {
        return false;
    }

    public String getError() {
        return error;
    }

    @Override
    public EitherValue liftA2(EitherValue val2, IntBinaryOperation op) {
        return this;
    }

    @Override
    public EitherValue liftA2(RightValue val1, IntBinaryOperation op) {
        return this;
    }

    @Override
    public EitherValue evaluate() {
        return this;
    }

    @Override
    public Set<Cell> references() {
        return new HashSet<>();
    }


    public static LeftError getEmpty() {
        if (EMPTY == null) {
            EMPTY = new LeftError("Empty Expression");
        }
        return EMPTY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LeftError leftError = (LeftError) o;
        return Objects.equals(error, leftError.error);
    }

    @Override
    public int hashCode() {
        return Objects.hash(error);
    }
}
