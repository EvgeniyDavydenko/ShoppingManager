package com.example.shoppingmanager.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shoppingmanager.R;
import com.example.shoppingmanager.adapters.ToBuyAdapter;
import com.example.shoppingmanager.data.datamodel.Product;
import com.example.shoppingmanager.interfaces.ProductContract;
import com.example.shoppingmanager.interfaces.RVItemRemoved;

import java.util.List;
import java.util.ListIterator;

import static androidx.recyclerview.widget.ItemTouchHelper.ACTION_STATE_SWIPE;

/**
 * A simple {@link Fragment} subclass.
 */
public class ToBuyFragment extends Fragment implements ProductContract.ToBuyFragmentBridge {

  private RecyclerView toBuyRecyclerView;
  private ToBuyAdapter toBuyAdapter;

  private List<Product> productList;
  private ProductContract.MainActivityBridge mainActivityBridge;

  public static ToBuyFragment getInstance(List<Product> productList, ProductContract.MainActivityBridge mainActivityBridge) {
    return new ToBuyFragment(productList, mainActivityBridge);
  }


  public ToBuyFragment(List<Product> productList, ProductContract.MainActivityBridge mainActivityBridge) {
    this.productList = productList;
    this.mainActivityBridge = mainActivityBridge;
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    Log.d(getClass().getName(), "ToBuyFragment onCreateView");
    return inflater.inflate(R.layout.fragment_to_buy, container, false);
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    initView();
    Log.d(getClass().getName(), "ToBuyFragment onViewCreated");
  }

  private void initView(){
    toBuyRecyclerView = getActivity().findViewById(R.id.toBuyRecyclerView);
    toBuyAdapter = new ToBuyAdapter(getContext(), this::itemRemoved);
    toBuyRecyclerView.setAdapter(toBuyAdapter);
    toBuyRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() {
      @Override
      public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        return makeFlag(ACTION_STATE_SWIPE, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
      }

      @Override
      public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return false;
      }

      @Override
      public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        int position = viewHolder.getAdapterPosition();
        toBuyAdapter.deleteItem(position);
      }
    });

    itemTouchHelper.attachToRecyclerView(toBuyRecyclerView);
    toBuyAdapter.setData(productList);
  }

  private void itemRemoved(int itemPosition) {
    Log.d(getClass().getName(), "itemRemoved " + itemPosition);
    mainActivityBridge.productMovedToCard(productList.get(itemPosition));
    productList.remove(itemPosition);
  }

  @Override
  public void toBuyProductAdded(Product product) {
    toBuyAdapter.setData(product);
  }
}
