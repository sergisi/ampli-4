package expression.simple;

import expression.Expression;
import sheet.Cell;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Reference implements Expression {

    private final Cell ref;

    public Reference(Cell ref) {
        this.ref = ref;
    }

    @Override
    public EitherValue evaluate() {
        return ref.evaluate();
    }

    @Override
    public Set<Cell> references() {
        return new HashSet<>() {{
            add(ref);
        }};
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
