package com.alten.entity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class VehicleStatusTest {

    private static final long ID = 78323290L;
    private static final String VEHICLE_ID = "v89y2332";

    @Rule
    public final ErrorCollector collector = new ErrorCollector();

    @Test
    public void givenDifferentEmptyObjectWhenEqualsThenReturnTrue() {
        // Arrange
        VehicleStatus VehicleStatus = new VehicleStatus();
        VehicleStatus VehicleStatus2 = new VehicleStatus();

        // Act
        boolean actual = VehicleStatus.equals(VehicleStatus2);

        // Assert
        assertTrue(actual);
    }

    @Test
    public void givenDifferentObjectWhenEqualsThenReturnTrue() {
        // Arrange
        VehicleStatus vehicleStatus = new VehicleStatus();
        vehicleStatus.setId(ID);
        vehicleStatus.setStatus(true);
        vehicleStatus.setVehicleId(VEHICLE_ID);
        VehicleStatus vehicleStatus2 = new VehicleStatus();
        vehicleStatus2.setId(ID);
        vehicleStatus2.setStatus(true);
        vehicleStatus2.setVehicleId(VEHICLE_ID);

        // Act
        boolean actual = vehicleStatus.equals(vehicleStatus2);

        // Assert
        assertTrue(actual);
    }

    @Test
    public void givenDifferentObjectAndValueWhenEqualsThenReturnFalse() {
        // Arrange
        VehicleStatus vehicleStatus = new VehicleStatus();
        vehicleStatus.setId(ID);
        vehicleStatus.setStatus(true);
        vehicleStatus.setVehicleId(VEHICLE_ID);
        VehicleStatus vehicleStatus2 = new VehicleStatus();
        vehicleStatus2.setId(ID);
        vehicleStatus2.setStatus(false);
        vehicleStatus2.setVehicleId(VEHICLE_ID);

        // Act
        boolean actual = vehicleStatus.equals(vehicleStatus2);

        // Assert
        assertFalse(actual);
    }

    @Test
    public void givenSameEmptyObjectWhenEqualsThenReturnTrue() {
        // Arrange
        VehicleStatus VehicleStatus = new VehicleStatus();

        // Act
        boolean actual = VehicleStatus.equals(VehicleStatus);

        // Assert
        collector.checkThat(actual, equalTo(true));
        collector.checkThat(VehicleStatus.hashCode(), equalTo(VehicleStatus.hashCode()));
    }
}
