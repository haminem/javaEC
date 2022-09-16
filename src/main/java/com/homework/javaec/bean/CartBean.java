package com.homework.javaec.bean;

import java.util.ArrayList;
import java.util.List;

public class CartBean {
    private List<ProductBean> items = new ArrayList<ProductBean>();

    public CartBean() {
    }

    public List<ProductBean> getItems() {
        return items;
    }

    public void addCart(ProductBean product) {
        items.add(product);
    }

    public void deleteCart(int id) {
        items.remove(id);
    }
}
