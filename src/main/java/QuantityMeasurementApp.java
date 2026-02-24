public class QuantityMeasurementApp {
    public static void main(String[] args) {
        Length foot = new Length(1.0, Length.LengthUnit.FEET);
        Length inches = new Length(12.0, Length.LengthUnit.INCH);
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Length cm = new Length(30.48, Length.LengthUnit.CENTIMETER);

        System.out.println("1 feet = 12 inches " + foot.equals(inches) +
                            "\n1 yard = 3 feets " + yard.equals(new Length(3.0, Length.LengthUnit.FEET)) +
                            "\n30.48cm = 1 feet " + cm.equals(foot));

        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        Length inch = new Length(2.0, Length.LengthUnit.INCH);

        Length result1 = feet.add(inch);
        System.out.println("1 feet + 2 inches = " + result1);
     
        Length result2 = inch.add(feet);
        System.out.println("2 inches + 1 feet = " + result2);

        Length yd = new Length(1.0, Length.LengthUnit.YARDS);
        Length feetTwo = new Length(2.0, Length.LengthUnit.FEET);

        Length result3 = yd.add(feetTwo);
        System.out.println("1 yard + 2 feets = " + result3);
        Length zero = new Length(0.0, Length.LengthUnit.FEET);
        Length negative = new Length(-2.0, Length.LengthUnit.FEET);

        System.out.println("1 feet + 0 feet = " + feet.add(zero));
        System.out.println("5 feet + (-2 feet) = " + new Length(5.0, Length.LengthUnit.FEET).add(negative));
    }
}
