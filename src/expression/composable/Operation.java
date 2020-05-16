package expression.composable;

import expression.Expression;
import expression.simple.EitherValue;
import expression.simple.LeftError;
import expression.utils.IntBinaryOperation;
import sheet.Cell;

import java.util.Objects;
import java.util.Set;

public class Operation implements Expression {

    private final Expression left, right;
    private final IntBinaryOperation operator;

    protected Operation(Expression left, Expression right, IntBinaryOperation operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    public EitherValue evaluate() {
        try {
            return left.evaluate().liftA2(right.evaluate(), this.operator);
        } catch (Exception e) {
            return new LeftError(e.getMessage());
        }
    }

    @Override
    public Set<Cell> references() {
        Set<Cell> refs = left.references();
        refs.addAll(right.references());
        return refs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return left.equals(operation.left) &&
                right.equals(operation.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    public static Operation sum(Expression left, Expression right) {
        return new Operation(left, right, Integer::sum);
    }

    public static Operation mult(Expression left, Expression right) {
        return new Operation(left, right, (a, b) -> a * b);
    }

}
