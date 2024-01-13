package com.suleimanov.vehiclecontrol.Services;

import com.suleimanov.vehiclecontrol.Models.Invoice;
import com.suleimanov.vehiclecontrol.Repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

  @Autowired
  private InvoiceRepository invoiceRepository;

  public List<Invoice> getInvoices(){
    return invoiceRepository.findAll();
  }

  public void save(Invoice invoice){
    invoiceRepository.save(invoice);
  }

  public Optional<Invoice> findById(Integer id){
    return invoiceRepository.findById(id);
  }

  public void delete(Integer id) {
    invoiceRepository.deleteById(id);
  }
}
