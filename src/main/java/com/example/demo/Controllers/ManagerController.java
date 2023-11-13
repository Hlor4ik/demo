package com.example.demo.Controllers;

import com.example.demo.DB;
import com.example.demo.Models.Manager;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ManagerController {
    @GetMapping("/managers")
    public ArrayList<Manager> getManagers() {
        return DB.getManagers();
    }

    @GetMapping("/managers/{managerId}")
    public Manager getManager(@PathVariable int managerId) {
        return DB.getManager(managerId);
    }

    @PostMapping("/managers")
    @ResponseStatus(HttpStatus.CREATED)
    public Manager addManager(@RequestBody Manager manager) {
        return DB.addManager(manager);
    }
    @DeleteMapping("/managers/{managerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Manager deleteManager(@PathVariable int managerId) {
       return DB.deleteManager(managerId);
    }
    @PutMapping("/managers/{managerId}")
    public static void updateManager(@PathVariable int managerId, @RequestBody Manager manager) {
         DB.updateManager(manager,managerId);
    }


}
