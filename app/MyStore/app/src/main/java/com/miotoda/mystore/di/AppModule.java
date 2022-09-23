package com.miotoda.mystore.di;

import com.google.gson.Gson;
import com.miotoda.mystore.data.datasource.StoreDataSource;
import com.miotoda.mystore.data.datasource.mock.StoreMockDataSource;
import com.miotoda.mystore.data.repository.ProductRepositoryImpl;
import com.miotoda.mystore.domain.repository.ProductRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {

    @Provides
    @Singleton
    public StoreDataSource providesDataSource() {
        Gson gson = new Gson();
        return new StoreMockDataSource(gson);
    }

    @Provides
    @Singleton
    public ProductRepository provideRepository(){
        return new ProductRepositoryImpl(providesDataSource());
    }
}