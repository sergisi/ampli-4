package expression.simple;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class LeftErrorTest {

    private static LeftError EMPTY;

    @BeforeAll
    static void setUp() {
        EMPTY = LeftError.getEmpty();
    }

    @Test
    void hasValue() {
        assertFalse(EMPTY.hasValue());
    }

    @Test
    void liftA2() {
        RightValue rightValue = new RightValue(3);
        assertEquals(EMPTY, EMPTY.liftA2(rightValue, Integer::sum));
        assertEquals(EMPTY, rightValue.liftA2(EMPTY, Integer::sum));
        assertEquals(EMPTY, EMPTY.liftA2(EMPTY, Integer::sum));
    }

    @Test
    void testReferences() {
        assertEquals(new HashSet<>(), EMPTY.references());
    }


    @Test
    void evaluate() {
        assertEquals(EMPTY, EMPTY.evaluate());
    }

    @Test
    void returnSame() {
        assertSame(EMPTY, LeftError.getEmpty());
    }


}