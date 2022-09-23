package com.miotoda.mystore.data.datasource.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StoreResponse {
    @SerializedName("setores")
    public List<SectorResponse> sectors;
}

