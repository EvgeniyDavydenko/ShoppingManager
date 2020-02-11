package com.example.shoppingmanager.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.example.shoppingmanager.R;
import com.example.shoppingmanager.data.datamodel.Product;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddProductActivity extends AppCompatActivity {

  private EditText etAddProduct;
  private FloatingActionButton confirmFloatingButton;

  public static Intent getIntent(Context packageContext){
    return new Intent(packageContext, AddProductActivity.class);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_product);
    initView();
  }

  private void initView() {
    etAddProduct = findViewById(R.id.etAddProduct);
    confirmFloatingButton = findViewById(R.id.confirm_button);
    confirmFloatingButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if (etAddProduct.getText().toString().length() > 0) {
          setResult();
        }
      }
    });

    etAddProduct.requestFocus();
    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
  }

  private void setResult() {
    Product product = new Product(java.util.UUID.randomUUID().toString(), etAddProduct.getText().toString());
    Intent intent = new Intent();
    intent.putExtra("newProduct", product);
    setResult(RESULT_OK, intent);
    finish();
  }



}
