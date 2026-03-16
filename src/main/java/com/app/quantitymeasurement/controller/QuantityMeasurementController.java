package com.app.quantitymeasurement.controller;

import com.app.quantitymeasurement.model.QuantityDTO;
import com.app.quantitymeasurement.model.QuantityInputDTO;
import com.app.quantitymeasurement.model.QuantityMeasurementEntity;
import com.app.quantitymeasurement.quantity.Quantity;
import com.app.quantitymeasurement.service.IQuantityMeasurementService;
import com.app.quantitymeasurement.units.LengthUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/quantities")
public class QuantityMeasurementController {

    @Autowired
    private IQuantityMeasurementService service;

    @PostMapping("/compare")
    public QuantityMeasurementEntity compare(@RequestBody QuantityInputDTO input) {

        QuantityDTO quantity1 = input.getThisQuantityDTO();
        QuantityDTO quantity2 = input.getThatQuantityDTO();

        Quantity q1 = new Quantity(quantity1.getValue(), LengthUnit.valueOf(quantity1.getUnit()));
        Quantity q2 = new Quantity(quantity2.getValue(), LengthUnit.valueOf(quantity2.getUnit()));

        return service.compare(q1, q2);
    }

    @PostMapping("/add")
    public QuantityMeasurementEntity add(@RequestBody QuantityInputDTO input) {
        QuantityDTO quantity1 = input.getThisQuantityDTO();
        QuantityDTO quantity2 = input.getThatQuantityDTO();

        Quantity q1 = new Quantity(quantity1.getValue(), LengthUnit.valueOf(quantity1.getUnit()));
        Quantity q2 = new Quantity(quantity2.getValue(), LengthUnit.valueOf(quantity2.getUnit()));

        return service.add(q1, q2);
    }

    @PostMapping("/subtract")
    public QuantityMeasurementEntity subtract(@RequestBody QuantityInputDTO input) {
        QuantityDTO quantity1 = input.getThisQuantityDTO();
        QuantityDTO quantity2 = input.getThatQuantityDTO();

        Quantity q1 = new Quantity(quantity1.getValue(), LengthUnit.valueOf(quantity1.getUnit()));
        Quantity q2 = new Quantity(quantity2.getValue(), LengthUnit.valueOf(quantity2.getUnit()));

        return service.subtract(q1, q2);
    }

    @PostMapping("/convert")
    public QuantityMeasurementEntity convert(@RequestBody QuantityInputDTO input) {
        QuantityDTO quantity1 = input.getThisQuantityDTO();
        QuantityDTO quantity2 = input.getThatQuantityDTO();

        Quantity q1 = new Quantity(quantity1.getValue(), LengthUnit.valueOf(quantity1.getUnit()));
        Quantity q2 = new Quantity(quantity2.getValue(), LengthUnit.valueOf(quantity2.getUnit()));

        return service.convert(q1, q2);
    }

    @PostMapping("/divide")
    public QuantityMeasurementEntity divide(@RequestBody QuantityInputDTO input) {
        QuantityDTO quantity1 = input.getThisQuantityDTO();
        QuantityDTO quantity2 = input.getThatQuantityDTO();

        Quantity q1 = new Quantity(quantity1.getValue(), LengthUnit.valueOf(quantity1.getUnit()));
        Quantity q2 = new Quantity(quantity2.getValue(), LengthUnit.valueOf(quantity2.getUnit()));

        return service.divide(q1, q2);
    }
}