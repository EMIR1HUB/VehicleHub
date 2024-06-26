package com.suleimanov.vehiclecontrol.vehicle.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.suleimanov.vehiclecontrol.parameters.models.Location;
import com.suleimanov.vehiclecontrol.security.models.Auditable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class VehicleMovement extends Auditable<String> {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehicle_movement_seq_generator")
  @SequenceGenerator(name = "vehicle_movement_seq_generator", sequenceName = "vehicle_movement_seq", initialValue = 10)
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;

  @ManyToOne
  @JoinColumn(name="vehicleid", insertable=false, updatable=false)
  private Vehicle vehicle;
  private Long vehicleid;

  @ManyToOne
  @JoinColumn(name="locationid1", insertable=false, updatable=false)
  private Location location1;
  private Long locationid1;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date date1;

  @ManyToOne
  @JoinColumn(name="locationid2", insertable=false, updatable=false)
  private Location location2;
  private Long locationid2;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date date2;

  private String remarks;


}
