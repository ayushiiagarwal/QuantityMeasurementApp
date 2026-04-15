package com.app.measurement.service;

import com.app.measurement.model.QuantityMeasurementEntity;
import com.app.measurement.quantity.Quantity;

public interface IQuantityMeasurementService {
    QuantityMeasurementEntity compare(Quantity<?> q1, Quantity<?> q2, String userEmail);
    QuantityMeasurementEntity convert(Quantity<?> quantity, Object targetUnit, String userEmail);
    QuantityMeasurementEntity add(Quantity<?> q1, Quantity<?> q2, String userEmail);
    QuantityMeasurementEntity subtract(Quantity<?> q1, Quantity<?> q2, String userEmail);
    QuantityMeasurementEntity divide(Quantity<?> q1, Quantity<?> q2, String userEmail);
}
