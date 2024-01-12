package com.suleimanov.vehiclecontrol.Services;

import com.suleimanov.vehiclecontrol.Models.VehicleModel;
import com.suleimanov.vehiclecontrol.Repositories.VehicleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleModelService {

  @Autowired
  private VehicleModelRepository vehicleModelRepository;

  public List<VehicleModel> getVehiclesModels(){
    return vehicleModelRepository.findAll();
  }

  public void save(VehicleModel vehicleModel){
    vehicleModelRepository.save(vehicleModel);
  }

  public Optional<VehicleModel> findById(Integer id){
    return vehicleModelRepository.findById(id);
  }

  public void delete(Integer id) {
    vehicleModelRepository.deleteById(id);
  }
}