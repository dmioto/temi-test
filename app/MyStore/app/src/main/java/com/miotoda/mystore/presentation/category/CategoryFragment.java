package com.miotoda.mystore.presentation.category;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.miotoda.mystore.data.datasource.mock.StoreMockDataSource;
import com.miotoda.mystore.data.repository.ProductRepositoryImpl;
import com.miotoda.mystore.databinding.FragmentCategoryBinding;
public class CategoryFragment extends Fragment {

    CategoryViewModel viewModel = new CategoryViewModel(new ProductRepositoryImpl(new StoreMockDataSource(new Gson())));

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentCategoryBinding binding = FragmentCategoryBinding.inflate(getLayoutInflater());

//        binding.srlNews.setOnRefreshListener(viewModel::fetchProducts);
        setupObservers(binding);

        return binding.getRoot();
    }

    private void setupObservers(FragmentCategoryBinding binding) {
        observeStates(binding);
        observeStore(binding);
    }

    private void observeStates(FragmentCategoryBinding binding) {
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

    private void observeStore(FragmentCategoryBinding binding) {
        viewModel.getStore().observe(getViewLifecycleOwner(), store -> {
//            binding.elvCategories.setAdapter((ListAdapter) new CategoryAdapter(store));
        });
    }

}
