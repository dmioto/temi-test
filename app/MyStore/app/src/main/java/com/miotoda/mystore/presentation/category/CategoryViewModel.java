package com.miotoda.mystore.presentation.category;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.miotoda.mystore.data.datasource.dto.StoreResponse;
import com.miotoda.mystore.data.repository.ProductRepositoryImpl;
import com.miotoda.mystore.domain.entity.Product;
import com.miotoda.mystore.presentation.home.HomeViewModel;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

public class CategoryViewModel extends ViewModel {

    public enum State {
        LOADING, SUCCESS, ERROR;
    }

    private ProductRepositoryImpl repo;
    private final MutableLiveData<StoreResponse> store = new MutableLiveData<>();
    private final MutableLiveData<HomeViewModel.State> state = new MutableLiveData<>();

    @Inject
    public CategoryViewModel(ProductRepositoryImpl repository) {
        this.repo = repository;
        this.fetchStore();
    }

    public void fetchStore() {
        state.setValue(HomeViewModel.State.LOADING);
        store.setValue(repo.getStore());
        state.setValue(HomeViewModel.State.SUCCESS);
    }


    public LiveData<StoreResponse> getStore() {
        return store;
    }

    public LiveData<HomeViewModel.State> getState() {
        return this.state;
    }

}
