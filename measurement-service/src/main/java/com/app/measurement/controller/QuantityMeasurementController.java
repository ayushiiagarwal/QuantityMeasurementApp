package com.app.measurement.controller;

import com.app.measurement.model.QuantityInputDTO;
import com.app.measurement.model.QuantityMeasurementEntity;
import com.app.measurement.model.QuantityModel;
import com.app.measurement.quantity.Quantity;
import com.app.measurement.service.IQuantityMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quantities")
public class QuantityMeasurementController {

    @Autowired
    private IQuantityMeasurementService service;

    @PostMapping("/compare")
    public QuantityMeasurementEntity compare(@RequestBody QuantityInputDTO input,
                                             @RequestHeader(value = "X-User-Email", required = false) String userEmail) {
        Quantity<?> q1 = QuantityModel.toQuantity(input.getThisQuantityDTO());
        Quantity<?> q2 = QuantityModel.toQuantity(input.getThatQuantityDTO());
        return service.compare(q1, q2, userEmail);
    }

    @PostMapping("/add")
    public QuantityMeasurementEntity add(@RequestBody QuantityInputDTO input,
                                         @RequestHeader(value = "X-User-Email", required = false) String userEmail) {
        Quantity<?> q1 = QuantityModel.toQuantity(input.getThisQuantityDTO());
        Quantity<?> q2 = QuantityModel.toQuantity(input.getThatQuantityDTO());
        return service.add(q1, q2, userEmail);
    }

    @PostMapping("/subtract")
    public QuantityMeasurementEntity subtract(@RequestBody QuantityInputDTO input,
                                              @RequestHeader(value = "X-User-Email", required = false) String userEmail) {
        Quantity<?> q1 = QuantityModel.toQuantity(input.getThisQuantityDTO());
        Quantity<?> q2 = QuantityModel.toQuantity(input.getThatQuantityDTO());
        return service.subtract(q1, q2, userEmail);
    }

    @PostMapping("/convert")
    public QuantityMeasurementEntity convert(@RequestBody QuantityInputDTO input,
                                             @RequestHeader(value = "X-User-Email", required = false) String userEmail) {
        Quantity<?> q1 = QuantityModel.toQuantity(input.getThisQuantityDTO());
        Quantity<?> q2 = QuantityModel.toQuantity(input.getThatQuantityDTO());
        return service.convert(q1, q2, userEmail);
    }

    @PostMapping("/divide")
    public QuantityMeasurementEntity divide(@RequestBody QuantityInputDTO input,
                                            @RequestHeader(value = "X-User-Email", required = false) String userEmail) {
        Quantity<?> q1 = QuantityModel.toQuantity(input.getThisQuantityDTO());
        Quantity<?> q2 = QuantityModel.toQuantity(input.getThatQuantityDTO());
        return service.divide(q1, q2, userEmail);
    }
}
