package org.sshTest.web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.sshTest.entity.EbOrder;
import org.sshTest.entity.EbProduct;
import org.sshTest.service.OrderService;
import org.sshTest.service.ProductService;

import java.util.HashMap;
import java.util.Map;


@Results({ 
	@Result(name = "detail", location = "/product-view.jsp"),
	@Result(name = "list", location = "/index.jsp")
})
public class OrderAction extends ActionSupport {
	@Autowired
	private ProductService productService;
	@Autowired
	private OrderService orderService;

	private EbOrder order;


	
	public Map session(){
		ActionContext ac = ActionContext.getContext();
		return ac.getSession();
	}
	
	public Map app(){
		ActionContext ac = ActionContext.getContext();
		return ac.getApplication();
	}
	
}
