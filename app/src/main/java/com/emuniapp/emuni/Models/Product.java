package com.emuniapp.emuni.Models;

public class Product {
    private String id;
    private String cat_id;
    private String product_name;
    private  String product_price;
    private  String student_db_id;
    private int product_img;


    public Product(String id, String cat_id, String product_name, String product_price, String student_db_id, int product_img) {
        this.id = id;
        this.cat_id = cat_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.student_db_id = student_db_id;
        this.product_img = product_img;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCat_id() {
        return cat_id;
    }

    public void setCat_id(String cat_id) {
        this.cat_id = cat_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getStudent_db_id() {
        return student_db_id;
    }

    public void setStudent_db_id(String student_db_id) {
        this.student_db_id = student_db_id;
    }

    public int getProduct_img() {
        return product_img;
    }

    public void setProduct_img(int product_img) {
        this.product_img = product_img;
    }
}
