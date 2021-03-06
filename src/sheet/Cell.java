package sheet;

import expression.Expression;
import expression.simple.EitherValue;
import expression.simple.LeftError;

import java.util.Objects;
import java.util.Observable;
import java.util.Observer;

public class Cell extends Observable implements Observer {

    private static int CELLNUMB = 0;
    private final int id;
    private Expression expression;
    private EitherValue lazyValue;

    public Cell() {
        this(LeftError.getEmpty());
    }

    public Cell(Expression expression) {
        this.expression = expression;
        this.lazyValue = this.expression.evaluate();
        id = CELLNUMB;
        CELLNUMB++;
        addObservers();
    }

    public EitherValue evaluate() {
        return lazyValue;
    }

    public void set(Expression exp) {
        deleteCurrentObservers();
        this.expression = exp;
        EitherValue val = this.expression.evaluate();
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
        return id == cell.id &&
                Objects.equals(expression, cell.expression) &&
                Objects.equals(lazyValue, cell.lazyValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, expression, lazyValue);
    }

    @Override
    public void update(Observable o, Object arg) {
        EitherValue val = expression.evaluate();
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
