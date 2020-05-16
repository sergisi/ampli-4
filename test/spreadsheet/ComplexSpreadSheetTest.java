package spreadsheet;

import expression.simple.RightValue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComplexSpreadSheetTest {

    @BeforeEach
    public void setUp(){
        SpreadSheet.put("c1", SpreadSheet.mult("a1", "b1"));
        SpreadSheet.put("c2", SpreadSheet.mult("a2", "b2"));
        SpreadSheet.put("c3", SpreadSheet.plus("c1", "c2"));

        SpreadSheet.put("a1", 10);
        SpreadSheet.put("b1", 20);
        SpreadSheet.put("a2", 30);
        SpreadSheet.put("b2", 40);
    }

    @Test
    public void chained_expressions(){
        assertEquals(new RightValue(1400), SpreadSheet.get("c3"));
    }

    @Test
    public void chained_propagations(){
        SpreadSheet.put("a1","b1");
        assertEquals(new RightValue(1600), SpreadSheet.get("c3"));
    }

    @AfterEach
    public void tearDown(){
        SpreadSheet.clear();
    }

}
