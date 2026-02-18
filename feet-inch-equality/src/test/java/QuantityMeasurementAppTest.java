import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class QuantityMeasurementAppTest {
    //FEET TESTS
    @Test
    void testEquality_SameValue_Feet() {
        assertTrue(QuantityMeasurementApp.compareFeet(1.0, 1.0));
    }

    @Test
    void testEquality_DifferentValue_Feet() {
        assertFalse(QuantityMeasurementApp.compareFeet(1.0, 2.0));
    }

    @Test
    void testEquality_NullComparison_Feet() {
        QuantityMeasurementApp.Feet f = new QuantityMeasurementApp.Feet(1.0);
        assertFalse(f.equals(null));
    }

    @Test
    void testEquality_NonNumericInput_Feet() {
        QuantityMeasurementApp.Feet f = new QuantityMeasurementApp.Feet(1.0);
        String value = "abc";
        assertFalse(f.equals(value));
    }

    @Test
    void testEquality_SameReference_Feet() {
        QuantityMeasurementApp.Feet f = new QuantityMeasurementApp.Feet(1.0);
        assertTrue(f.equals(f));
    }

    // INCH TESTS
    @Test
    void testEquality_SameValue_Inches() {
        assertTrue(QuantityMeasurementApp.compareInches(1.0, 1.0));
    }

    @Test
    void testEquality_DifferentValue_Inches() {
        assertFalse(QuantityMeasurementApp.compareInches(1.0, 2.0));
    }

    @Test
    void testEquality_NullComparison_Inches() {
        QuantityMeasurementApp.Inches i = new QuantityMeasurementApp.Inches(1.0);
        assertFalse(i.equals(null));
    }

    @Test
    void testEquality_NonNumericInput_Inches() {
        QuantityMeasurementApp.Inches i = new QuantityMeasurementApp.Inches(1.0);
        String value = "xyz";
        assertFalse(i.equals(value));
    }

    @Test
    void testEquality_SameReference_Inches() {
        QuantityMeasurementApp.Inches i = new QuantityMeasurementApp.Inches(1.0);
        assertTrue(i.equals(i));
    }
}
