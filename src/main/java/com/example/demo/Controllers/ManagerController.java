package com.example.demo.Controllers;

import com.example.demo.Models.Manager;
import com.example.demo.Repository.ManagerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/managers")
public class ManagerController {
    private final ManagerRepository managerRepository;
    public ManagerController(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }
    @GetMapping
    public List<Manager> getManagers() {
        return managerRepository.readAll();
    }

    @GetMapping("/{managerId}")
    public Manager getManager(@PathVariable int managerId) {
        return managerRepository.read(managerId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Manager manager) {
        managerRepository.create(manager);
    }
    @DeleteMapping("/{managerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteManager(@PathVariable("managerId") int managerId) {
        managerRepository.delete(managerId);
    }
    @PutMapping("/{managerId}")
    public void updateManager(@PathVariable("managerId") int managerId, @RequestBody Manager manager) {
        managerRepository.update(manager,managerId);
    }


}
