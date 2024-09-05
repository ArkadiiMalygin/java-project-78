package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringSchemasTest {
    @Test
    public void testIsValidNull() {
        String testString = null;
        var v = new Validator();
        var schema = v.string();
        assertEquals(schema.isValid(testString), true);

    }

    @Test
    public void testIsValidEmpty() {
        String testString = "";
        var v = new Validator();
        var schema = v.string();
        assertEquals(schema.isValid(testString), true);
    }

    @Test
    public void testIsValidRequiredNull() {
        String testString = null;
        var v = new Validator();
        var schema = v.string().required();
        assertEquals(schema.isValid(testString), false);

    }

    @Test
    public void testIsValidRequiredEmpty() {
        String testString = "";
        var v = new Validator();
        var schema = v.string().required();
        assertEquals(schema.isValid(testString), false);
    }

    @Test
    public void testIsValid() {
        String testString = "grin without a cat";
        var v = new Validator();
        var schema = v.string();
        assertEquals(schema.isValid(testString), true);

    }

    @Test
    public void testIsValidContainsEmpty() {
        String testString = "grin without a cat";
        var v = new Validator();
        var schema = v.string().contains("");
        assertEquals(schema.isValid(testString), true);
    }

    @Test
    public void testIsValidContains() {
        String testString = "grin without a cat";
        var v = new Validator();
        var schema = v.string().contains("grin");
        assertEquals(schema.isValid(testString), true);
    }

    @Test
    public void testIsValidContainsMinLengthTrue() {
        String testString = "grin without a cat";
        var v = new Validator();
        var schema = v.string().minLength(5);
        assertEquals(schema.isValid(testString), true);
    }

    @Test
    public void testIsValidContainsMinlengthFalse() {
        String testString = "grin without a cat";
        var v = new Validator();
        var schema = v.string().minLength(200);
        assertEquals(schema.isValid(testString), false);
    }
}
