package com.visa.prj.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.visa.prj.entity.Product;
import com.visa.prj.service.OrderService;

@Controller
public class ProductController {
	@Autowired
	private OrderService os;
	
	@Autowired
	private ProductValidator productValidator;
	
	@RequestMapping ("listproducts.do")
	public ModelAndView getProducts() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("list.jsp");
		mv.addObject("products",os.getAll());
		return mv;
	}
	
	@RequestMapping("productform.do")
	public ModelAndView getForm() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("form.jsp");
		mv.addObject("product",new Product());
		return mv;
	}
	
	@RequestMapping("addproduct.do")
	public String addProduct(@ModelAttribute("product")Product p, Model m, BindingResult errors) {
		productValidator.validate(p, errors);
		if(errors.hasErrors())return "form.jsp";
		os.insertProduct(p);
		m.addAttribute("message","added p");
		return "index.jsp";
		
	}

}
