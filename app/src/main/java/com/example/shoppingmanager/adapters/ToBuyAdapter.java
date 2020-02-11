package com.example.shoppingmanager.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingmanager.R;
import com.example.shoppingmanager.data.datamodel.Goods;

import java.util.ArrayList;
import java.util.List;

public class ToBuyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
  private LayoutInflater inflater;
  private List<Goods> goodsList = new ArrayList<>();


  public ToBuyAdapter(Context context){
    inflater = LayoutInflater.from(context);
  }

  @Override
  public int getItemCount() {
    return goodsList.size();
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

  public void setData(Goods goods){
    goodsList.add(goods);
    notifyDataSetChanged();
  }

  public void setData() {
    List<Goods> testDataList = new ArrayList<Goods>() {{
      add(new Goods("1", "product1"));
      add(new Goods("2", "product2"));
      add(new Goods("3", "product3"));
      add(new Goods("4", "product4"));
      add(new Goods("5", "product5"));
      add(new Goods("6", "product6"));
      add(new Goods("7", "product7"));
      add(new Goods("8", "product8"));

      add(new Goods("9", "product9"));
      add(new Goods("10", "product10"));
      add(new Goods("11", "product11"));
      add(new Goods("12", "product12"));
      add(new Goods("13", "product13"));
      add(new Goods("14", "product14"));
      add(new Goods("15", "product15"));
      add(new Goods("16", "product16"));
    }};

    goodsList.addAll(testDataList);
    notifyDataSetChanged();
  }

  private class ToByHolder extends RecyclerView.ViewHolder {
    TextView textView;

    ToByHolder(View itemView) {
      super(itemView);
      textView = itemView.findViewById(R.id.listItem);
    }

    void showData(int position) {
      textView.setText(goodsList.get(position).getGoodsName());
    }

  }
}
