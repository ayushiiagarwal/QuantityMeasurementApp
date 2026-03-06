package units;
import support.SupportsArithmetic;
import measurable.IMeasurable;

public enum WeightUnit implements IMeasurable{
    KILOGRAM(1.0),
    GRAM(0.001),
    POUND(0.453592);

    private final double toKG;
    private static final SupportsArithmetic sm = () -> true;

    WeightUnit(double toKG){
        this.toKG = toKG;
    }

    // kg as the baseValue
    public double getConversionFactor(){
        return toKG;
    }

    // converting to baseValue
    public double convertToBase(double baseValue){
        return baseValue * toKG;
    }

    // converting from baseValue
    public double convertFromBase(double baseValue){
        return baseValue / toKG;
    }

     @Override
    public String getUnitName() {
        return this.name();
    }

}
