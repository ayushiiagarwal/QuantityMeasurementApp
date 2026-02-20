public class QuantityMeasurementApp {

    public static void demonstrateLengthConversion(double value, LengthUnit from, LengthUnit to){
        double result = QuantityLength.convert(value, from, to);
        System.out.println(value + " " + from + " = " + result + " " + to);
    }

    public static void demonstrateLengthConversion(QuantityLength q, LengthUnit to){
        System.out.println(q + " = " + q.convertTo(to));
    }

    public static void main(String[] args) {
        QuantityMeasurementApp.demonstrateLengthConversion(1.0, LengthUnit.FEET, LengthUnit.INCH);
        QuantityMeasurementApp.demonstrateLengthConversion(3.0, LengthUnit.YARDS, LengthUnit.FEET);
        QuantityMeasurementApp.demonstrateLengthConversion(36.0, LengthUnit.INCH, LengthUnit.YARDS);
        QuantityMeasurementApp.demonstrateLengthConversion(1.0, LengthUnit.CENTIMETER, LengthUnit.INCH);

        QuantityLength len = new QuantityLength(2.0, LengthUnit.YARDS);
        QuantityMeasurementApp.demonstrateLengthConversion(len, LengthUnit.INCH);
    }
}
