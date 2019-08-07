import com.visa.training.JDBC.JDBCProductDao;
import com.visa.training.JDBC.Product;

public class ProductTest {

	public static void main(String[] args) {

		JDBCProductDao j=new JDBCProductDao();
		Product p=new Product("tv",100f,5);
		j.save(p);
		j.findAll().forEach(System.out::println);
			

	}

}
