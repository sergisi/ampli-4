package expression.simple;

import expression.Expression;
import sheet.Cell;

import java.util.HashSet;
import java.util.Objects;
import java.util.Observable;
import java.util.Set;

public class Reference implements Expression {

    Cell ref;

    public Reference(Cell ref) {
        this.ref = ref;
    }

    @Override
    public MaybeValue evaluate() {
        return ref.evaluate();
    }

    @Override
    public Set<Cell> references() {
        Set<Cell> refs = ref.references();
        refs.add(ref);
        return refs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reference reference = (Reference) o;
        return Objects.equals(ref, reference.ref);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ref);
    }

}
