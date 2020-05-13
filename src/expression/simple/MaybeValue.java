package expression.simple;

import expression.Expression;
import expression.composable.Operation;

public abstract class MaybeValue extends Expression {

    public abstract boolean hasValue();

    /**
     * liftA2 is the equivalent of haskell idem. To use it in java,
     * is it programed as a double dispatch
     * @param val2
     * @param op
     * @return
     */
    public abstract MaybeValue liftA2(MaybeValue val2, Operation op);
    public abstract MaybeValue liftA2(SomeValue val1, Operation op);


}
