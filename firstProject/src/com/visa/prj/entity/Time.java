package com.visa.prj.entity;

public class Time {
	private int hours, minutes;
	
	public Time() {}
	

	public Time(int hours, int minutes) {
		this.hours = hours;
		this.minutes = minutes;
	}


	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	
	public Time addTime(Time b) {
		int ch=this.hours+ b.getHours();
		int cm=this.minutes+ b.getMinutes();
		if(cm>59) {
			cm-=60;
			ch++;
		}
		Time c=new Time(ch,cm);
		return c;
	}
	
	public static Time addTime(Time a, Time b) {
		int ch=a.getHours()+ b.getHours();
		int cm=a.getMinutes()+ b.getMinutes();
		if(cm>59) {
			cm-=60;
			ch++;
		}
		Time c=new Time(ch,cm);
		return c;
	}

}
