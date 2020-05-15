package sheet;

import expression.Expression;
import expression.simple.MaybeValue;
import expression.simple.NoValue;

import java.util.Objects;

public class Cell extends Expression {

    Expression expression;

    public Cell(){
        this.expression = new NoValue();
    }

    public Cell(Expression expression){
        this.expression = expression;
    }

    @Override
    public MaybeValue evaluate() {
        return expression.evaluate();
    }

    public void set(Expression exp){
        this.expression = exp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return Objects.equals(expression, cell.expression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expression);
    }
}
