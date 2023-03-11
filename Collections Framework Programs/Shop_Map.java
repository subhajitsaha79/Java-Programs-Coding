package com.oppe_practise;

import java.util.*;
class Shop{
    private String name;
    private int nsold; 
    public Shop(String s, int ns){
	this.name = s;
	this.nsold = ns;
    }
    public String getName(){
	return name;
    }
    public int getItemSold(){
	return nsold;
    }
} 
public class Shop_Map {
	public static void printShopName(ArrayList<Shop> sList) {
	    Map<String, Integer> m = new LinkedHashMap<String, Integer>();
	    String shop = "";
	    int sold = 0;
             // iterate through sList and add each shop object to map "m"
	    for(Shop s:sList)
	    {
	    	if(m.containsKey(s.getName()))
	    	{
	    		int value = m.get(s.getName())+s.getItemSold();
	    		m.replace(s.getName(),value);
	    	}
	    	else
	    	{
	    		m.put(s.getName(),s.getItemSold());
	    	}	
	    }
	    for(Map.Entry<String, Integer> entry:m.entrySet())
	    {
	    	if(entry.getValue()>sold)
	    	{
	    		sold = entry.getValue();
	    		shop = entry.getKey();
	    	}
	    }
        System.out.println(shop+" : "+sold);
    }
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	ArrayList<Shop> list = new ArrayList<Shop>();
	for (int i = 0; i < 4; i++) {
		list.add(new Shop(sc.next(), sc.nextInt()));
	}
	printShopName(list);
    }
}
