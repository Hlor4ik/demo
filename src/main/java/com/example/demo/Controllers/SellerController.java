package com.example.demo.Controllers;

import com.example.demo.DB;
import com.example.demo.Models.Seller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/sellers")
public class SellerController {
    @GetMapping
    public ArrayList<Seller> getSellers() {
        return DB.getSellers();
    }

    @GetMapping("/{sellerId}")
    public Seller getSeller(@PathVariable int sellerId) {
        return DB.getSeller(sellerId);
    }
}
