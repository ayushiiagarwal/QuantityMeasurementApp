package com.app.quantitymeasurement.service;
import com.app.quantitymeasurement.model.QuantityMeasurementEntity;
import com.app.quantitymeasurement.quantity.Quantity;

public interface IQuantityMeasurementService {

    QuantityMeasurementEntity compare(Quantity<?> quantity1, Quantity<?> quantity2);
    
    QuantityMeasurementEntity convert(Quantity<?> quantity, Object targetUnit);
    
    QuantityMeasurementEntity add(Quantity<?> quantity1, Quantity<?> quantity2);
    
    QuantityMeasurementEntity subtract(Quantity<?> quantity1, Quantity<?> quantity2);
    
    QuantityMeasurementEntity divide(Quantity<?> quantity1, Quantity<?> quantity2);
}