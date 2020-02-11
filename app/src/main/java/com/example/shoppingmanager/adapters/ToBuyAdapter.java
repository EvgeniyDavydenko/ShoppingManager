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

import java.util.ArrayList;
import java.util.List;

public class ToBuyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
  private LayoutInflater inflater;
  private List<Product> productList = new ArrayList<>();


  public ToBuyAdapter(Context context){
    inflater = LayoutInflater.from(context);
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

  public void setData() {
    List<Product> testDataList = new ArrayList<Product>() {{
      add(new Product("1", "product1"));
      add(new Product("2", "product2"));
      add(new Product("3", "product3"));
      add(new Product("4", "product4"));
      add(new Product("5", "product5"));
      add(new Product("6", "product6"));
      add(new Product("7", "product7"));
      add(new Product("8", "product8"));

      add(new Product("9", "product9"));
      add(new Product("10", "product10"));
      add(new Product("11", "product11"));
      add(new Product("12", "product12"));
      add(new Product("13", "product13"));
      add(new Product("14", "product14"));
      add(new Product("15", "product15"));
      add(new Product("16", "product16"));
    }};

    productList.addAll(testDataList);
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
      if (position % 2 != 0) {
        view.setBackgroundColor(Color.LTGRAY);
      }
      textView.setText(productList.get(position).getProductName());
    }

  }
}
