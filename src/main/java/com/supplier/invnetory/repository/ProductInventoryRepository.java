package com.supplier.invnetory.repository;

import com.supplier.invnetory.entities.ProductInventory;
import com.supplier.invnetory.entities.ProductInventoryId;
import org.springframework.data.repository.CrudRepository;

public interface ProductInventoryRepository extends CrudRepository<ProductInventory,ProductInventoryId> {
}
