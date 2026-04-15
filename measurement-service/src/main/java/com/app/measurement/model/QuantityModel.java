package com.app.measurement.model;

import com.app.measurement.quantity.Quantity;
import com.app.measurement.units.*;

public class QuantityModel {

    public static Quantity<?> toQuantity(QuantityDTO dto) {
        return switch (dto.getUnit()) {
            case "FEET", "INCH", "YARDS", "CENTIMETER"
                -> new Quantity<>(dto.getValue(), LengthUnit.valueOf(dto.getUnit()));
            case "KILOGRAM", "GRAM", "POUND"
                -> new Quantity<>(dto.getValue(), WeightUnit.valueOf(dto.getUnit()));
            case "LITRE", "MILLILITRE", "GALLON"
                -> new Quantity<>(dto.getValue(), VolumeUnit.valueOf(dto.getUnit()));
            case "CELSIUS", "FAHRENHEIT"
                -> new Quantity<>(dto.getValue(), TemperatureUnit.valueOf(dto.getUnit()));
            default -> throw new IllegalArgumentException("Unknown unit: " + dto.getUnit());
        };
    }
}
