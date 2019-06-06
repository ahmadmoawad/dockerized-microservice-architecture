package com.alten.entity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class VehicleTest {

    private static final long ID = 832L;
    private static final long ID_2 = 7801231L;
    private static final String VEHICLE_ID = "7832";
    private static final String REGULAR_NUMBER = "8932";
    private static final String VEHICLE_ID_2 = "78Q23G423";
    private static final String REGULAR_NUMBER_2 = "78234JK2B323";

    @Rule
    public final ErrorCollector collector = new ErrorCollector();

    @Test
    public void givenDifferentEmptyObjectWhenEqualsThenReturnTrue() {
        // Arrange
        Vehicle vehicle = new Vehicle();
        Vehicle vehicle2 = new Vehicle();

        // Act
        boolean actual = vehicle.equals(vehicle2);

        // Assert
        assertTrue(actual);
    }

    @Test
    public void givenDifferentObjectWhenEqualsThenReturnTrue() {
        // Arrange
        Vehicle vehicle = new Vehicle();
        vehicle.setId(ID);
        vehicle.setRegularNumber(REGULAR_NUMBER);
        vehicle.setVehicleId(VEHICLE_ID);

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setId(ID);
        vehicle2.setRegularNumber(REGULAR_NUMBER);
        vehicle2.setVehicleId(VEHICLE_ID);

        // Act
        boolean actual = vehicle.equals(vehicle2);

        // Assert
        assertTrue(actual);
    }

    @Test
    public void givenDifferentObjectWithValuesWhenEqualsThenReturnFalse() {
        // Arrange
        Vehicle vehicle = new Vehicle();
        vehicle.setId(ID);
        vehicle.setRegularNumber(REGULAR_NUMBER);
        vehicle.setVehicleId(VEHICLE_ID);

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setId(ID_2);
        vehicle2.setRegularNumber(REGULAR_NUMBER_2);
        vehicle2.setVehicleId(VEHICLE_ID_2);

        // Act
        boolean actual = vehicle.equals(vehicle2);

        // Assert
        assertFalse(actual);
    }

    @Test
    public void givenSameEmptyObjectWhenEqualsThenReturnTrue() {
        // Arrange
        Vehicle vehicle = new Vehicle();

        // Act
        boolean actual = vehicle.equals(vehicle);

        // Assert
        collector.checkThat(actual, equalTo(true));
        collector.checkThat(vehicle.hashCode(), equalTo(vehicle.hashCode()));
    }
}
