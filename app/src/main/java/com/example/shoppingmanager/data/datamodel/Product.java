package com.example.shoppingmanager.data.datamodel;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {

  private String productID;
  private String productName;

  public Product(String productID, String productName) {
    this.productID = productID;
    this.productName = productName;
  }

  public Product(Parcel in) {
    String[] data = new String[2];
    in.readStringArray(data);
    productID = data[0];
    productName = data[1];
  }

  public static final Parcelable.Creator<Product> CREATOR = new Parcelable.Creator<Product>(){
    @Override
    public Product createFromParcel(Parcel source) {
      return new Product(source);
    }


    @Override
    public Product[] newArray(int size) {
      return new Product[size];
    }
  };

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeStringArray(new String[]{productID, productName});
  }

  public String getProductID() {
    return productID;
  }

  public void setProductID(String productID) {
    this.productID = productID;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }
}
