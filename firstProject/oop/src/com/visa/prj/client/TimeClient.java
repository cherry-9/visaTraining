package com.visa.prj.client;

import com.visa.prj.entity.Time;

public class TimeClient {
	
	public static void main(String[] args) {
		Time t1=new Time(4,5);
		Time t2=new Time(4,0);
		Time t3=t1.addTime(t2);
		Time t4=Time.addTime(t1,t2);
		System.out.println(t3.getHours()+" : "+t3.getMinutes());
		System.out.println(t4.getHours()+" : "+t4.getMinutes());
	}


}
