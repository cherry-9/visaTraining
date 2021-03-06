package com.visa.prj.entity;

public class Time  {
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


	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hours;
		result = prime * result + minutes;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		if (hours != other.hours)
			return false;
		if (minutes != other.minutes)
			return false;
		return true;
	}



}
