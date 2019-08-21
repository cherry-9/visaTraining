package com.visa.prj.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.visa.prj.dao.FetchException;
import com.visa.prj.dao.ProductDao;
import com.visa.prj.dao.ProductDaoJdbcImpl;
import com.visa.prj.entity.Product;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession ses=req.getSession(false);
		if(ses==null || ses.getAttribute("user")==null) {
			resp.sendRedirect("login.html");
		}else {
			String[] ele=req.getParameterValues("prds");
			if(ses.getAttribute("cart")==null) {
				ses.setAttribute("cart",new ArrayList<Product>());
			}
			
			ProductDao od=new ProductDaoJdbcImpl();
			List<Product> plist=(List<Product>) ses.getAttribute("cart");
			try {
				
				for(String e:ele) {
					Product pds=od.getProductById(Integer.parseInt(e));
					plist.add(pds);
				}
			}catch(FetchException exc) {
				exc.printStackTrace();
			}
			ses.setAttribute("cart", plist);
			resp.sendRedirect("cart.jsp");
		}

	}
	
	

}
