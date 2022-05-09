package com.example.tablayoutcrud.model;

public class Cat {
    private int img;
    private String name;
    private  double price;
    private String desc;

    public Cat(int img, String name, double price, String desc) {
        this.img = img;
        this.name = name;
        this.price = price;
        this.desc = desc;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
