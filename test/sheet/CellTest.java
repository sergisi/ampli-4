package sheet;

import expression.simple.NoValue;
import expression.simple.Reference;
import expression.simple.SomeValue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CellTest {

    Cell cell1;
    Cell cell2;
    Cell cell3;

    @BeforeEach
    void setUp() {
        cell1 = new Cell(new SomeValue(7));
        cell2 = new Cell(new Reference(cell1));
        cell3 = new Cell(NoValue.getEmpty());
    }

    @Test
    void constructorTest(){
        Cell cell = new Cell();
        assertEquals(NoValue.getEmpty(), cell.evaluate());
    }

    @Test
    void cellEvaluationTest(){
        assertNotEquals(cell1.evaluate(), cell3.evaluate());
        assertEquals(cell1.evaluate(), cell2.evaluate());
    }

    @Test
    void cellSetExpressionTest() {
        assertNotEquals(cell1.evaluate(), cell3.evaluate());
        cell3.set(new SomeValue(7));
        assertEquals(cell1.evaluate(), cell3.evaluate());
    }

    @Test
    void cellReferences() {
        assertEquals(Set.of(cell1), cell2.references());
    }
}
