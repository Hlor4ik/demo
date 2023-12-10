package com.example.demo;

import com.example.demo.Models.Manager;
import com.example.demo.Models.Seller;

import java.util.ArrayList;
import java.util.List;

public class DB {
    static List<Manager> managers = new ArrayList<>();
    static List<Seller> sellers = new ArrayList<>();

    static {
        Seller seller1 = new Seller(1, 1, "Влад", "Артемов", "89032135600", 50000);
        sellers.add(seller1);
        Seller seller2 = new Seller(2, 2, "Никита", "Огруцов", "89095439041", 65000);
        sellers.add(seller2);
        Manager manager1 = new Manager(1, "Дмитрий", "Хорошилов", "khoroshilov.545@gmail.com", "28.11.2000", Manager.Gender.MALE);
        managers.add(manager1);
        Manager manager2 = new Manager(2, "Михаил", "Арбузов", "michaelarb111@gmail.com", "04.12.2001",Manager.Gender.MALE);
        managers.add(manager2);
    }

    public static List<Seller> getSellers() {
        return sellers;
    }

    public static List<Manager> getManagers() {
        return managers;
    }

    public static Seller getSeller(int sellerId) {
        return sellers
                .stream()
                .filter(x -> x.sellerId() == sellerId)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Seller not found"));
    }

    public static Manager getManager(int managerId) {
        return managers
                .stream()
                .filter(x -> x.managerId() == managerId)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Manager not found"));
    }

    public static Manager addManager(Manager manager) {
        // Добавляем нового менеджера в список
        managers.add(manager);
        return manager;
    }

    public static Manager deleteManager(int managerId) {
        Manager managerToDelete = managers.stream()
                .filter(m -> m.managerId() == managerId)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Manager not found"));
        managers.remove(managerToDelete);
        return managerToDelete;
    }

    public static void updateManager(Manager manager, int managerId) {
        var exist = getManager(managerId);
        managers.remove(exist);
        managers.add(manager);
    }

    public static Seller addSeller(Seller seller) {
        // Добавляем нового менеджера в список
        sellers.add(seller);
        return seller;
    }

    public static Seller deleteSeller(int sellerId) {
        Seller sellerToDelete = sellers.stream()
                .filter(m -> m.sellerId() == sellerId)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Seller not found"));
        sellers.remove(sellerToDelete);
        return sellerToDelete;
    }

    public static void updateSeller(Seller seller, int sellerId) {
        var exist = getSeller(sellerId);
        sellers.remove(exist);
        sellers.add(seller);
    }
}
