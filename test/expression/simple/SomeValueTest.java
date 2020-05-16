package expression.simple;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class SomeValueTest {

    static RightValue sm1, sm2;

    @BeforeAll
    static void setUp() {
        sm1 = new RightValue(3);
        sm2 = new RightValue(7);
    }

    @Test
    void hasValue() {
        assertTrue(sm1.hasValue());
    }

    @Test
    void liftA2() {
        // All cases with empty are already tested at NoValue
        assertEquals(new RightValue(21), sm1.liftA2(sm2, (a, b) -> a * b));
    }


    @Test
    void testReferences() {
        assertEquals(new HashSet<>(), sm1.references());
    }

    @Test
    void evaluate() {
        assertEquals(new RightValue(3), sm1.evaluate());
    }

}