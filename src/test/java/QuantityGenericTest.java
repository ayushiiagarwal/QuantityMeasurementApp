import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityGenericTest {
    private static final double EPSILON = 0.0001;

    @Test
    void testSubtraction_SameUnit_FeetMinusFeet(){

        Quantity<LengthUnit> quantity1 = new Quantity<LengthUnit>(10.0, LengthUnit.FEET); 
        Quantity<LengthUnit> quantity2 = new Quantity<LengthUnit>(5.0, LengthUnit.FEET); 

        assertEquals(new Quantity<>(5.0, LengthUnit.FEET), quantity1.subtract(quantity2));
    }

    @Test
    void testSubtraction_SameUnit_LitreMinusLitre(){

        Quantity<VolumeUnit> quantity1 = new Quantity<VolumeUnit>(10.0, VolumeUnit.LITRE); 
        Quantity<VolumeUnit> quantity2 = new Quantity<VolumeUnit>(5.0, VolumeUnit.LITRE); 

        assertEquals(new Quantity<>(5.0, VolumeUnit.LITRE), quantity1.subtract(quantity2));
    }

    @Test
    void testSubtraction_CrossUnit_FeetMinusInches(){

        Quantity<LengthUnit> quantity1 = new Quantity<LengthUnit>(10.0, LengthUnit.FEET); 
        Quantity<LengthUnit> quantity2 = new Quantity<LengthUnit>(6.0, LengthUnit.INCH); 

        assertEquals(new Quantity<>(9.5, LengthUnit.FEET), quantity1.subtract(quantity2));
    }

    @Test
    void testSubtraction_CrossUnit_InchesMinusFeet(){

        Quantity<LengthUnit> quantity1 = new Quantity<LengthUnit>(120.0, LengthUnit.INCH); 
        Quantity<LengthUnit> quantity2 = new Quantity<LengthUnit>(5.0, LengthUnit.FEET); 

        assertEquals(new Quantity<>(60.0, LengthUnit.INCH), quantity1.subtract(quantity2));
    }

    @Test
    void testSubtraction_ExplicitTargetUnit_Feet(){

        Quantity<LengthUnit> quantity1 = new Quantity<LengthUnit>(10.0, LengthUnit.FEET); 
        Quantity<LengthUnit> quantity2 = new Quantity<LengthUnit>(6.0, LengthUnit.INCH); 

        assertEquals(new Quantity<>(114.0, LengthUnit.INCH), quantity1.subtract(quantity2, LengthUnit.INCH));
    }

    @Test
    void testSubtraction_ExplicitTargetUnit_Millilitre(){

        Quantity<VolumeUnit> quantity1 = new Quantity<VolumeUnit>(5.0, VolumeUnit.LITRE); 
        Quantity<VolumeUnit> quantity2 = new Quantity<VolumeUnit>(2000.0, VolumeUnit.MILLILITRE); 

        assertEquals(new Quantity<>(3000.0, VolumeUnit.MILLILITRE), quantity1.subtract(quantity2, VolumeUnit.MILLILITRE));
    }

    @Test
    void testSubtraction_ResultingInNegative(){

        Quantity<LengthUnit> quantity1 = new Quantity<LengthUnit>(5.0, LengthUnit.FEET); 
        Quantity<LengthUnit> quantity2 = new Quantity<LengthUnit>(10.0, LengthUnit.FEET); 

        assertEquals(new Quantity<>(-5.0, LengthUnit.FEET), quantity1.subtract(quantity2));
    }

    @Test
    void testSubtraction_ResultingInZero(){

        Quantity<LengthUnit> quantity1 = new Quantity<LengthUnit>(10.0, LengthUnit.FEET); 
        Quantity<LengthUnit> quantity2 = new Quantity<LengthUnit>(120.0, LengthUnit.INCH); 

        assertEquals(new Quantity<>(0.0, LengthUnit.FEET), quantity1.subtract(quantity2));
    }

    @Test
    void testSubtraction_WithZeroOperand(){

        Quantity<LengthUnit> quantity1 = new Quantity<LengthUnit>(5.0, LengthUnit.FEET); 
        Quantity<LengthUnit> quantity2 = new Quantity<LengthUnit>(0.0, LengthUnit.INCH); 

        assertEquals(new Quantity<>(5.0, LengthUnit.FEET), quantity1.subtract(quantity2));
    }

    @Test
    void testSubtraction_WithNegativeValues(){

        Quantity<LengthUnit> quantity1 = new Quantity<LengthUnit>(5.0, LengthUnit.FEET); 
        Quantity<LengthUnit> quantity2 = new Quantity<LengthUnit>(-2.0, LengthUnit.FEET); 

        assertEquals(new Quantity<>(7.0, LengthUnit.FEET), quantity1.subtract(quantity2));
    }

    @Test
    void testSubtraction_NonCommutative(){

        Quantity<LengthUnit> quantity1 = new Quantity<LengthUnit>(10.0, LengthUnit.FEET); 
        Quantity<LengthUnit> quantity2 = new Quantity<LengthUnit>(5.0, LengthUnit.FEET); 

        assertNotEquals(quantity1.subtract(quantity2), quantity2.subtract(quantity1));
    }

    @Test
    void testSubtraction_WithLargeValues(){

        Quantity<WeightUnit> quantity1 = new Quantity<WeightUnit>(1e6, WeightUnit.KILOGRAM); 
        Quantity<WeightUnit> quantity2 = new Quantity<WeightUnit>(5e5, WeightUnit.KILOGRAM); 

        assertEquals(new Quantity<>(5e5, WeightUnit.KILOGRAM), quantity1.subtract(quantity2));
    }

    
    @Test
    void testSubtraction_NullOperand(){

        assertThrows(IllegalArgumentException.class, () -> new Quantity<>(10.0, LengthUnit.FEET).subtract(null));
    }

    @Test
    void testSubtraction_NullTargetUnit(){

        Quantity<LengthUnit> quantity1 = new Quantity<LengthUnit>(10.0, LengthUnit.FEET); 
        Quantity<LengthUnit> quantity2 = new Quantity<LengthUnit>(5.0, LengthUnit.FEET); 

        assertThrows(IllegalArgumentException.class, () -> quantity1.subtract(quantity2, null));
    }

    @Test
    void testSubtraction_ChainedOperations(){

        Quantity<LengthUnit> quantity1 = new Quantity<LengthUnit>(10.0, LengthUnit.FEET); 
        Quantity<LengthUnit> quantity2 = new Quantity<LengthUnit>(2.0, LengthUnit.FEET); 
        Quantity<LengthUnit> q3 = new Quantity<LengthUnit>(1.0, LengthUnit.FEET); 

        assertEquals(new Quantity<>(7.0, LengthUnit.FEET), quantity1.subtract(quantity2).subtract(q3));
    }
    
    @Test
    void testDivision_SameUnit_FeetDividedByFeet(){

        Quantity<LengthUnit> quantity1 = new Quantity<LengthUnit>(10.0, LengthUnit.FEET); 
        Quantity<LengthUnit> quantity2 = new Quantity<LengthUnit>(2.0, LengthUnit.FEET); 

        assertEquals(5.0, quantity1.divide(quantity2));
    }

    @Test
    void testDivision_SameUnit_LitreDividedByLitre(){

        Quantity<VolumeUnit> quantity1 = new Quantity<VolumeUnit>(10.0, VolumeUnit.LITRE); 
        Quantity<VolumeUnit> quantity2 = new Quantity<VolumeUnit>(5.0, VolumeUnit.LITRE); 

        assertEquals(2.0, quantity1.divide(quantity2));
    }

    @Test
    void testDivision_CrossUnit_FeetDividedByInches(){

        Quantity<LengthUnit> quantity1 = new Quantity<LengthUnit>(24.0, LengthUnit.INCH); 
        Quantity<LengthUnit> quantity2 = new Quantity<LengthUnit>(2.0, LengthUnit.FEET); 

        assertEquals(1.0, quantity1.divide(quantity2));
    }

    @Test
    void testDivision_CrossUnit_KilogramDividedByGram(){

        Quantity<WeightUnit> quantity1 = new Quantity<WeightUnit>(2.0, WeightUnit.KILOGRAM); 
        Quantity<WeightUnit> quantity2 = new Quantity<WeightUnit>(2000.0, WeightUnit.GRAM); 

        assertEquals(1.0, quantity1.divide(quantity2));
    }

    @Test 
    void testDivision_RatioGreaterThanOne(){

        Quantity<LengthUnit> a = new Quantity<>(10.0, LengthUnit.FEET); 
        Quantity<LengthUnit> b = new Quantity<>(2.0, LengthUnit.FEET); 
        double result = a.divide(b); 
        
        assertEquals(5.0, result, EPSILON);
    }

    @Test 
    void testDivision_RatioLessThanOne() { 

        Quantity<LengthUnit> a = new Quantity<>(5.0, LengthUnit.FEET); 
        Quantity<LengthUnit> b = new Quantity<>(10.0, LengthUnit.FEET); 
        double result = a.divide(b); 
        
        assertEquals(0.5, result, EPSILON); 
    } 
        
    
    @Test 
    void testDivision_RatioEqualToOne() { 

        Quantity<LengthUnit> a = new Quantity<>(10.0, LengthUnit.FEET); 
        Quantity<LengthUnit> b = new Quantity<>(10.0, LengthUnit.FEET); 
        double result = a.divide(b); 
        
        assertEquals(1.0, result, EPSILON); 
    }

    @Test
    void testDivision_NonCommutative(){

        Quantity<LengthUnit> quantity1 = new Quantity<>(10.0, LengthUnit.FEET); 
        Quantity<LengthUnit> quantity2 = new Quantity<>(5.0, LengthUnit.FEET); 

        assertNotEquals(quantity1.divide(quantity2), quantity2.divide(quantity1));
    }

    @Test 
    void testDivision_ByZero(){
        
        Quantity<LengthUnit> quantity1 = new Quantity<>(10.0, LengthUnit.FEET); 
        Quantity<LengthUnit> quantity2 = new Quantity<>(0.0, LengthUnit.FEET); 

        assertThrows(ArithmeticException.class, () -> quantity1.divide(quantity2));
    }

}

