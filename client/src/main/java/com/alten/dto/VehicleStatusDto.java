package com.alten.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleStatusDto implements Serializable {

    private static final long serialVersionUID = 1966222530142848069L;

    private String vehicleId;
    private boolean status;
}
