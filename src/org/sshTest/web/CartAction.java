package org.sshTest.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.sshTest.entity.EbOrder;
import org.sshTest.entity.EbProduct;
import org.sshTest.service.OrderService;
import org.sshTest.service.ProductService;
import org.sshTest.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


@Results({ 
	@Result(name = "detail", location = "/content/product-view.jsp"),
	@Result(name = "list", location = "/content/index.jsp")
})
public class CartAction extends ActionSupport {
	@Autowired
	private ProductService productService;
	@Autowired
	private OrderService orderService;
	private Map<EbProduct,Integer> cart;
	private EbProduct product;
	private Integer qty;
	
	public String addCart(){
		init();
		cart.put(product, qty);
		
		return "";
	}
	
	public String balance(){//Ω·À„
		init();
		cart.clear();
		return "balance";
	}
	
	public void init(){
		cart = (Map<EbProduct,Integer>)session().get("cart");
		if(cart==null){
			cart = new HashMap<EbProduct,Integer>();
			session().put("cart",cart);
		}
	}
	
	public Map session(){
		ActionContext ac = ActionContext.getContext();
		return ac.getSession();
	}
	
	public Map app(){
		ActionContext ac = ActionContext.getContext();
		return ac.getApplication();
	}
	
}
