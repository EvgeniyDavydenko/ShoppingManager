package com.example.shoppingmanager.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shoppingmanager.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ToBuyFragment extends Fragment {

  public static Fragment getInstance() {
    return new ToBuyFragment();
  }


  public ToBuyFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_to_buy, container, false);
  }

}
