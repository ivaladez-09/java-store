package com.store.api.persistence.repository;

import com.store.api.persistence.entity.Purchase;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseRepository extends CrudRepository<Purchase, Integer>{
}
