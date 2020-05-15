package sheet;

import expression.simple.NoValue;
import expression.simple.SomeValue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CellTest {

    Cell cell1;
    Cell cell2;
    Cell cell3;

    @Test
    void constructorTest(){
        cell1 = new Cell();

        assertEquals(NoValue.getEmpty(), cell1.evaluate());
    }

    @Test
    void cellEvaluationTest(){
        cell1 = new Cell(new SomeValue(7));
        cell2 = new Cell(new SomeValue(7));
        cell3 = new Cell(NoValue.getEmpty());

        assertNotEquals(cell1.evaluate(), cell3.evaluate());
        assertEquals(cell1.evaluate(), cell2.evaluate());
    }

    @Test
    void cellSetExpressionTest() {
        cell1 = new Cell(new SomeValue(7));
        cell2 = new Cell(NoValue.getEmpty());

        assertNotEquals(cell1.evaluate(), cell2.evaluate());

        cell2.set(new SomeValue(7));


        assertEquals(cell1.evaluate(), cell2.evaluate());
    }
}
