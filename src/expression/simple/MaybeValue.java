package expression.simple;

import expression.Expression;
import expression.utils.IntBinaryOperation;

public abstract class MaybeValue extends Expression {

    public abstract boolean hasValue();

    public abstract MaybeValue liftA2(MaybeValue val2, IntBinaryOperation op);
    public abstract MaybeValue liftA2(SomeValue val1, IntBinaryOperation op);

}
