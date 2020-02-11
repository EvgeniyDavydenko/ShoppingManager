package com.example.shoppingmanager.fragments;


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
import com.example.shoppingmanager.adapters.ToBuyAdapter;
import com.example.shoppingmanager.data.datamodel.Product;
import com.example.shoppingmanager.interfaces.ProductContract;

import java.util.List;
import java.util.ListIterator;

/**
 * A simple {@link Fragment} subclass.
 */
public class ToBuyFragment extends Fragment implements ProductContract.ToBuyFragmentBridge {

  private RecyclerView toBuyRecyclerView;
  private ToBuyAdapter toBuyAdapter;

  private List<Product> productList;

  public static ToBuyFragment getInstance(List<Product> productList) {
    return new ToBuyFragment(productList);
  }


  public ToBuyFragment(List<Product> productList) {
    this.productList = productList;
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_to_buy, container, false);
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    initView();
  }

  private void initView(){
    toBuyRecyclerView = getActivity().findViewById(R.id.toBuyRecyclerView);
    toBuyAdapter = new ToBuyAdapter(getContext());
    toBuyRecyclerView.setAdapter(toBuyAdapter);
    toBuyRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

//    toBuyAdapter.setData();
  }

  @Override
  public void toBuyProductAdded(Product product) {
    toBuyAdapter.setData(product);
  }
}
