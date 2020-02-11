package com.example.shoppingmanager.interfaces;

import com.example.shoppingmanager.data.datamodel.Product;

public interface ProductContract {
  interface ToBuyFragmentBridge {
    void toBuyProductAdded(Product product);
  }

  interface MainActivityBridge {
    void productMovedToCard(Product product);
  }
}
