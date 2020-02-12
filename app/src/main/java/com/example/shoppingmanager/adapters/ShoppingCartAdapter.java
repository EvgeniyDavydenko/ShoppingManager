package com.example.shoppingmanager.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingmanager.R;
import com.example.shoppingmanager.data.datamodel.Product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

  private LayoutInflater layoutInflater;
  private List<Product> cartProductList = new ArrayList<>();

  public ShoppingCartAdapter(Context context) {
    layoutInflater = LayoutInflater.from(context);
  }

  @Override
  public int getItemCount() {
    return cartProductList.size();
  }

  @NonNull
  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new ShoppingCartViewHolder(layoutInflater.inflate(R.layout.list_item, parent, false));
  }

  @Override
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    if (holder instanceof ShoppingCartViewHolder) {
      ((ShoppingCartViewHolder) holder).showData(position);
    }
  }

  public void setShoppingCartData(List<Product> productList) {
    cartProductList.clear();
    cartProductList.addAll(productList);
    notifyDataSetChanged();
  }

  public void setShoppingCartData(Product product) {
    cartProductList.add(product);
    notifyDataSetChanged();
  }


  private class ShoppingCartViewHolder extends RecyclerView.ViewHolder {
    TextView textView;

    public ShoppingCartViewHolder(View itemView) {
      super(itemView);
      textView = itemView.findViewById(R.id.listItem);
    }

    void showData(int position) {
      textView.setText(cartProductList.get(position).getProductName());
    }
  }

}
