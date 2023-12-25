package com.suleimanov.vehiclecontrol.Repositories;

import com.suleimanov.vehiclecontrol.Models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

}