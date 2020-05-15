package expression.simple;

import org.junit.jupiter.api.Test;
import sheet.Cell;

import java.sql.Ref;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReferenceTest {

    Cell cell1;
    Cell cell2;

    @Test
    void evaluateNonEmptyCellTest(){
        cell1 = new Cell(new SomeValue(7));
        cell2 = new Cell(new Reference(cell1));

        assertEquals(cell1.evaluate(), cell2.evaluate());
    }

    @Test
    void evaluateEmptyCellTest(){
        cell1 = new Cell(NoValue.getEmpty());
        cell2 = new Cell(new Reference(cell1));
        assertEquals(cell1.evaluate(), cell2.evaluate());
    }

    @Test
    void testReferencesMethod() {
        Cell cella = new Cell();
        Cell cellb = new Cell(new Reference(cella));
        Reference ref = new Reference(cellb);

        HashSet<Cell> set = new HashSet<>();
        set.add(cella);
        set.add(cellb);
        assertEquals(set, ref.references());
    }






}
