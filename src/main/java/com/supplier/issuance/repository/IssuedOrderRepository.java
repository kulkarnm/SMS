package com.supplier.issuance.repository;

import com.supplier.invnetory.entities.ProductInventory;
import com.supplier.invnetory.entities.ProductInventoryId;
import com.supplier.issuance.entities.IssuedOrder;
import com.supplier.issuance.entities.IssuedOrderId;
import org.springframework.data.repository.CrudRepository;

public interface IssuedOrderRepository extends CrudRepository<IssuedOrder,IssuedOrderId> {
}
