import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LengthTest {
    @Test
    void testAddition_ExplicitTarget_Feet(){
        Length result = Length.add(new Length(1.0, Length.LengthUnit.FEET), new Length(12.0, Length.LengthUnit.INCH), Length.LengthUnit.FEET);
        Length answer = new Length(2.0, Length.LengthUnit.FEET);

        assertEquals(answer, result);
    }

    @Test
    void testAddition_ExplicitTarget_Inches(){
        Length result = Length.add(new Length(1.0, Length.LengthUnit.FEET), new Length(12.0, Length.LengthUnit.INCH), Length.LengthUnit.INCH);
        Length answer = new Length(24.0, Length.LengthUnit.INCH);

        assertEquals(answer, result);
    }

    @Test
    void testAddition_ExplicitTarget_Yards(){
        Length result = Length.add(new Length(1.0, Length.LengthUnit.FEET), new Length(12.0, Length.LengthUnit.INCH), Length.LengthUnit.YARDS);
        Length answer = new Length(0.667, Length.LengthUnit.YARDS);

        assertEquals(answer, result);
    }

    @Test
    void testAddition_ExplicitTarget_Centimeters(){
        Length result = Length.add(new Length(1.0, Length.LengthUnit.INCH), new Length(1.0, Length.LengthUnit.INCH), Length.LengthUnit.CENTIMETER);
        Length answer = new Length(5.08, Length.LengthUnit.CENTIMETER);

        assertEquals(answer, result);
    }

    @Test
    void testAddition_ExplicitTarget_SameAsSecondOperand(){
        Length result = Length.add(new Length(2.0, Length.LengthUnit.YARDS), new Length(3.0, Length.LengthUnit.FEET), Length.LengthUnit.FEET);
        Length answer = new Length(9.0, Length.LengthUnit.FEET);

        assertEquals(answer, result);
    }

    @Test
    void testAddition_ExplicitTarget_Commutativity(){
        Length res1 = Length.add(new Length(1.0, Length.LengthUnit.FEET), new Length(12.0, Length.LengthUnit.INCH), Length.LengthUnit.YARDS);
        Length res2 =  Length.add(new Length(12.0, Length.LengthUnit.INCH), new Length(1.0, Length.LengthUnit.FEET), Length.LengthUnit.YARDS);
        assertEquals(res1, res2);
    }

    @Test
    void testAddition_ExplicitTarget_WithZero(){
        Length result = Length.add(new Length(5.0, Length.LengthUnit.FEET), new Length(0.0, Length.LengthUnit.INCH), Length.LengthUnit.YARDS);
        Length answer = new Length(1.667, Length.LengthUnit.YARDS);

        assertEquals(answer, result);
    }

    @Test
    void testAddition_ExplicitTarget_NegativeValues(){
        Length result = Length.add(new Length(5.0, Length.LengthUnit.FEET), new Length(-2.0, Length.LengthUnit.FEET), Length.LengthUnit.INCH);
        Length answer = new Length(36.0, Length.LengthUnit.INCH);

        assertEquals(answer, result);
    }

    @Test
    void testAddition_ExplicitTarget_NullTargetUnit(){
        assertThrows(IllegalArgumentException.class, () -> Length.add(new Length(1.0, Length.LengthUnit.FEET), new Length(12.0, Length.LengthUnit.INCH), null));
    }

    @Test
    void testAddition_ExplicitTarget_LargeToSmallScale(){
        Length result = Length.add(new Length(1000.0, Length.LengthUnit.FEET), new Length(500.0, Length.LengthUnit.FEET), Length.LengthUnit.INCH);
        Length answer = new Length(18000.0, Length.LengthUnit.INCH);

        assertEquals(answer, result);
    }

    @Test
    void testAddition_ExplicitTarget_SamllToLargeScale(){
        Length result = Length.add(new Length(12.0, Length.LengthUnit.INCH), new Length(12.0, Length.LengthUnit.INCH), Length.LengthUnit.YARDS);
        Length answer = new Length(0.667, Length.LengthUnit.YARDS);

        assertEquals(answer, result);
    }
}