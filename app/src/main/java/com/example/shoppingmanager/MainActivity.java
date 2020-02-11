package com.example.shoppingmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.shoppingmanager.fragments.ShoppingCartFragment;
import com.example.shoppingmanager.fragments.ToBuyFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

  private Fragment toBuyFragment, shoppingCartFragment;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    initView();
    replaceFragment(toBuyFragment);
  }

  private void initView() {
    toBuyFragment = ToBuyFragment.getInstance();
    shoppingCartFragment = ShoppingCartFragment.getInstance();

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

  private void replaceFragment(Fragment fragment) {
    getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.fragment_container, fragment, fragment.getClass().getSimpleName())
            .commit();
  }

}
