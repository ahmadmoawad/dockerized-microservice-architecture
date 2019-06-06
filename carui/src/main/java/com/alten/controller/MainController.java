package com.alten.controller;

import com.alten.dto.User;
import com.alten.dto.VehicleStatusDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class MainController {

    private static final String HTTP_RENT_SERVICE_USERS = "http://rent-service/users";
    private static final String HTTP_STATUS_SERVICE = "http://monitor-service/vehicles/status";

    private final RestTemplate restTemplate;

    public MainController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/")
    public String main(Model model) {
        ResponseEntity<List<User>> userResponse = restTemplate.exchange(HTTP_RENT_SERVICE_USERS, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
        });
        ResponseEntity<List<VehicleStatusDto>> vehicleResponse = restTemplate.exchange(HTTP_STATUS_SERVICE, HttpMethod.GET, null, new ParameterizedTypeReference<List<VehicleStatusDto>>() {
        });

        model.addAttribute("users", userResponse.getBody());
        return "index";
    }

    @RequestMapping("/status")
    public ResponseEntity<List<VehicleStatusDto>> status() {
        ResponseEntity<List<VehicleStatusDto>> vehicleResponse = restTemplate.exchange(HTTP_STATUS_SERVICE, HttpMethod.GET, null, new ParameterizedTypeReference<List<VehicleStatusDto>>() {
        });

        return vehicleResponse;
    }
}
