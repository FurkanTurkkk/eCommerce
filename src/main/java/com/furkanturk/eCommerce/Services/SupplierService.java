package com.furkanturk.eCommerce.Services;


import com.furkanturk.eCommerce.Models.Supplier;
import com.furkanturk.eCommerce.Repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    public Optional<List<Supplier>> getAllSuppliers(){
        List<Supplier> suppliers=supplierRepository.findAll();
        if(suppliers.isEmpty()){
            return Optional.empty();
        }
        else {
            return Optional.of(suppliers);
        }
    }

    public Optional<Supplier> getSupplierById(Long id) {
        return supplierRepository.findById(id);
    }

    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }

    public Supplier addSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }
}
