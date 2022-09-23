package com.miotoda.mystore.data.datasource.dto;

import com.google.gson.annotations.SerializedName;

public class ProductResponse {
    @SerializedName("nome")
    public String name;
    @SerializedName("SKU")
    public String code;
}
