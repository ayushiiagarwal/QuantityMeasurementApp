import java.util.Objects;

public class QuantityLength {
    private final double value;
    private final LengthUnit unit;

    private static final double EPSILON = 1e-6;

    public QuantityLength(double value, LengthUnit unit){
        if(unit == null) throw new IllegalArgumentException("Unit cannot be null");

        if(!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid numeric value");

        this.value = value;
        this.unit = unit;
    }

    private double toBaseValue(){
        return unit.toFeet(value);
    }

    public static double convert(double value, LengthUnit source, LengthUnit target){
        if(source == null || target == null)
            throw new IllegalArgumentException("Unit cannot be null");

        if(!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid numeric value");

        return target.fromFeet(source.toFeet(value));
    }

    public QuantityLength convertTo(LengthUnit targetUnit){
        return new QuantityLength(convert(this.value, this.unit, targetUnit), targetUnit);
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        QuantityLength other = (QuantityLength) obj;
        return Double.compare(this.toBaseValue(), other.toBaseValue()) < EPSILON;
    }

    @Override
    public int hashCode(){
        return Objects.hash(toBaseValue());
    }
}