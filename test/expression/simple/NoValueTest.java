package expression.simple;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NoValueTest {

    static NoValue EMPTY;

    @BeforeAll
    static void setUp() {
        EMPTY = NoValue.getEmpty();
    }

    @Test
    void hasValue() {
        assertFalse(EMPTY.hasValue());
    }

    @Test
    void liftA2() {
        SomeValue sv = new SomeValue(3);
        assertEquals(EMPTY, EMPTY.liftA2(sv, Integer::sum));
        assertEquals(EMPTY, sv.liftA2(EMPTY, Integer::sum));
        assertEquals(EMPTY, EMPTY.liftA2(EMPTY, Integer::sum));
    }



    @Test
    void evaluate() {
        assertEquals(EMPTY, EMPTY.evaluate());
    }

    @Test
    void getEmpty() {
        assertSame(EMPTY, NoValue.getEmpty());
    }
}