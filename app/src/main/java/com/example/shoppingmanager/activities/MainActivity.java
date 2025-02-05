package com.example.shoppingmanager.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.shoppingmanager.R;
import com.example.shoppingmanager.data.datamodel.Product;
import com.example.shoppingmanager.fragments.ShoppingCartFragment;
import com.example.shoppingmanager.fragments.ToBuyFragment;
import com.example.shoppingmanager.interfaces.ProductContract;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ProductContract.MainActivityBridge {

  private static final int ADD_PRODUCT_CODE = 1000;

  private ToBuyFragment toBuyFragment;
  private ShoppingCartFragment shoppingCartFragment;
  private FloatingActionButton addProductButton;
  private Fragment currentFragment;

  private List<Product> toBuyProductsList = new ArrayList<>();
  private List<Product> cartProductList = new ArrayList<>();

  private ProductContract.ToBuyFragmentBridge toBuyFragmentBridge;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    if (savedInstanceState != null) {
      toBuyProductsList = savedInstanceState.getParcelableArrayList("toBuyProductsList");
      cartProductList = savedInstanceState.getParcelableArrayList("cartProductList");
      currentFragment = getSupportFragmentManager().getFragment(savedInstanceState, "currentFragment");
    }

    initView();
    if (currentFragment != null) {
      replaceFragment(currentFragment);
    } else {
      replaceFragment(toBuyFragment);
    }
  }

  @Override
  public void onSaveInstanceState(@NonNull Bundle outState) {
    super.onSaveInstanceState(outState);
    Log.d(getClass().getName(), "onSaveInstanceState");
    outState.putParcelableArrayList("toBuyProductsList", (ArrayList<Product>) toBuyProductsList);
    outState.putParcelableArrayList("cartProductList", (ArrayList<Product>) cartProductList);

    getSupportFragmentManager().putFragment(outState, "currentFragment", currentFragment);
  }

  private void initView() {
    toBuyFragment = ToBuyFragment.getInstance(toBuyProductsList);
    shoppingCartFragment = ShoppingCartFragment.getInstance(cartProductList);
    toBuyFragmentBridge = toBuyFragment;

    addProductButton = findViewById(R.id.addProductButton);
    addProductButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = AddProductActivity.getIntent(MainActivity.this);
        startActivityForResult(intent, ADD_PRODUCT_CODE);
      }
    });

    BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
    bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
      @Override
      public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
          case R.id.action_to_buy:
            replaceFragment(toBuyFragment);
            break;
          case R.id.action_cart:
            replaceFragment(shoppingCartFragment);
            break;
        }
        return true;
      }
    });
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (resultCode != Activity.RESULT_OK) {
      return;
    }

    if (requestCode == ADD_PRODUCT_CODE) {
      Product product = data.getParcelableExtra("newProduct");
      toBuyProductsList.add(product);
      toBuyFragmentBridge.toBuyProductAdded(product);
      Log.d(getClass().getName(), "newProductName = " + product.getProductName());
      Log.d(getClass().getName(), "newProductID = " + product.getProductID());
    }
  }

  private void replaceFragment(Fragment fragment) {
    currentFragment = fragment;
    getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.fragment_container, currentFragment, fragment.getClass().getSimpleName())
            .commit();
  }

  @Override
  public void productMovedToCard(Product product) {
    cartProductList.add(product);
    Log.d(getClass().getName(), "productMovedToCard " + cartProductList.size());
  }
}
