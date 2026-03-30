package com.app.quantitymeasurement.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "entities")
public class QuantityMeasurementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String operation, operand1, operand2, result, error;
    private LocalDateTime createdAt;

    public QuantityMeasurementEntity(){}

    public QuantityMeasurementEntity(String operation, String operand1, String operand2,
                                     String result) {
        this.operation = operation;
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.result = result;
    }

    public QuantityMeasurementEntity(String errorMessage) {
        this.error = errorMessage;
    }

    @PrePersist
    public void PrePersist(){ createdAt = LocalDateTime.now(); }

    public boolean hasError(){ return error != null; }

    public String getOperation(){return operation; }

    public String getOperand1(){ return operand1; } 

    public String getOperand2(){ return operand2;}

    public String getResult(){return result;}

    public String getError(){ return error;}
}
