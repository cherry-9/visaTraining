package com.visa.prj.util;

public class Utility {
	
	public static void sort(Comparable[] e) {
		for(int i=0;i<e.length;i++)
		{
			for(int j=0;j<e.length;j++){
				if(e[i].compareTo(e[j])>0) {
					Comparable t=e[j];
					e[j]=e[i];
					e[i]=t;
				}
			}
		}
	}

}
