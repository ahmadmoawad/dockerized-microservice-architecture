package com.alten.service.impl;

import com.alten.dao.VehicleStatusDao;
import com.alten.dto.VehicleStatusDto;
import com.alten.entity.VehicleStatus;
import com.alten.service.VehicleStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleStatusServiceImpl implements VehicleStatusService {

    @Autowired
    private VehicleStatusDao userDao;

    @Override
    public List<VehicleStatusDto> getAll() {
        Iterable<VehicleStatus> vehicleStatuses = userDao.findAll();
        List<VehicleStatusDto> dtos = new ArrayList<>();
        vehicleStatuses.forEach(e -> {
            VehicleStatusDto dto = new VehicleStatusDto();
            dto.setStatus(Math.round(Math.random()) == 1);
            dto.setVehicleId(e.getVehicleId());
            dtos.add(dto);
        });
        return dtos;
    }
}
