package sheet;

import expression.Expression;
import expression.simple.MaybeValue;
import expression.simple.NoValue;

import java.util.Objects;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

public class Cell extends Observable implements Observer{

    private Expression expression;
    private MaybeValue lazyValue;

    public Cell(){
        this(NoValue.getEmpty());
    }

    public Cell(Expression expression){
        this.expression = expression;
        this.lazyValue = this.expression.evaluate();
        // TODO: who observes.
    }

    public MaybeValue evaluate() {
        return lazyValue;
    }

    public void set(Expression exp){
        this.expression = exp;
        this.lazyValue = this.expression.evaluate();
        //TODO: who observes
        notifyObservers(this);
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

    @Override
    public void update(Observable o, Object arg) {
        lazyValue = expression.evaluate();
    }

    public Set<Cell> references() {
        return this.expression.references();
    }
}
