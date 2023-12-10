package com.example.demo.Controllers;

import com.example.demo.DB;
import com.example.demo.Models.Seller;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SellerController {
    @GetMapping
    @RequestMapping("/sellers")
    public List<Seller> getSellers() {
        return DB.getSellers();
    }

    @GetMapping("/sellers/{sellerId}")
    public Seller getSeller(@PathVariable int sellerId) {
        return DB.getSeller(sellerId);
    }
    @PostMapping("/sellers")
    @ResponseStatus(HttpStatus.CREATED)
    public Seller addSeller(@RequestBody Seller seller) {
        return DB.addSeller(seller);
    }
    @DeleteMapping("/sellers/{sellerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Seller deleteSeller(@PathVariable int sellerId) {
        return DB.deleteSeller(sellerId);
    }
    @PutMapping("/sellers/{sellerId}")
    public static void updateSeller(@PathVariable int sellerId, @RequestBody Seller seller) {
        DB.updateSeller(seller,sellerId);
    }
}
