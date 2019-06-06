package com.alten.controller;

import com.alten.dto.VehicleStatusDto;
import com.alten.service.VehicleStatusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MonitorController {

    private VehicleStatusService service;

    public MonitorController(VehicleStatusService service) {
        this.service = service;
    }

    @RequestMapping(value = "/vehicles/status", method = RequestMethod.GET)
    public ResponseEntity<List<VehicleStatusDto>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
}
