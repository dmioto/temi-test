package com.miotoda.mystore.data.datasource.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SectorResponse {
    @SerializedName("nome")
    public String name;
    @SerializedName("subsetores")
    public List<SubSectorResponse> subSectors;
}
