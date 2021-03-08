package com.mj.restaurantapp;

public class Foodmenu {
    private  String foodname;
    private  String price;
    private  String foodtype;


    public Foodmenu(String foodname,String price,String foodtype)
    {
        this.foodname=foodname;
        this.price=price;
        this.foodtype=foodtype;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public void setFoodtype(String foodtype) {
        this.foodtype = foodtype;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getPrice() {
        return price;
    }
    public String getFoodtype() {
        return foodtype;
    }

}
