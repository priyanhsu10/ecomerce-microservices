package com.pro.inventoryservice.controllers;

import com.pro.inventoryservice.dto.InventoryRequest;
import com.pro.inventoryservice.dto.InventoryResponse;
import com.pro.inventoryservice.services.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryController {
private  final InventoryService inventoryService;
    @PostMapping
    public ResponseEntity<InventoryResponse> createInventory(@RequestBody InventoryRequest request){

     return  ResponseEntity.ok(inventoryService.createInventory(request));
    }
    @GetMapping("/all")
    public  ResponseEntity<List<InventoryResponse>> getAll(){
        return  ResponseEntity.ok(inventoryService.getAll());
    }
    @GetMapping("/skuCode")
    public  ResponseEntity<InventoryResponse> getBySkuCode(@PathVariable String skuCode){
        return  ResponseEntity.ok(inventoryService.getInventory(skuCode));
    }


}
