package com.example.demo.Controllers;

import com.example.demo.Models.Seller;
import com.example.demo.Repository.SellerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/sellers")
@RestController
public class SellerController {
    private final SellerRepository sellerRepository;
    public SellerController(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }
    @GetMapping
    public List<Seller> getSellers() {
        return sellerRepository.readAll();
    }

    @GetMapping("/{sellerId}")
    public Seller getSeller(@PathVariable int sellerId) {
        return sellerRepository.read(sellerId);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Seller seller) {
         sellerRepository.create(seller);
    }
    @DeleteMapping("/{sellerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSeller(@PathVariable("sellerId") int sellerId) {
        sellerRepository.delete(sellerId);
    }
    @PutMapping("/{sellerId}")
    public void updateSeller(@PathVariable("sellerId") int sellerId, @RequestBody Seller seller) {
        sellerRepository.update(seller,sellerId);
    }
}
