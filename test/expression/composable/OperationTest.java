package expression.composable;

import expression.simple.SomeValue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationTest {

    static SomeValue sm1, sm2;

    @BeforeAll
    static void setUp() {
        sm1 = new SomeValue(3);
        sm2 = new SomeValue(4);
    }

    @Test
    void evaluate() {
        assertEquals(new SomeValue(7), new Operation(sm1, sm2, Integer::sum).evaluate());
    }

    @Test
    void sum() {
        assertEquals(new SomeValue(7), Operation.sum(sm1, sm2).evaluate());
    }

    @Test
    void mult() {
        assertEquals(new SomeValue(12), Operation.mult(sm1, sm2).evaluate());
    }
}