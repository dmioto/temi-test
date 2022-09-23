package com.miotoda.mystore.domain.entity;

import java.util.List;

public class Store {
    public List<Product> products;

    public Store(List<Product> products) {
        this.products = products;
    }
}
