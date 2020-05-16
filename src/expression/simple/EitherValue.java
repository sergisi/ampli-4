package expression.simple;

import expression.Expression;
import expression.utils.IntBinaryOperation;

public interface EitherValue extends Expression {

    boolean hasValue();

    EitherValue liftA2(EitherValue val2, IntBinaryOperation op);

    EitherValue liftA2(RightValue val1, IntBinaryOperation op);

}
