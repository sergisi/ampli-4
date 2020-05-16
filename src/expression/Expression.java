package expression;

import expression.simple.EitherValue;
import sheet.Cell;

import java.util.Set;

public interface Expression {
    EitherValue evaluate();
    Set<Cell> references();
}
