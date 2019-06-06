package com.alten.service.impl;

import com.alten.TestCommon;
import com.alten.dao.VehicleStatusDao;
import com.alten.dto.VehicleStatusDto;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.doReturn;

public class VehicleStatusServiceImplTest extends TestCommon {

    @Mock
    private VehicleStatusDao vehicleStatusDao;

    @InjectMocks
    private VehicleStatusServiceImpl service;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldGetUserList() {
        // Arrange
        doReturn(Collections.singletonList(createVehicleStatus())).when(vehicleStatusDao).findAll();

        // Act
        List<VehicleStatusDto> actual = service.getAll();

        // Assert
        collector.checkThat(actual.size(), equalTo(1));
        collector.checkThat(actual.get(0).getVehicleId(), equalTo(VEHICLE_ID));
    }
}
