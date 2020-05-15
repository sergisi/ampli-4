package expression;

import expression.simple.MaybeValue;
import sheet.Cell;

import java.util.Set;

public interface Expression {
    MaybeValue evaluate();
    Set<Cell> references();
}
