package com.alten.controller;


import com.alten.TestCommon;
import com.alten.entity.User;
import com.alten.service.RentService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class RentControllerTest extends TestCommon {

    private MockMvc mockMvc;

    @Mock
    private RentService rentService;

    @InjectMocks
    private RentController rentController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(rentController).build();
    }

    @Test
    public void shouldGetUsers() throws Exception {
        // Arrange
        List<User> users = Collections.singletonList(createUser());
        doReturn(users).when(rentService).getAll();

        // Act & Assert
        mockMvc.perform(get(USERS_WS))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", Matchers.is(ID)))
                .andExpect(jsonPath("$[0].name", Matchers.is(NAME)))
                .andExpect(jsonPath("$[0].address", Matchers.is(ADDRESS)))
                .andExpect(jsonPath("$[0].vehicles", hasSize(1)))
                .andExpect(jsonPath("$[0].vehicles[0].id", Matchers.is(VEHICLE_ID.intValue())))
                .andExpect(jsonPath("$[0].vehicles[0].regularNumber", Matchers.is(REGULAR_NUMBER)))
                .andExpect(jsonPath("$[0].vehicles[0].vehicleId", Matchers.is(VEHICLE_ID_STRING)))
                .andExpect(status().isOk());
    }
}
