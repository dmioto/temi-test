package com.miotoda.mystore.presentation.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.miotoda.mystore.data.repository.ProductRepositoryImpl;
import com.miotoda.mystore.domain.entity.Product;

import java.util.List;

import javax.inject.Inject;

public class HomeViewModel extends ViewModel {

    public enum State {
        LOADING, SUCCESS, ERROR;
    }

    private ProductRepositoryImpl repo;
    private final MutableLiveData<List<Product>> products = new MutableLiveData<>();
    private final MutableLiveData<State> state = new MutableLiveData<>();

    @Inject
    public HomeViewModel(ProductRepositoryImpl repository) {
        this.repo = repository;
        this.fetchProducts();
    }

    public void fetchProducts() {
        state.setValue(State.LOADING);
        products.setValue(repo.getProducts());
        state.setValue(State.SUCCESS);
//        repo.getProducts()..enqueue(new Callback<List<Product>>() {
//            @Override
//            public void onResponse(@NonNull Call<List<Product>> call, @NonNull Response<List<Product>> response) {
//                if (response.isSuccessful()) {
//                    products.setValue(response.body());
//                    state.setValue(State.DONE);
//                } else {
//                    state.setValue(State.ERROR);
//                }
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<List<Product>> call, @NonNull Throwable error) {
//                error.printStackTrace();
//                state.setValue(State.ERROR);
//            }
//        });
    }


    public LiveData<List<Product>> getProducts() {
        return products;
    }

    public LiveData<State> getState() {
        return this.state;
    }
}
