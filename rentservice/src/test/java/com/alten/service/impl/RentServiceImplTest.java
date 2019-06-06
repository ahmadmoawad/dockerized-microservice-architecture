package com.alten.service.impl;

import com.alten.TestCommon;
import com.alten.dao.UserDao;
import com.alten.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.doReturn;

public class RentServiceImplTest extends TestCommon {

    @Mock
    private UserDao userDao;

    @InjectMocks
    private RentServiceImpl service;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldGetUserList() {
        // Arrange
        doReturn(Collections.singletonList(createUser())).when(userDao).findAll();

        // Act
        List<User> actual = service.getAll();

        // Assert
        collector.checkThat(actual.size(), equalTo(1));
        collector.checkThat(actual.get(0).getId(), equalTo(ID));
        collector.checkThat(actual.get(0).getAddress(), equalTo(ADDRESS));
        collector.checkThat(actual.get(0).getName(), equalTo(NAME));
        collector.checkThat(actual.get(0).getVehicles().size(), equalTo(1));
        collector.checkThat(actual.get(0).getVehicles().get(0).getUser(), equalTo(actual.get(0)));
        collector.checkThat(actual.get(0).getVehicles().get(0).getRegularNumber(), equalTo(REGULAR_NUMBER));
        collector.checkThat(actual.get(0).getVehicles().get(0).getVehicleId(), equalTo(VEHICLE_ID_STRING));
        collector.checkThat(actual.get(0).getVehicles().get(0).getId(), equalTo(VEHICLE_ID));
    }
}
