package com.visa.prj.client;

import java.util.Arrays;
import java.util.Comparator;

public class ComparableExample  {

	public static void main(String[] args) {
		String[] n= {"hi", "how", "today", "are", "you"};
		//Arrays.sort(n);
		Arrays.sort(n,(a,b)->a.length()-b.length());
//		Arrays.sort(n,new Comparator<String> ()
//		{
//			public int compare(String a,String b) 
//			{
//				return a.length()-b.length();
//			}
//			
//		});
//		
		for(String s:n) {System.out.println(s);}

	}

}
