import java.util.Objects;

public class Length {
    private final double value;
    private final LengthUnit unit;
    public enum LengthUnit{
        FEET(1.0), INCH(1.0/12),
        YARDS(3.0), CENTIMETER(0.3280839895);

        private final double convertToFeet;

        LengthUnit(double convertToFeet){
            this.convertToFeet = convertToFeet;
        }

        public double toFeet(double value){
            return value * convertToFeet;
        }

        public double fromFeet(double value){
            return value/convertToFeet;
        }

        public double feetFactor(){ return convertToFeet; }
    }

    public Length(double value, LengthUnit unit){
        this.value = value;
        this.unit= unit;
    }

    private double toBaseValue(){ return unit.toFeet(value); }

    public Length add(Length q){
        if(q == null) throw new IllegalArgumentException("Null value cannot be added");

        double v1 = this.toBaseValue();
        double v2 = q.toBaseValue();
        double sum = v1 + v2;
        
        return new Length(this.unit.fromFeet(sum), this.unit);
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        Length other = (Length) obj;
        return Double.compare(this.toBaseValue(), other.toBaseValue()) == 0;
    }

    @Override
    public int hashCode(){ return Objects.hash(toBaseValue()); }

    public String toString(){ return value + " " + unit; }
}
