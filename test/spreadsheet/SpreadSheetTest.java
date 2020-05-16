package spreadsheet;

import expression.simple.Reference;
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
    public void cell_has_no_value_if_depends_on_empty_cells(){
        assertFalse(SpreadSheet.get("a3").hasValue());
    }

    @Test
    public void recalculation_works(){
        SpreadSheet.put("a1", 42);
        SpreadSheet.put("a2", 20);
        assertEquals(new RightValue(840), SpreadSheet.get("a3"));
    }

    @AfterEach
    public void clearSheet(){
        SpreadSheet.clear();
    }

}
