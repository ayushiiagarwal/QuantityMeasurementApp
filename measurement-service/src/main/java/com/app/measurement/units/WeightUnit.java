package com.app.measurement.units;

import com.app.measurement.measurable.IMeasurable;
import com.app.measurement.support.SupportsArithmetic;

public enum WeightUnit implements IMeasurable {
    KILOGRAM(1.0),
    GRAM(0.001),
    POUND(0.453592);

    private final double toKG;
    private static final SupportsArithmetic sm = () -> true;

    WeightUnit(double toKG) { this.toKG = toKG; }

    @Override public double getConversionFactor()         { return toKG; }
    @Override public double convertToBase(double value)   { return value * toKG; }
    @Override public double convertFromBase(double value) { return value / toKG; }
    @Override public String getUnitName()                 { return this.name(); }
}
