package expression.simple;

import expression.composable.Operation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import sheet.Cell;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReferenceTest {

    Cell cell1;
    Cell cell2;

    @Test
    void evaluateNonEmptyCellTest(){
        Cell  cell1 = new Cell(new SomeValue(7));
        Cell cell3 = new Cell(new Reference(cell1));

        assertEquals(cell1.evaluate(), cell3.evaluate());
    }

    @Test
    void evaluateEmptyCellTest(){
        Cell  cell1 = new Cell(NoValue.getEmpty());
        Cell cell3 = new Cell(new Reference(cell1));

        assertEquals(cell1.evaluate(), cell3.evaluate());
    }






}
