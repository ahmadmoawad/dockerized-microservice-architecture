package com.alten.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Data
@Entity(name = "vehicle_status")
@NoArgsConstructor
@AllArgsConstructor
public class VehicleStatus implements Serializable {

    private static final long serialVersionUID = 9183049212044358123L;

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    @Column(name = "vehicle_id")
    private String vehicleId;
    @NonNull
    @Column
    private Boolean status;
}
