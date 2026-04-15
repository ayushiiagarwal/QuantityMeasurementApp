package com.app.measurement.service;

import com.app.measurement.measurable.IMeasurable;
import com.app.measurement.model.QuantityMeasurementEntity;
import com.app.measurement.quantity.Quantity;
import com.app.measurement.repository.QuantityMeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("unchecked")
@Service
public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService {

    @Autowired
    private QuantityMeasurementRepository repository;

    @Override
    public QuantityMeasurementEntity compare(Quantity<?> q1, Quantity<?> q2, String userEmail) {
        try {
            boolean result = q1.equals(q2);
            return save(new QuantityMeasurementEntity("COMPARE", q1.toString(), q2.toString(),
                    String.valueOf(result)), userEmail);
        } catch (Exception e) {
            return save(new QuantityMeasurementEntity(e.getMessage()), userEmail);
        }
    }

    @Override
    public QuantityMeasurementEntity convert(Quantity<?> quantity, Object targetUnit, String userEmail) {
        try {
            Quantity<IMeasurable> q = (Quantity<IMeasurable>) quantity;
            Quantity<?> result = q.convertTo(((Quantity<?>) targetUnit).getUnit());
            return save(new QuantityMeasurementEntity("CONVERT", quantity.toString(), null,
                    result.toString()), userEmail);
        } catch (Exception e) {
            return save(new QuantityMeasurementEntity(e.getMessage()), userEmail);
        }
    }

    @Override
    public QuantityMeasurementEntity add(Quantity<?> q1, Quantity<?> q2, String userEmail) {
        try {
            Quantity result = ((Quantity) q1).add((Quantity) q2);
            return save(new QuantityMeasurementEntity("ADD", q1.toString(), q2.toString(),
                    result.toString()), userEmail);
        } catch (Exception e) {
            return save(new QuantityMeasurementEntity(e.getMessage()), userEmail);
        }
    }

    @Override
    public QuantityMeasurementEntity subtract(Quantity<?> q1, Quantity<?> q2, String userEmail) {
        try {
            Quantity result = ((Quantity) q1).subtract((Quantity) q2);
            return save(new QuantityMeasurementEntity("SUBTRACT", q1.toString(), q2.toString(),
                    result.toString()), userEmail);
        } catch (Exception e) {
            return save(new QuantityMeasurementEntity(e.getMessage()), userEmail);
        }
    }

    @Override
    public QuantityMeasurementEntity divide(Quantity<?> q1, Quantity<?> q2, String userEmail) {
        try {
            double result = ((Quantity) q1).divide((Quantity) q2);
            return save(new QuantityMeasurementEntity("DIVIDE", q1.toString(), q2.toString(),
                    String.valueOf(result)), userEmail);
        } catch (Exception e) {
            return save(new QuantityMeasurementEntity(e.getMessage()), userEmail);
        }
    }

    private QuantityMeasurementEntity save(QuantityMeasurementEntity entity, String userEmail) {
        entity.setUserEmail(userEmail);
        return repository.save(entity);
    }
}
