package com.suleimanov.vehiclecontrol.vehicle.repositories;

import com.suleimanov.vehiclecontrol.vehicle.models.VehicleMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleMovementRepository extends JpaRepository<VehicleMovement, Integer> {

}
