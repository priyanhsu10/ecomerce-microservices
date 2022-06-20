package com.pro.inventoryservice.services;

import com.pro.inventoryservice.dto.InventoryRequest;
import com.pro.inventoryservice.dto.InventoryResponse;
import com.pro.inventoryservice.entities.Inventory;
import com.pro.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public InventoryResponse getInventory(String skuCode) {
        return inventoryRepository.findBySkuCode(skuCode);
    }

    public InventoryResponse createInventory(InventoryRequest request) {
        Inventory i = Inventory.builder().quantity(request.getQuantity()).skuCode(request.getSkuCode()).build();

        inventoryRepository.save(i);
        return InventoryResponse.builder().skuCode(i.getSkuCode()).quantity(i.getQuantity()).build();

    }

    public List<InventoryResponse> getAll() {
    return inventoryRepository.findAll().stream().map(x-> mapToResponse(x)).collect(Collectors.toList());
    }

    private InventoryResponse mapToResponse(Inventory in) {
        return  InventoryResponse.builder().skuCode(in.getSkuCode()).quantity(in.getQuantity()).build();
    }

    public List<InventoryResponse> getInventoryByskucode(List<String> skuCodes) {
       return inventoryRepository.findAllInSkuCode(skuCodes);
    }
}
