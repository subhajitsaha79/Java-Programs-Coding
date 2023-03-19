package com.exceptions;
import java.util.*;
//Define classes Items, Customer
class Items implements Cloneable{
  public String[] item;
  public Items(String[] item)
  {
      this.item = item;
  }
  public String[] getItem()
  {
      return item;
  }
  public Items clone()throws CloneNotSupportedException
  {
      String[] item_copy = new String[item.length];
      for(int i=0;i<item.length;i++)
      {
          item_copy[i] = item[i];
      }
      Items it = (Items)super.clone();
      it.item = item_copy;
      return it;
  }
  public String toString()
  {
      String str="";
      for(String s:item)
      {
          str = str + s + " ";  
      }
      return str;
  }
}
class Customer implements Cloneable{
  private String name;
  private Items it;
  public Customer(String name,Items it)
  {
      this.name = name;
      this.it = it;
  }
  public Items getItems()
  {
      return it;
  }
  public void setName(String s)
  {
      name = s;
  }
  public Customer clone()throws CloneNotSupportedException
  {
      Customer c = (Customer)super.clone();
      Items ite = (Items)it.clone();
      c.it = ite;
      return c;
  }
  public String toString()
  {
      return name+" "+it.toString();
  }
}
public class Customer_Items_Clone {
public static void main(String[] args) throws CloneNotSupportedException{
  Scanner sc = new Scanner(System.in);
  int n = sc.nextInt(); // number of items
  String[] itm = new String[n];
  for(int i = 0; i < n; i++){
    itm[i] = sc.next(); // list of items
  } 
  var c1 = new Customer("naresh", new Items(itm));
  Customer c2 = c1.clone();   
  c2.getItems().item[0] = sc.next();   //Update first item of c2
  c2.setName("suresh"); //Update name of c2
  System.out.println(c1);
  System.out.println(c2);
}
}   