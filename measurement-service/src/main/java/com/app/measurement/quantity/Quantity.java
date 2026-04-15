package com.app.measurement.quantity;

import com.app.measurement.measurable.IMeasurable;

import java.util.Objects;

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
        if (unit == null)              throw new IllegalArgumentException("Unit cannot be null!");
        if (!Double.isFinite(value))   throw new IllegalArgumentException("Value must be finite!");
        this.value = value;
        this.unit  = unit;
    }

    private double toBaseValue() {
        return Math.round(unit.convertToBase(value) * 100_000.0) / 100_000.0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Quantity<?> other = (Quantity<?>) obj;
        if (!this.unit.getClass().equals(other.unit.getClass())) return false;
        return Double.compare(this.toBaseValue(), other.toBaseValue()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(toBaseValue(), unit.getClass());
    }

    public Quantity<U> convertTo(U targetUnit) {
        return createQuantityFromBase(this.toBaseValue(), targetUnit);
    }

    public Quantity<U> add(Quantity<U> other)                       { return add(other, this.unit); }
    public Quantity<U> add(Quantity<U> other, U targetUnit)         { return createQuantityFromBase(operate(other, Op.ADD), targetUnit); }

    public Quantity<U> subtract(Quantity<U> other)                  { return subtract(other, this.unit); }
    public Quantity<U> subtract(Quantity<U> other, U targetUnit)    { return createQuantityFromBase(operate(other, Op.SUBTRACT), targetUnit); }

    public double divide(Quantity<U> other)                         { return operate(other, Op.DIVIDE); }

    private enum Op { ADD, SUBTRACT, DIVIDE }

    private double operate(Quantity<U> other, Op op) {
        if (other == null) throw new IllegalArgumentException("Other quantity cannot be null!");
        if (!this.unit.getClass().equals(other.unit.getClass()))
            throw new IllegalArgumentException("Incompatible unit categories.");

        double b1 = this.toBaseValue();
        double b2 = other.toBaseValue();

        if (!Double.isFinite(b1) || !Double.isFinite(b2))
            throw new IllegalArgumentException("Non-finite numeric value.");

        if (op == Op.DIVIDE && b2 == 0.0)
            throw new IllegalArgumentException("Cannot divide by zero.");

        return switch (op) {
            case ADD      -> b1 + b2;
            case SUBTRACT -> b1 - b2;
            case DIVIDE   -> b1 / b2;
        };
    }

    private Quantity<U> createQuantityFromBase(double base, U targetUnit) {
        if (targetUnit == null) throw new IllegalArgumentException("Target unit cannot be null.");
        double converted = targetUnit.convertFromBase(base);
        return new Quantity<>(Math.round(converted * 100.0) / 100.0, targetUnit);
    }

    @Override
    public String toString() { return String.format("%.2f %s", value, unit.getUnitName()); }

    public U getUnit() { return unit; }
}
