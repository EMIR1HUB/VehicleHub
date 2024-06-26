package com.suleimanov.vehiclecontrol.vehicle.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.suleimanov.vehiclecontrol.security.models.Auditable;
import com.suleimanov.vehiclecontrol.parameters.models.Supplier;
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
public class VehicleMaintenance extends Auditable<String> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;

  @ManyToOne
  @JoinColumn(name="vehicleid", insertable=false, updatable=false)
  private Vehicle vehicle;
  private Long vehicleid;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date startDate;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date endDate;

  @ManyToOne
  @JoinColumn(name="supplierid", insertable=false, updatable=false)
  private Supplier supplier;
  private Long supplierid;

  private String price;
  private String remarks;
}
