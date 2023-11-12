package com.example.demo.Controllers;

import com.example.demo.DB;
import com.example.demo.Models.Manager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/managers")
public class ManagerController {
    @GetMapping
    public ArrayList<Manager> getManagers() {
        return DB.getManagers();
    }

    @GetMapping("/{managerId}")
    public Manager getManager(@PathVariable int managerId) {
        return DB.getManager(managerId);
    }
}
