import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class PoolClient {

	public static void main(String[] args) {
		ExecutorService servi= Executors.newFixedThreadPool(2);
		
		Future<Integer> f1=servi.submit( new Numbers(2, 1000));
		Future<Integer> f2=servi.submit( new Numbers(2, 1000));
		Future<Integer> f3=servi.submit( new Numbers(2, 1000));
		Future<Integer> f4=servi.submit( new Numbers(2, 1000));
		Future<Integer> f5=servi.submit( new Numbers(2, 1000));
		try {
			System.out.println(f1.get());

			System.out.println(f2.get(100,TimeUnit.SECONDS));

			System.out.println(f3.get());

			System.out.println(f4.get());
			
			System.out.println(f5.get());
			
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		servi.shutdown();

	}

}
