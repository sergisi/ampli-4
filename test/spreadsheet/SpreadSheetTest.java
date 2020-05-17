package spreadsheet;

import expression.simple.RightValue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SpreadSheetTest {

    @BeforeEach
    void setUp() {
        SpreadSheet.put("a3", SpreadSheet.mult("a1", "a2"));
    }

    @Test
    public void cell_has_no_value_if_depends_on_empty_cells() {
        assertFalse(SpreadSheet.get("a3").hasValue());
    }

    @Test
    public void recalculation_works() {
        SpreadSheet.put("a1", 42);
        SpreadSheet.put("a2", 20);
        assertEquals(new RightValue(840), SpreadSheet.get("a3"));
        SpreadSheet.put("a3", SpreadSheet.plus("a1", "a2"));
        assertEquals(new RightValue(62), SpreadSheet.get("a3"));
    }

    @Test
    public void plus1() {
        SpreadSheet.put("a2", 3);
        SpreadSheet.put("a1", SpreadSheet.plus(
                SpreadSheet.plus(SpreadSheet.plus(2, 3), "a2"),
                SpreadSheet.plus(3, SpreadSheet.plus("a2", 4))));
        assertEquals(new RightValue(18), SpreadSheet.get("a1"));
    }

    @Test
    public void plus2() {
        SpreadSheet.put("a4", "a3");
        SpreadSheet.put("a1", SpreadSheet.plus(
                SpreadSheet.plus("a2", SpreadSheet.plus(3, "a2")),
                3
        ));
        SpreadSheet.put("a2", 5);
        assertEquals(new RightValue(80), SpreadSheet.get("a4"));
    }

    @Test
    public void mult1() {
        SpreadSheet.put("a2", 3);
        SpreadSheet.put("a1", SpreadSheet.mult(
                SpreadSheet.mult(SpreadSheet.mult(2, 3), "a2"),
                SpreadSheet.mult(3, SpreadSheet.mult("a2", 4))));
        assertEquals(new RightValue(648), SpreadSheet.get("a1"));
    }

    @Test
    public void mult2() {
        SpreadSheet.put("a4", "a3");
        SpreadSheet.put("a1", SpreadSheet.mult(
                SpreadSheet.mult("a2", SpreadSheet.mult(3, "a2")),
                3
        ));
        SpreadSheet.put("a2", 5);
        assertEquals(new RightValue(1125), SpreadSheet.get("a4"));
    }

    @AfterEach
    public void clearSheet() {
        SpreadSheet.clear();
    }

}
