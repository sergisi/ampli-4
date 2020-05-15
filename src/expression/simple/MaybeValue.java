package expression.simple;

import expression.Expression;
import expression.utils.IntBinaryOperation;

public interface MaybeValue extends Expression {

    boolean hasValue();

    MaybeValue liftA2(MaybeValue val2, IntBinaryOperation op);

    MaybeValue liftA2(SomeValue val1, IntBinaryOperation op);

}
