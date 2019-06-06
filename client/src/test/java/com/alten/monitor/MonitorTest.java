package com.alten.monitor;

import com.alten.TestCommon;
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
public class MonitorTest extends TestCommon {

    private static final String VEHICLE_ID = "vehicleId";
    private static final String ID_1 = "YS2R4X20005399401";
    private static final String ID_2 = "VLUR4X20009093588";
    private static final String ID_3 = "VLUR4X20009048066";
    private static final String ID_4 = "YS2R4X20005388011";
    private static final String ID_5 = "YS2R4X20005387949";
    private static final String ID_6 = "YS2R4X20005387055";

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void shouldGetStatus() {
        // Act & Assert
        ResponseEntity<List> exchange = restTemplate.getForEntity(VEHICLES_WS, List.class);
        List<Map<Object, Object>> actualDto = exchange.getBody();
        collector.checkThat(actualDto.size(), equalTo(6));
        collector.checkThat(actualDto.get(0).get(VEHICLE_ID), equalTo(ID_1));
        collector.checkThat(actualDto.get(1).get(VEHICLE_ID), equalTo(ID_2));
        collector.checkThat(actualDto.get(2).get(VEHICLE_ID), equalTo(ID_3));
        collector.checkThat(actualDto.get(3).get(VEHICLE_ID), equalTo(ID_4));
        collector.checkThat(actualDto.get(4).get(VEHICLE_ID), equalTo(ID_5));
        collector.checkThat(actualDto.get(5).get(VEHICLE_ID), equalTo(ID_6));
    }
}
