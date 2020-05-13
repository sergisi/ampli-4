package expression.composable;

import expression.Expression;

public abstract class Operation {

    private final Expression left, right;

    protected Operation(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }


}
