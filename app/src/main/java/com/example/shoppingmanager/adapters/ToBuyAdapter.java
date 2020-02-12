package com.example.shoppingmanager.adapters;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingmanager.R;
import com.example.shoppingmanager.data.datamodel.Product;
import com.example.shoppingmanager.interfaces.RVItemRemoved;

import java.util.ArrayList;
import java.util.List;

public class ToBuyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
  private LayoutInflater inflater;
  private List<Product> productList = new ArrayList<>();
  private RVItemRemoved itemRemovedListener;


  public ToBuyAdapter(Context context, RVItemRemoved itemRemovedListener){
    inflater = LayoutInflater.from(context);
    this.itemRemovedListener = itemRemovedListener;
  }

  @Override
  public int getItemCount() {
    return productList.size();
  }

  @NonNull
  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    Log.d(getClass().getName(), "onCreateViewHolder");
    return new ToByHolder(inflater.inflate(R.layout.list_item, parent, false));
  }

  @Override
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    if (holder instanceof ToByHolder){
      ((ToByHolder) holder).showData(position);
    }
  }

  public void setData(Product product){
    productList.add(product);
    notifyDataSetChanged();
  }

  public void setData(List<Product> productList){
    this.productList.clear();
    this.productList.addAll(productList);
    notifyDataSetChanged();
  }

  public void deleteItem(int itemPosition) {
    productList.remove(itemPosition);
    itemRemovedListener.onItemRemoved(itemPosition);
    notifyItemRemoved(itemPosition);
    notifyDataSetChanged();
  }

  private class ToByHolder extends RecyclerView.ViewHolder {
    TextView textView;
    View view;

    ToByHolder(View itemView) {
      super(itemView);
      view = itemView;
      textView = itemView.findViewById(R.id.listItem);
    }

    void showData(int position) {
      Log.d(getClass().getName(), "change Color" + position % 2);
      if (position % 2 != 0) {
        view.setBackgroundColor(Color.LTGRAY);
      } else {
        view.setBackgroundColor(Color.WHITE);
      }
      textView.setText(productList.get(position).getProductName());
    }
  }
}
