package com.visa.prj.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.visa.prj.dao.FetchException;
import com.visa.prj.dao.PersistenceException;
import com.visa.prj.dao.ProductDao;
import com.visa.prj.dao.ProductDaoJdbcImpl;
import com.visa.prj.entity.Product;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/products")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*response.setContentType("text/html");//mime type
		PrintWriter out=response.getWriter();//for char stream
		
		//ServletOutputStream outputStream= response.getOutputStream();
		
		out.print("<html><body>");
		out.print("<table border='1'>");
		out.print("<tr><th> Name </th> <th> Price </th> </tr>");
		
		ProductDao pd  = new ProductDaoJdbcImpl();
		try {
			List<Product> l= pd.getProducts();
			l.forEach(p->{
				out.print("<tr>"+"<td>"+p.getName()+"</td>" + "<td>" + p.getPrice() + "</td> </tr>");
			});
			
		}catch(FetchException e) {
			e.printStackTrace();
			out.print(e.getMessage());
		}
		
		out.print("</table> </body></html>");*/
		
		
		ProductDao pd  = new ProductDaoJdbcImpl();
		try {
			List<Product> l= pd.getProducts();
				
			request.setAttribute("products", l);
			request.getRequestDispatcher("list.jsp").forward(request,response);
				
			
		}catch(FetchException e) {
			e.printStackTrace();
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductDao pd=new ProductDaoJdbcImpl();
		Product p=new Product();
		
		p.setName(request.getParameter("name"));
		p.setPrice(Double.parseDouble(request.getParameter("price")));
		p.setCategory(request.getParameter("category"));
		p.setCount(Integer.parseInt(request.getParameter("count")));
		
		
		try {
			int id=pd.addProduct(p);
			
			//PrintWriter out=response.getWriter();
			//out.print("<html><body> product success "+id+"</body></html>");
			response.sendRedirect("index.html");
			
		}catch (PersistenceException e) {
			e.printStackTrace();
			response.sendRedirect("errorhandler?msg="+e.getMessage());
		}
		
		
		
		
		
		
	}

}
