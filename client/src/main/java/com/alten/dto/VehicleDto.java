package com.alten.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDto implements Serializable {

    private static final long serialVersionUID = 9183049212044358123L;

    private Long id;
    private String vehicleId;
    private String regularNumber;
    private UserDto user;
}
