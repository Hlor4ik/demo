package com.example.demo;

import com.example.demo.Models.Manager;
import com.example.demo.Models.Seller;

import java.util.ArrayList;
import java.util.Arrays;

public class DB {
    static ArrayList<Manager> managers=new ArrayList<>();
    static ArrayList<Seller> sellers=new ArrayList<>();
    static {
        Seller seller1=new Seller(1,"Влад","Артемов","89032135600",50000);
        sellers.add(seller1);
        Seller seller2=new Seller(2,"Никита","Огруцов","89095439041",65000);
        sellers.add(seller2);
        Manager manager1=new Manager(1,1,"Дмитрий","Хорошилов","khoroshilov.545@gmail.com",true);
        managers.add(manager1);
        Manager manager2=new Manager(2,2,"Михаил","Арбузов","michaelarb111@gmail.com",true);
        managers.add(manager2);
    }
    public static ArrayList<Seller> getSellers(){
        return sellers;
    }
    public static ArrayList<Manager> getManagers(){
        return managers;
    }
    public static Seller getSeller(int sellerId){
        return sellers
                .stream()
                .filter(x->x.sellerId()==sellerId)
                .findAny()
                .orElseThrow(()->new IllegalArgumentException("Seller not found"));
    }
    public static  Manager getManager(int managerId){
        return managers
                .stream()
                .filter(x->x.managerId()==managerId)
                .findAny()
                .orElseThrow(()->new IllegalArgumentException("Manager not found"));
    }
}
