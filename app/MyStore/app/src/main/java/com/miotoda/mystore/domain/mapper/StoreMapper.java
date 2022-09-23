package com.miotoda.mystore.domain.mapper;

import com.miotoda.mystore.data.datasource.dto.BrandResponse;
import com.miotoda.mystore.data.datasource.dto.ProductResponse;
import com.miotoda.mystore.data.datasource.dto.SectorResponse;
import com.miotoda.mystore.data.datasource.dto.StoreResponse;
import com.miotoda.mystore.data.datasource.dto.SubSectorResponse;
import com.miotoda.mystore.domain.entity.Product;
import com.miotoda.mystore.domain.entity.Store;

import java.util.ArrayList;
import java.util.List;

public class StoreMapper {

    public static Store toStore(StoreResponse store) {

        List<Product> products = new ArrayList<Product>();
        String divisor = " > ";
        Product product;

        for (SectorResponse sector: store.sectors) {
            for (SubSectorResponse subSector: sector.subSectors) {
                for (BrandResponse brand: subSector.brands) {
                    for (ProductResponse p: brand.products) {
                        StringBuilder sb = new StringBuilder();
                        product = new Product();
                        product.brand = brand.name;
                        product.name = p.name;
                        product.code = p.code;
                        product.route = sb.append(sector.name).append(divisor).append(subSector.name).append(divisor).append(brand.name).toString();
                        products.add(product);
                    }
                }
            }
        }

        return new Store(products);
    }
    
    public static List<Product> toProduct(BrandResponse brand) {

        List<Product> products = new ArrayList<Product>();
        Product product = new Product();
        
        for (ProductResponse p: brand.products) {
            product.brand = brand.name;
            product.code = p.code;
            product.name = p.name;
            product.route = "";
            products.add(product);
        }
        
        return products;
    }
}
