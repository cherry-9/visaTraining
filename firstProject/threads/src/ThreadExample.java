
public class ThreadExample {

	public static void main(String[] args) {
		System.out.println("hello");
		
		NumberThread t1=new NumberThread(3, 2000);

		NumberThread t2=new NumberThread(0, 10000);
		t2.setDaemon(true);
		t1.start();
		t2.start();
		doTask();

	}

	private static void doTask() {
		Thread t=Thread.currentThread();
		System.out.println("Name "+t.getName());
		System.out.println("group"+t.getThreadGroup().getName());
		System.out.println("Priority "+ t.getPriority());
		System.out.println("daemon "+ t.isDaemon());
		
		
	}

}
