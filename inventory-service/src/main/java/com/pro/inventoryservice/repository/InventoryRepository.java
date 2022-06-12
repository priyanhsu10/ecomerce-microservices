package com.pro.inventoryservice.repository;

import com.pro.inventoryservice.dto.InventoryResponse;
import com.pro.inventoryservice.entities.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends MongoRepository<Inventory,String> {

    InventoryResponse findBySkuCode(String skuCode);
}
