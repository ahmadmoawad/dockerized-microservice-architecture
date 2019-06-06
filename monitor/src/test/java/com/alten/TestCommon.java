package com.alten;

import com.alten.dto.VehicleStatusDto;
import com.alten.entity.VehicleStatus;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;

public abstract class TestCommon {

    protected static final long ID = 7823200L;
    protected static final String VEHICLE_ID = "83y27233";
    protected static final String VEHICLE_WS = "/vehicles/status";

    @Rule
    public final ErrorCollector collector = new ErrorCollector();

    protected static VehicleStatus createVehicleStatus() {
        VehicleStatus localStatus = new VehicleStatus();
        localStatus.setId(ID);
        localStatus.setVehicleId(VEHICLE_ID);
        localStatus.setStatus(true);
        return localStatus;
    }

    protected static VehicleStatusDto createVehicleStatusDto() {
        VehicleStatusDto localDto = new VehicleStatusDto();
        localDto.setVehicleId(VEHICLE_ID);
        localDto.setStatus(true);
        return localDto;
    }
}

