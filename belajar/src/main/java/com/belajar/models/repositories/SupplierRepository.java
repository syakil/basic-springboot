package com.belajar.models.repositories;

import com.belajar.models.entities.Supplier;
import org.springframework.data.repository.CrudRepository;

public interface SupplierRepository extends CrudRepository<Supplier,Long> {
}
