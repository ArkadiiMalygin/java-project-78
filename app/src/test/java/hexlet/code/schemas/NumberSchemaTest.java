package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberSchemaTest {
    @Test
    public void testIsValidNull() {
        Integer testNumber = null;
        var v = new Validator();
        var schema = v.number();
        assertEquals(schema.isValid(testNumber), true);
    }

    @Test
    public void testIsValidNullFalse() {
        Integer testNumber = null;
        var v = new Validator();
        var schema = v.number().required();
        assertEquals(schema.isValid(testNumber), false);
    }

    @Test
    public void testIsValid() {
        Integer testNumber = 65;
        var v = new Validator();
        var schema = v.number();
        assertEquals(schema.isValid(testNumber), true);
    }

    @Test
    public void testIsValidPosFalse() {
        Integer testNumber = 0;
        var v = new Validator();
        var schema = v.number().positive();
        assertEquals(schema.isValid(testNumber), false);
    }

    @Test
    public void testIsValidPosTrue() {
        Integer testNumber = 34;
        var v = new Validator();
        var schema = v.number().positive();
        assertEquals(schema.isValid(testNumber), true);
    }

    @Test
    public void testIsValidRangeTrue() {
        Integer testNumber = 43;
        var v = new Validator();
        var schema = v.number().range(33, 43);
        assertEquals(schema.isValid(testNumber), true);
    }
}
