package com.app.measurement.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "measurement_history")
public class QuantityMeasurementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String operation;
    private String operand1;
    private String operand2;
    private String result;
    private String error;

    private String userEmail;

    private LocalDateTime createdAt;

    public QuantityMeasurementEntity() {}

    public QuantityMeasurementEntity(String operation, String operand1, String operand2, String result) {
        this.operation = operation;
        this.operand1  = operand1;
        this.operand2  = operand2;
        this.result    = result;
    }

    public QuantityMeasurementEntity(String errorMessage) {
        this.error = errorMessage;
    }

    @PrePersist
    public void prePersist() { createdAt = LocalDateTime.now(); }

    public boolean hasError() { return error != null; }

    public Long getId()            { return id; }
    public String getOperation()   { return operation; }
    public String getOperand1()    { return operand1; }
    public String getOperand2()    { return operand2; }
    public String getResult()      { return result; }
    public String getError()       { return error; }
    public String getUserEmail()   { return userEmail; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
}
