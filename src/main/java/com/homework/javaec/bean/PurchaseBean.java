package com.homework.javaec.bean;

import java.io.Serializable;

public class PurchaseBean implements Serializable {
    private int id;
    private int product_id;
    private String product_name;
    private int product_price;
    private int product_count;
    private String customer_name;
    private String customer_address;

    public PurchaseBean() {
    }

    public PurchaseBean(int id, int product_id, String product_name, int product_price, int product_count, String customer_name, String customer_address) {
        this.id = id;
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_count = product_count;
        this.customer_name = customer_name;
        this.customer_address = customer_address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getProduct_price() {
        return product_price;
    }

    public void setProduct_price(int product_price) {
        this.product_price = product_price;
    }

    public int getProduct_count() {
        return product_count;
    }

    public void setProduct_count(int product_count) {
        this.product_count = product_count;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }
}
