package com.example.demo.Models;

public record Manager(Integer managerId, String firstname, String lastname, String email,String birthday, Gender gender) {
    public enum Gender {
        MALE,
        FEMALE
    }
}
//enum сделать на пол,arraylist убрать,фамилия и имя одними названиями,дату рождения накинуть