package com.alten.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = -4798896526287954330L;

    private String id;
    private String name;
    private String address;
    private List<Vehicle> vehicles;
}
