package com.miotoda.mystore.domain.repository;

import com.miotoda.mystore.data.datasource.dto.StoreResponse;
import com.miotoda.mystore.domain.entity.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getProducts();
    StoreResponse getStore();
}
