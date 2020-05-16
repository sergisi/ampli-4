package sheet;

import expression.simple.LeftError;
import expression.simple.RightValue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class SheetTest {

    Sheet sheet1;
    Sheet sheet2;


    @BeforeEach
    void setUp() {
        sheet1 = new Sheet(4);
        sheet2 = new Sheet(5);
    }

    @Test
    void getValidCell() {
        assertEquals(LeftError.getEmpty(), sheet1.get("a1").evaluate());
    }

    @Test
    void getInvalidCell() {
        String a = "The reference was outside the sheet! ";
        assertThrows(NoSuchElementException.class, () -> sheet1.get("a24").evaluate());
        assertThrows(NoSuchElementException.class, () -> sheet1.get("zzzzzz1").evaluate());
    }

    @Test
    void testPutValidCell() {
        sheet1.put("a1", new RightValue(5));
        assertEquals(new RightValue(5), sheet1.get("a1").evaluate());
    }

    @Test
    void testPutInvalidCell() {
        sheet1.put("a1", new RightValue(5));
        assertThrows(NoSuchElementException.class, () -> sheet1.put("a24", new RightValue(5)));
    }

    @Test
    void testClear() {
        sheet1.put("a1", new RightValue(5));
        assertEquals(new RightValue(5), sheet1.get("a1").evaluate());

        sheet1.clear();
        assertEquals(LeftError.getEmpty(), sheet1.get("a1").evaluate());
    }

    @Test
    void testValidateString() {
        assertTrue(sheet1.validateString("a1"));
        assertTrue(sheet1.validateString("b4"));
        assertTrue(sheet1.validateString("c2"));
        assertFalse(sheet1.validateString("aa1"));
        assertFalse(sheet1.validateString("a12"));
        assertFalse(sheet1.validateString("zz1"));
    }
}
