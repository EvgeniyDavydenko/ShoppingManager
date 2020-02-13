package com.example.shoppingmanager.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingmanager.R;
import com.example.shoppingmanager.adapters.ShoppingCartAdapter;
import com.example.shoppingmanager.data.datamodel.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShoppingCartFragment extends Fragment {

  private List<Product> productList;

  private RecyclerView rvShoppingCart;
  private ShoppingCartAdapter shoppingCartAdapter;

  public static ShoppingCartFragment getInstance(List<Product> productList){
    ShoppingCartFragment shoppingCartFragment = new ShoppingCartFragment();
    Bundle bundle = new Bundle();
    bundle.putParcelableArrayList("productList", (ArrayList<Product>) productList);
    shoppingCartFragment.setArguments(bundle);
    return shoppingCartFragment;
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

    productList = getArguments().getParcelableArrayList("productList");
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
