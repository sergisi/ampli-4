package expression.simple;

import org.junit.jupiter.api.Test;
import sheet.Cell;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReferenceTest {

    Cell cell1;
    Cell cell2;

    @Test
    void evaluateNonEmptyCellTest(){
        cell1 = new Cell(new RightValue(7));
        cell2 = new Cell(new Reference(cell1));

        assertEquals(cell1.evaluate(), cell2.evaluate());
    }

    @Test
    void evaluateEmptyCellTest(){
        cell1 = new Cell(LeftError.getEmpty());
        cell2 = new Cell(new Reference(cell1));
        assertEquals(cell1.evaluate(), cell2.evaluate());
    }

    @Test
    void testReferencesMethod() {
        Cell cella = new Cell();
        Cell cellb = new Cell(new Reference(cella));
        Reference ref = new Reference(cellb);
        assertEquals(Set.of(cellb), ref.references());
    }






}
