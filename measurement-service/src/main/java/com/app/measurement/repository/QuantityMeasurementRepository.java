package com.app.measurement.repository;

import com.app.measurement.model.QuantityMeasurementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuantityMeasurementRepository extends JpaRepository<QuantityMeasurementEntity, Long> {
    List<QuantityMeasurementEntity> findByOperation(String operation);
    List<QuantityMeasurementEntity> findByOperand1(String operand1);
    List<QuantityMeasurementEntity> findByErrorIsNotNull();
    List<QuantityMeasurementEntity> findByUserEmail(String userEmail);
    void deleteByUserEmail(String userEmail);
    long countByOperation(String operation);
}
