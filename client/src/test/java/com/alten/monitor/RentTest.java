package com.alten.monitor;

import com.alten.TestCommon;
import com.alten.dto.VehicleDto;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RentTest extends TestCommon {


    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String NAME_1 = "Kalles Grustransporter AB";
    private static final String ADDRESS = "address";
    private static final String ADDRESS_1 = "Cementvägen 8, 111 11 Södertälje";
    private static final String NAME_2 = "Johans Bulk AB";
    private static final String ADDRESS_2 = "Balkvägen 12, 222 22 Stockholm";
    private static final String NAME_3 = "Haralds Värdetransporter AB";
    private static final String ADDRESS_3 = "Budgetvägen 1, 333 33 Uppsala";
    private static final String VEHICLES = "vehicles";
    private static final String VEHICLE_ID_1 = "YS2R4X20005399401";
    private static final String REGULAR_NUMBER_1 = "ABC123";
    private static final String VEHICLE_ID_2 = "VLUR4X20009093588";
    private static final String REGULAR_NUMBER_2 = "DEF456";
    private static final String VEHICLE_ID_3 = "VLUR4X20009048066";
    private static final String REGULAR_NUMBER_3 = "GHI789";
    private static final String VEHICLE_ID_4 = "YS2R4X20005388011";
    private static final String REGULAR_NUMBER_4 = "JKL012";
    private static final String VEHICLE_ID_5 = "YS2R4X20005387949";
    private static final String REGULAR_NUMBER_5 = "MNO345";
    private static final String REGULAR_NUMBER_6 = "PQR678";
    private static final String VEHICLE_ID_7 = "YS2R4X20005387055";
    private static final String REGULAR_NUMBER_7 = "STU901";

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void shouldGetUsers() {
        // Arrange
        Gson gson = new Gson();

        // Act & Assert
        ResponseEntity<List> exchange = restTemplate.getForEntity(USERS_WS, List.class);
        List<Map<Object, Object>> actualDto = exchange.getBody();
        collector.checkThat(actualDto.size(), equalTo(3));
        collector.checkThat(actualDto.get(0).get(ID), equalTo("1"));
        collector.checkThat(actualDto.get(0).get(NAME), equalTo(NAME_1));
        collector.checkThat(actualDto.get(0).get(ADDRESS), equalTo(ADDRESS_1));
        VehicleDto[] vehicleDtos = gson.fromJson(actualDto.get(0).get(VEHICLES).toString(), VehicleDto[].class);
        collector.checkThat(vehicleDtos.length, equalTo(3));
        collector.checkThat(vehicleDtos[0].getId(), equalTo(1L));
        collector.checkThat(vehicleDtos[0].getVehicleId(), equalTo(VEHICLE_ID_1));
        collector.checkThat(vehicleDtos[0].getRegularNumber(), equalTo(REGULAR_NUMBER_1));
        collector.checkThat(vehicleDtos[1].getId(), equalTo(2L));
        collector.checkThat(vehicleDtos[1].getVehicleId(), equalTo(VEHICLE_ID_2));
        collector.checkThat(vehicleDtos[1].getRegularNumber(), equalTo(REGULAR_NUMBER_2));
        collector.checkThat(vehicleDtos[2].getId(), equalTo(3L));
        collector.checkThat(vehicleDtos[2].getVehicleId(), equalTo(VEHICLE_ID_3));
        collector.checkThat(vehicleDtos[2].getRegularNumber(), equalTo(REGULAR_NUMBER_3));

        collector.checkThat(actualDto.get(1).get(ID), equalTo("2"));
        collector.checkThat(actualDto.get(1).get(NAME), equalTo(NAME_2));
        collector.checkThat(actualDto.get(1).get(ADDRESS), equalTo(ADDRESS_2));
        VehicleDto[] vehicleDtos2 = gson.fromJson(actualDto.get(1).get(VEHICLES).toString(), VehicleDto[].class);
        collector.checkThat(vehicleDtos2.length, equalTo(2));
        collector.checkThat(vehicleDtos2[0].getId(), equalTo(4L));
        collector.checkThat(vehicleDtos2[0].getVehicleId(), equalTo(VEHICLE_ID_4));
        collector.checkThat(vehicleDtos2[0].getRegularNumber(), equalTo(REGULAR_NUMBER_4));
        collector.checkThat(vehicleDtos2[1].getId(), equalTo(5L));
        collector.checkThat(vehicleDtos2[1].getVehicleId(), equalTo(VEHICLE_ID_5));
        collector.checkThat(vehicleDtos2[1].getRegularNumber(), equalTo(REGULAR_NUMBER_5));

        collector.checkThat(actualDto.get(2).get(ID), equalTo("3"));
        collector.checkThat(actualDto.get(2).get(NAME), equalTo(NAME_3));
        collector.checkThat(actualDto.get(2).get(ADDRESS), equalTo(ADDRESS_3));
        VehicleDto[] vehicleDtos3 = gson.fromJson(actualDto.get(2).get(VEHICLES).toString(), VehicleDto[].class);
        collector.checkThat(vehicleDtos3.length, equalTo(2));
        collector.checkThat(vehicleDtos3[0].getId(), equalTo(6L));
        collector.checkThat(vehicleDtos3[0].getVehicleId(), equalTo(VEHICLE_ID_3));
        collector.checkThat(vehicleDtos3[0].getRegularNumber(), equalTo(REGULAR_NUMBER_6));
        collector.checkThat(vehicleDtos3[1].getId(), equalTo(7L));
        collector.checkThat(vehicleDtos3[1].getVehicleId(), equalTo(VEHICLE_ID_7));
        collector.checkThat(vehicleDtos3[1].getRegularNumber(), equalTo(REGULAR_NUMBER_7));
    }
}
