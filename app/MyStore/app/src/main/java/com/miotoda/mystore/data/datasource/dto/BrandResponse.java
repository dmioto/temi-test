package com.miotoda.mystore.data.datasource.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BrandResponse {
    @SerializedName("nome")
    public String name;
    @SerializedName("produtos")
    public List<ProductResponse> products;
}
