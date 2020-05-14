package expression.simple;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SomeValueTest {

    static SomeValue sm1, sm2;

    @BeforeAll
    static void setUp() {
        sm1 = new SomeValue(3);
        sm2 = new SomeValue(7);
    }

    @Test
    void hasValue() {
        assertTrue(sm1.hasValue());
    }

    @Test
    void liftA2() {
        // All cases with empty are already tested at NoValue
        assertEquals(new SomeValue(21), sm1.liftA2(sm2, (a, b) -> a * b));
    }

    @Test
    void evaluate() {
        assertEquals(new SomeValue(3), sm1.evaluate());
    }

}