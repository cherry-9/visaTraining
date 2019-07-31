package com.visa.prj.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class TimeTest {

	@Test
	public void testAddTimeTime() {
		Time t=new Time(4,5);
		Time t1=new Time(4,0);
		//t1.addTime(t);
		assertEquals(t1.addTime(t),new Time(8,5));
	}

	@Test
	public void testAddTimeTimeTime() {

		Time t=new Time(4,5);
		Time t1=new Time(4,0);
		Time t2=Time.addTime(t,t1);
		assertEquals(t2,new Time(8,5));
	}

}
