package com.homework.javaec.bean;

import java.util.ArrayList;
import java.util.List;

public class CartBean {
    private final List<ProductBean> items = new ArrayList<>();

    public CartBean() {
    }

    public void addCart(ProductBean product) {
        items.add(product);
    }

    public void deleteCart(int id) {
        items.remove(id);
    }
}
