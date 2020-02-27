package com.example.finalproject;

public class Doctor {
    private String Name;
    private String phone;
    private int photo;

    public Doctor(String name, String phone, int photo) {
        Name = name;
        this.phone = phone;
        this.photo = photo;
    }


    //getter

    public String getName() {
        return Name;
    }

    public String getPhone() {
        return phone;
    }

    public int getPhoto() {
        return photo;
    }

    //setter

    public void setName(String name) {
        Name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
