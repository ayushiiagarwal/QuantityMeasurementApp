package com.app.measurement.units;

import com.app.measurement.measurable.IMeasurable;
import com.app.measurement.support.SupportsArithmetic;

import java.util.function.Function;

public enum TemperatureUnit implements IMeasurable {
    CELSIUS(c -> c, c -> c),
    FAHRENHEIT(f -> (f - 32) * 5.0 / 9, c -> (c * 9.0 / 5) + 32);

    private final Function<Double, Double> toCelsius;
    private final Function<Double, Double> fromCelsius;
    private static final SupportsArithmetic supportsArithmetic = () -> false;

    TemperatureUnit(Function<Double, Double> toCelsius, Function<Double, Double> fromCelsius) {
        this.toCelsius   = toCelsius;
        this.fromCelsius = fromCelsius;
    }

    @Override public double convertToBase(double value)     { return toCelsius.apply(value); }
    @Override public double convertFromBase(double value)   { return fromCelsius.apply(value); }
    @Override public double getConversionFactor()           { return 1.0; }
    @Override public String getUnitName()                   { return name(); }

    @Override
    public void validOperationSupport(String operation) {
        if (!supportsArithmetic.isSupported())
            throw new UnsupportedOperationException("Arithmetic is not supported for temperature units.");
    }
}
