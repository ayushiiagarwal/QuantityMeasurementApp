package com.app.measurement.service;

import com.app.measurement.model.QuantityMeasurementEntity;
import com.app.measurement.quantity.Quantity;

import java.util.List;

public interface IQuantityMeasurementService {
    QuantityMeasurementEntity compare(Quantity<?> q1, Quantity<?> q2, String userEmail);
    QuantityMeasurementEntity convert(Quantity<?> quantity, Object targetUnit, String userEmail);
    QuantityMeasurementEntity add(Quantity<?> q1, Quantity<?> q2, String userEmail);
    QuantityMeasurementEntity subtract(Quantity<?> q1, Quantity<?> q2, String userEmail);
    QuantityMeasurementEntity divide(Quantity<?> q1, Quantity<?> q2, String userEmail);
    List<QuantityMeasurementEntity> findHistory(String userEmail);
    List<QuantityMeasurementEntity> importHistory(List<QuantityMeasurementEntity> records, String userEmail);
    void clearHistory(String userEmail);
}
