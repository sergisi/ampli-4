package expression.composable;

import expression.simple.EitherValue;
import expression.simple.LeftError;
import expression.simple.Reference;
import expression.simple.RightValue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import sheet.Cell;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class OperationTest {

    static RightValue sm1, sm2;

    @BeforeAll
    static void setUp() {
        sm1 = new RightValue(3);
        sm2 = new RightValue(4);
    }

    @Test
    void evaluate() {
        assertEquals(new RightValue(7), new Operation(sm1, sm2, Integer::sum).evaluate());
    }

    @Test
    void sum() {
        assertEquals(new RightValue(7), Operation.sum(sm1, sm2).evaluate());
    }

    @Test
    void mult() {
        assertEquals(new RightValue(12), Operation.mult(sm1, sm2).evaluate());
    }

    @Test
    void testReferences() {
        Cell cella = new Cell();
        Cell cellb = new Cell();
        Operation op = Operation.sum(new Reference(cella), new Reference(cellb));
        HashSet<Cell> set = new HashSet<>();
        set.add(cella);
        set.add(cellb);
        assertEquals(set, op.references());
    }

    @Test
    void testEitherValue() {
        Operation op = new Operation(new RightValue(3), new RightValue(0), (a, b) -> a / b);
        EitherValue value = op.evaluate();
        assertFalse(value.hasValue());
        LeftError le = (LeftError) value;
        assertEquals("/ by zero", le.getError());
    }
}