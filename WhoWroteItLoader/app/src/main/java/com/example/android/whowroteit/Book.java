package com.example.android.whowroteit;

import android.support.annotation.NonNull;

import java.util.List;

public class Book {
   private String kind;
   private List<item> items;

   public String getKind() {
      return kind;
   }

   public void addItem(item it){
      this.items.add(it);
   }

   public void setKind(String kind) {
      this.kind = kind;
   }

   public List<item> getItems() {
      return items;
   }

   public void setItems(List<item> items) {
      this.items = items;
   }

}
