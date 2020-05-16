package sheet;

import expression.simple.LeftError;
import expression.simple.Reference;
import expression.simple.RightValue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CellTest {

    Cell cell1;
    Cell cell2;
    Cell cell3;

    @BeforeEach
    void setUp() {
        cell1 = new Cell(new RightValue(7));
        cell2 = new Cell(new Reference(cell1));
        cell3 = new Cell(LeftError.getEmpty());
    }

    @Test
    void constructorTest(){
        Cell cell = new Cell();
        assertEquals(LeftError.getEmpty(), cell.evaluate());
    }

    @Test
    void cellEvaluationTest(){
        assertNotEquals(cell1.evaluate(), cell3.evaluate());
        assertEquals(cell1.evaluate(), cell2.evaluate());
    }

    @Test
    void cellSetExpressionTest() {
        assertNotEquals(cell1.evaluate(), cell3.evaluate());
        cell3.set(new RightValue(7));
        assertEquals(cell1.evaluate(), cell3.evaluate());
    }

    @Test
    void testLazyness() {
        assertEquals(new RightValue(7), cell2.evaluate());
        cell1.set(new RightValue(2));
        assertEquals(new RightValue(2), cell2.evaluate());
    }

}
