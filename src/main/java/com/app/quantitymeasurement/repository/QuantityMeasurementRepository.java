package com.app.quantitymeasurement.repository;

import java.util.List;
import com.app.quantitymeasurement.model.QuantityMeasurementEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuantityMeasurementRepository extends JpaRepository<QuantityMeasurementEntity, Long>{
    List<QuantityMeasurementEntity> findByOperation(String operation);
    List<QuantityMeasurementEntity> findByOperand1(String operand1);
    List<QuantityMeasurementEntity> findByErrorIsNotNull();

    long countByOperation(String operation);
}
