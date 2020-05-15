package sheet;

import expression.Expression;
import expression.simple.MaybeValue;
import expression.simple.NoValue;

import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

public class Cell extends Observable implements Observer {

    private Expression expression;
    private MaybeValue lazyValue;

    public Cell() {
        this(NoValue.getEmpty());
    }

    public Cell(Expression expression) {
        this.expression = expression;
        this.lazyValue = this.expression.evaluate();
        addObservers();
    }

    public MaybeValue evaluate() {
        return lazyValue;
    }

    public void set(Expression exp) {
        deleteCurrentObservers();
        this.expression = exp;
        MaybeValue val = this.expression.evaluate();
        addObservers();
        if (!val.equals(lazyValue)) {
            setChanged();
        }
        lazyValue = val;
        notifyObservers();
    }

    private void deleteCurrentObservers() {
        for (Cell cell : this.expression.references()) {
            cell.deleteObserver(this);
        }
    }

    private void addObservers() {
        for (Cell cell : this.expression.references()) {
            cell.addObserver(this);
        }
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
        MaybeValue val = expression.evaluate();
        if (!val.equals(lazyValue)) {
            setChanged();
        }
        lazyValue = val;
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Cell{" +
                "expression=" + expression +
                ", lazyValue=" + lazyValue +
                '}';
    }
}
