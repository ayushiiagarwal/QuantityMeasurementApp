import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LengthTest {
    @Test
    void testAddition_ExplicitTarget_Feet(){
        Length result = Length.add(new Length(1.0, LengthUnit.FEET), new Length(12.0, LengthUnit.INCH), LengthUnit.FEET);
        Length answer = new Length(2.0, LengthUnit.FEET);

        assertEquals(answer, result);
    }

    @Test
    void testAddition_ExplicitTarget_Inches(){
        Length result = Length.add(new Length(1.0, LengthUnit.FEET), new Length(12.0, LengthUnit.INCH), LengthUnit.INCH);
        Length answer = new Length(24.0, LengthUnit.INCH);

        assertEquals(answer, result);
    }

    @Test
    void testAddition_ExplicitTarget_Yards(){
        Length result = Length.add(new Length(1.0, LengthUnit.FEET), new Length(12.0, LengthUnit.INCH), LengthUnit.YARDS);
        Length answer = new Length(0.667, LengthUnit.YARDS);

        assertEquals(answer, result);
    }

    @Test
    void testAddition_ExplicitTarget_Centimeters(){
        Length result = Length.add(new Length(1.0, LengthUnit.INCH), new Length(1.0, LengthUnit.INCH), LengthUnit.CENTIMETER);
        Length answer = new Length(5.08, LengthUnit.CENTIMETER);

        assertEquals(answer, result);
    }

    @Test
    void testAddition_ExplicitTarget_SameAsSecondOperand(){
        Length result = Length.add(new Length(2.0, LengthUnit.YARDS), new Length(3.0, LengthUnit.FEET), LengthUnit.FEET);
        Length answer = new Length(9.0, LengthUnit.FEET);

        assertEquals(answer, result);
    }

    @Test
    void testAddition_ExplicitTarget_Commutativity(){
        Length result1 = Length.add(new Length(1.0, LengthUnit.FEET), new Length(12.0, LengthUnit.INCH), LengthUnit.YARDS);
        Length result2 =  Length.add(new Length(12.0, LengthUnit.INCH), new Length(1.0, LengthUnit.FEET), LengthUnit.YARDS);
        assertEquals(result1, result2);
    }

    @Test
    void testAddition_ExplicitTarget_WithZero(){
        Length result = Length.add(new Length(5.0, LengthUnit.FEET), new Length(0.0, LengthUnit.INCH), LengthUnit.YARDS);
        Length answer = new Length(1.667, LengthUnit.YARDS);

        assertEquals(answer, result);
    }

    @Test
    void testAddition_ExplicitTarget_NegativeValues(){
        Length result = Length.add(new Length(5.0, LengthUnit.FEET), new Length(-2.0, LengthUnit.FEET), LengthUnit.INCH);
        Length answer = new Length(36.0, LengthUnit.INCH);

        assertEquals(answer, result);
    }

    @Test
    void testAddition_ExplicitTarget_NullTargetUnit(){
        assertThrows(IllegalArgumentException.class, () -> Length.add(new Length(1.0, LengthUnit.FEET), new Length(12.0, LengthUnit.INCH), null));
    }

    @Test
    void testAddition_ExplicitTarget_LargeToSmallScale(){
        Length result = Length.add(new Length(1000.0, LengthUnit.FEET), new Length(500.0, LengthUnit.FEET), LengthUnit.INCH);
        Length answer = new Length(18000.0, LengthUnit.INCH);

        assertEquals(answer, result);
    }

    @Test
    void testAddition_ExplicitTarget_SamllToLargeScale(){
        Length result = Length.add(new Length(12.0, LengthUnit.INCH), new Length(12.0, LengthUnit.INCH), LengthUnit.YARDS);
        Length answer = new Length(0.667, LengthUnit.YARDS);

        assertEquals(answer, result);
    }
}