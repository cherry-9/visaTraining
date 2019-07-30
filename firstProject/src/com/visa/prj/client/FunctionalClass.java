package com.visa.prj.client;

@FunctionalInterface
interface Computation{
	int compute(int a,int b);
}

public class FunctionalClass {

	public static void main(String[] args) {

		Computation c=new Computation() {
			
			@Override
			public int compute(int a, int b) {
				
				return a+b;
			}
		};
		doTask(c,9,10);
		//c.compute(9,10);
		Computation c2 =new Computation() {
			
			@Override
			public int compute(int a, int b) {
				
				return a-b;
			}
		};
		doTask(c2,9,10);
		Computation c3 =(int x,int y)->{
			return x*y;
		};
		
		doTask(c3,9,10);
		
		Computation c4=(x,y)->x-y;
		
		doTask(c4,2,5);
	}
	
	public static void doTask(Computation cc, int x, int y) {
		System.out.println(cc.compute(x,y));
	}

}
