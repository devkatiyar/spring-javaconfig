package com;

import java.util.ArrayList;
import java.util.List;

public class Test {
	
	
public static void main(String[] args) {
	
	

	List<String> list=new ArrayList<String>();
	
	list.add("a");
	list.add("b");
	list.add("c");
	list.add("d");
	list.add("e");
	list.add("f");
	
	for (String value:list){
		
		if(value.equals("c")){
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list.remove(value);
			
		}
		else{
			System.out.println(value);
		}
	}
	System.out.println(list);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
}

