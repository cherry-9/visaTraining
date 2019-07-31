
public class NumberThread extends Thread {
	private int start,end;

	public NumberThread(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		print();
	}

	private void print() {
		// TODO Auto-generated method stub
		Thread t=Thread.currentThread();
		for(int i=start;i<end;i++) {
			System.out.println(i+ " "+t.getName());}
		
		
	}
	
	
}
