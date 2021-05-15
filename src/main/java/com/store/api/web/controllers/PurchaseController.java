package com.store.api.web.controllers;

import com.store.api.persistence.entity.Purchase;
import com.store.api.persistence.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Purchase>> getAll(){
        return new ResponseEntity<>((List<Purchase>) purchaseRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Purchase> readPurchase(@PathVariable int id){
        return purchaseRepository.findById(id)
                .map(purchase -> new ResponseEntity<>(purchase, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/create")
    public ResponseEntity<Purchase> createPurchase(@RequestBody Purchase purchase){
        return new ResponseEntity<>(purchaseRepository.save(purchase), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Purchase> updatePurchase(@PathVariable int id, @RequestBody Purchase purchase){
        Optional<Purchase> optionalPurchase = purchaseRepository.findById(id);
        if(optionalPurchase.isPresent()){
            purchase.setIdPurchase(id);
            return new ResponseEntity<>(purchaseRepository.save(purchase), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Purchase> deletePurchase(@PathVariable int id){
        boolean isPurchaseDeleted = purchaseRepository.findById(id)
                .map(purchase -> {
                    purchaseRepository.delete(purchase);
                    return true;
                })
                .orElse(false);
        return isPurchaseDeleted ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
