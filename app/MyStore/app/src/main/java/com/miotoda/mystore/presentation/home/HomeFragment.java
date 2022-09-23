package com.miotoda.mystore.presentation.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.miotoda.mystore.data.datasource.mock.StoreMockDataSource;
import com.miotoda.mystore.data.repository.ProductRepositoryImpl;
import com.miotoda.mystore.databinding.FragmentHomeBinding;
import com.miotoda.mystore.presentation.home.adapter.ProductAdapter;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeFragment extends Fragment {

    HomeViewModel viewModel = new HomeViewModel(new ProductRepositoryImpl(new StoreMockDataSource(new Gson())));

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentHomeBinding binding = FragmentHomeBinding.inflate(getLayoutInflater());

//        binding.srlNews.setOnRefreshListener(viewModel::fetchProducts);
        setupObservers(binding);

        return binding.getRoot();
    }

    private void setupObservers(FragmentHomeBinding binding) {
        observeStates(binding);
        observeProducts(binding);
    }

    private void observeStates(FragmentHomeBinding binding) {
        viewModel.getState().observe(getViewLifecycleOwner(), state -> {
            switch (state) {
                case LOADING:
                    break;

                case SUCCESS:
                    break;

                case ERROR:
                    break;
            }
        });
    }

    private void observeProducts(FragmentHomeBinding binding) {
        viewModel.getProducts().observe(getViewLifecycleOwner(), products -> {
            binding.rvProducts.setAdapter(new ProductAdapter(products));
        });
    }

}
