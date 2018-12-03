package com.emuniapp.emuni.classes;

public class Product {

    private String cat_id;
    private String product_name;
    private String product_price;
    private String product_number;

    public Product(String cat_id, String product_name, String product_price, String product_number) {
        this.cat_id = cat_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_number = product_number;
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

    public String getProduct_number() {
        return product_number;
    }

    public void setProduct_number(String product_number) {
        this.product_number = product_number;
    }
}


