package com.alten;

import com.alten.entity.User;
import com.alten.entity.Vehicle;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;

import java.util.Collections;

public abstract class TestCommon {

    protected static final Long VEHICLE_ID = 392L;
    protected static final String ID = "89234";
    protected static final String NAME = "jack";
    protected static final String ADDRESS = "Sweden";
    protected static final String REGULAR_NUMBER = "89y2342";
    protected static final String VEHICLE_ID_STRING = "83y27233";
    protected static final String USERS_WS = "/users";

    @Rule
    public final ErrorCollector collector = new ErrorCollector();

    protected static User createUser() {
        User localUser = new User();
        localUser.setId(ID);
        localUser.setName(NAME);
        localUser.setAddress(ADDRESS);
        localUser.setVehicles(Collections.singletonList(createVehicles(localUser)));
        return localUser;
    }

    protected static Vehicle createVehicles(User localUser) {
        Vehicle localVehicle = new Vehicle();
        localVehicle.setId(VEHICLE_ID);
        localVehicle.setRegularNumber(REGULAR_NUMBER);
        localVehicle.setVehicleId(VEHICLE_ID_STRING);
        localVehicle.setUser(localUser);
        return localVehicle;
    }
}
