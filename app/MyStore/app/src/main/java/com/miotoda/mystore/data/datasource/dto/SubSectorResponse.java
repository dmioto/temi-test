package com.miotoda.mystore.data.datasource.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SubSectorResponse {
    @SerializedName("nome")
    public String name;
    @SerializedName("marcas")
    public List<BrandResponse> brands;
}
