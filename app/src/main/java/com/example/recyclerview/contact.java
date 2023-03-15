package com.example.recyclerview;

public class contact {
    int img;
    String name, number;

    public contact(int img, String name, String number) {
        this.img = img;
        this.name = name;
        this.number = number;
    }

    public  contact(String name,String number){
        this.name =name;
        this.number=number;
    }
}

