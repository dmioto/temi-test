package com.miotoda.mystore.data.repository;


import com.miotoda.mystore.data.datasource.StoreDataSource;
import com.miotoda.mystore.data.datasource.dto.StoreResponse;
import com.miotoda.mystore.domain.entity.Product;
import com.miotoda.mystore.domain.mapper.StoreMapper;
import com.miotoda.mystore.domain.repository.ProductRepository;

import java.util.List;

import javax.inject.Inject;

public class ProductRepositoryImpl implements ProductRepository {

    StoreDataSource dataSource;

    @Inject
    public ProductRepositoryImpl(StoreDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Product> getProducts() {

        return StoreMapper.toStore(dataSource.getStore()).products;
    }

    @Override
    public StoreResponse getStore() {
        return dataSource.getStore();
    }
}
