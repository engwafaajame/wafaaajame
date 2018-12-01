package com.emuniapp.emuni.Models;


import java.util.List;

public class ProductResponse {

    private List<Product> products = null;

    public List<Product> getProducts()
    {
        return products;
    }

    public void setProducts(List<Product> products)

    {
        this.products = products;
    }
}