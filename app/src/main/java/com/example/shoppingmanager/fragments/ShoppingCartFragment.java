package com.example.shoppingmanager.fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shoppingmanager.R;
import com.example.shoppingmanager.adapters.ShoppingCartAdapter;
import com.example.shoppingmanager.data.datamodel.Product;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShoppingCartFragment extends Fragment {

  private List<Product> productList;

  private RecyclerView rvShoppingCart;
  private ShoppingCartAdapter shoppingCartAdapter;

  public static ShoppingCartFragment getInstance(List<Product> productList){
    return new ShoppingCartFragment(productList);
  }

  public ShoppingCartFragment( List<Product> productList) {
    this.productList = productList;
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_shopping_cart, container, false);
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    initView();
  }

  private void initView() {
    rvShoppingCart = getActivity().findViewById(R.id.rvChoppingCart);
    shoppingCartAdapter = new ShoppingCartAdapter(getContext());
    rvShoppingCart.setLayoutManager(new LinearLayoutManager(getContext()));
    rvShoppingCart.setAdapter(shoppingCartAdapter);

    shoppingCartAdapter.setShoppingCartData(productList);
  }
}
