package com.alten;

import org.junit.Rule;
import org.junit.rules.ErrorCollector;

public abstract class TestCommon {

    protected static final String VEHICLES_WS = "http://localhost:8083/vehicles/status";
    protected static final String USERS_WS = "http://localhost:8081/users";

    @Rule
    public final ErrorCollector collector = new ErrorCollector();
}

