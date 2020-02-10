package com.example.shoppingmanager.data.datamodel;

import android.os.Parcel;
import android.os.Parcelable;

public class Goods implements Parcelable {

  private String goodsID;
  private String googdsName;

  public Goods(){

  }

  public static final Parcelable.Creator<Goods> CREATOR = new Parcelable.Creator<Goods>(){
    @Override
    public Goods createFromParcel(Parcel source) {
      return null;
    }


    @Override
    public Goods[] newArray(int size) {
      return new Goods[0];
    }
  };

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {

  }
}
