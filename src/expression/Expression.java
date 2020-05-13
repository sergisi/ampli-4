package expression;

import expression.simple.MaybeValue;

public abstract class Expression {
    public abstract MaybeValue evaluate();
}
