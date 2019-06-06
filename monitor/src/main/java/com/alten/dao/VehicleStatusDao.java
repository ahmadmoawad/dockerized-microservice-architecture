package com.alten.dao;

import com.alten.entity.VehicleStatus;
import org.springframework.data.repository.CrudRepository;

public interface VehicleStatusDao extends CrudRepository<VehicleStatus, Long> {
}
