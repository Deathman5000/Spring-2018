package com.example.jh949711.phonebook;

public class Product {
    private int id;
    private String firstName, lastName, number;
//    private int number;


    public Product(){

    }
    public Product(String s, String q, String n){
        firstName = s;
        lastName = q;
        number = n;
    }

    public Product(int id, String s, String q, String n){
        firstName = s;
        lastName = q;
        number = n;
        this.id = id;
    }

    public void setId(int i){
        id = i;
    }
    public void setFirstName(String s){
        firstName = s;
    }

    public  void setLastName(String q){
        lastName = q;
    }

    public void setNumber(String n){
        number = n;
    }

    public int getId(){
        return id;
    }

    public String getFirstName(){
        return firstName;
    }

    public  String getLastName(){
        return lastName;
    }

    public String getPNumber(){
        return number;
    }
}
