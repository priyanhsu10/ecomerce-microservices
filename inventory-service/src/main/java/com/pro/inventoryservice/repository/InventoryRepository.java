package com.pro.inventoryservice.repository;

import com.pro.inventoryservice.dto.InventoryResponse;
import com.pro.inventoryservice.entities.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends MongoRepository<Inventory,String> {

    InventoryResponse findBySkuCode(String skuCode);
@Query("select e from Inventory e where e.skuCode in (:skuCodes)")
    List<InventoryResponse> findAllInSkuCode(List<String> skuCodes);
}
