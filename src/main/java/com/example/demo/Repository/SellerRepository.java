package com.example.demo.Repository;

import com.example.demo.Models.Seller;

import java.util.List;

public interface SellerRepository {
    Seller read(Integer sellerId);
    List<Seller> readAll();
    void create(Seller seller);
    void update(Seller seller,Integer sellerId);
    void delete(Integer sellerId);
}