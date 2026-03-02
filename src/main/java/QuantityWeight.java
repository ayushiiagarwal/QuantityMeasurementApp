import java.util.Objects;

public class QuantityWeight {
    private final double value;
    private final WeightUnit unit;

    private static final double EPSILON = 0.000001;

    public QuantityWeight(double value, WeightUnit unit){
        if(unit == null) throw new IllegalArgumentException("unit cannot be null!");

        if(!Double.isFinite(value)) throw new IllegalArgumentException("Invalid Number.");

        this.value = value;
        this.unit = unit;
    }

    public double toBaseValue(){ return unit.convertToKG(value); }

    // equals method
    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() !=obj.getClass()) return false;
        
        QuantityWeight other = (QuantityWeight) obj;
        return Math.abs(this.toBaseValue() - other.toBaseValue()) < EPSILON;
    }
    
    @Override
    public int hashCode(){
        double baseValue = unit.convertToKG(value);
        return Objects.hash(Math.round(baseValue / EPSILON));
    }

    // convert to method
    public QuantityWeight convertTo(WeightUnit targetUnit){
        if(targetUnit == null) throw new IllegalArgumentException("unit cannot be null!");

        double baseValue = unit.convertToKG(this.value);
        double convertedValue = targetUnit.convertFromKG(baseValue);

        return new QuantityWeight(convertedValue, targetUnit);
    }

    // add method
    public static QuantityWeight add(QuantityWeight w1, QuantityWeight w2, WeightUnit targetUnit){
        if(w1 == null || w2 == null) throw new IllegalArgumentException("Quantity cannot be null!");
        if(targetUnit == null) throw new IllegalArgumentException("Target Unit cannot be null!");

        double sum = w1.toBaseValue() + w2.toBaseValue(); // sum in KG

        double converted = targetUnit.convertToKG(sum);

        return new QuantityWeight(Math.round(converted * 1000.0) / 1000.0, targetUnit);
    }

    public QuantityWeight add(QuantityWeight other){
        return add(this, other, this.unit);
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}
