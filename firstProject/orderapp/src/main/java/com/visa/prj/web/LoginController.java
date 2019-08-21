package com.visa.prj.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.visa.prj.dao.ProductDaoJpaImpl;
import com.visa.prj.entity.Customer;
import com.visa.prj.entity.Item;
import com.visa.prj.entity.Order;
import com.visa.prj.entity.Product;
import com.visa.prj.service.OrderService;

@Controller
@SessionAttributes("user")
public class LoginController {
	
	@Autowired
	private OrderService os;
	
	@Autowired
	private ProductDaoJpaImpl po;
	
    @RequestMapping("login.do")
    public String doLogin(@RequestParam("email") String email, @RequestParam("pwd") String pwd, Model m) {
        m.addAttribute("user", email);
        return "listproducts.do";
    }
     
    @RequestMapping("signout.do")
    public String doLogout(HttpServletRequest req) {
        HttpSession ses = req.getSession(false);
        ses.removeAttribute("user");
        ses.invalidate();
        return "redirect:login.html";
    }
    
    @RequestMapping("cart.do")
    public String doCart(HttpServletRequest req) {
    	HttpSession ses=req.getSession(false);
		if(ses==null || ses.getAttribute("user")==null) {
			return "login.html";
		}
		String[] ele=req.getParameterValues("prds");
		os.placeOrder(ele,(String)ses.getAttribute("user"));
		
    	return "index.jsp";
    	
    }
     
}
