package com.example.demo.Repository;

import com.example.demo.Models.Manager;

import java.util.List;

public interface ManagerRepository {
    Manager read(Integer managerId);
    List<Manager> readAll();
    void create(Manager manager);
    void update(Manager manager,Integer managerId);
    void delete(Integer managerId);
}
