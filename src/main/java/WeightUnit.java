public enum WeightUnit {
    KILOGRAM(1.0),
    GRAM(0.001),
    POUND(0.453592);

    private final double toKG;

    WeightUnit(double toKG){
        this.toKG = toKG;
    }

    // kg as the baseValue
    public double getConversionFactor(){
        return toKG;
    }

    // converting to baseValue
    public double convertToKG(double baseValue){
        return baseValue * toKG;
    }

    // converting from baseValue
    public double convertFromKG(double baseValue){
        return baseValue / toKG;
    }

}
