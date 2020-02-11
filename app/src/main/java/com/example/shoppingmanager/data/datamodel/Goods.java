package com.example.shoppingmanager.data.datamodel;

import android.os.Parcel;
import android.os.Parcelable;

public class Goods implements Parcelable {

  private String goodsID;
  private String goodsName;

  public Goods(String goodsID, String goodsName) {
    this.goodsID = goodsID;
    this.goodsName = goodsName;
  }

  public Goods(Parcel in) {
    String[] data = new String[2];
    in.readStringArray(data);
    goodsID = data[0];
    goodsName = data[1];
  }

  public static final Parcelable.Creator<Goods> CREATOR = new Parcelable.Creator<Goods>(){
    @Override
    public Goods createFromParcel(Parcel source) {
      return new Goods(source);
    }


    @Override
    public Goods[] newArray(int size) {
      return new Goods[size];
    }
  };

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeStringArray(new String[]{goodsID, goodsName});

  }

  public String getGoodsID() {
    return goodsID;
  }

  public void setGoodsID(String goodsID) {
    this.goodsID = goodsID;
  }

  public String getGoodsName() {
    return goodsName;
  }

  public void setGoodsName(String goodsName) {
    this.goodsName = goodsName;
  }
}
