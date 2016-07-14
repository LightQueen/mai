package org.sshTest.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.sshTest.entity.EbProduct;
import org.sshTest.service.ProductService;
import org.sshTest.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


@Results({ 
	@Result(name = "detail", location = "/content/product-view.jsp"),
	@Result(name = "list", location = "/content/product-list.jsp"),
	@Result(name = "hot", location = "/content/index.jsp")
})
public class ProductAction extends ActionSupport {
	@Autowired
	private ProductService productService;
	private List<EbProduct> productlist;
	private EbProduct product;
	private Integer id;
	private Integer totalPage;
	private Integer pageIndex;
	
	public String list(){//Deprecated
		System.out.println("i'm in action");
		int pageSize = 2;
		
//		productlist= productService.getAll();
//		int count = productlist.size();
		int count = 10;
		if(pageIndex==null)pageIndex=1;
		productlist = productService.getProductPage(pageIndex,pageSize);
		totalPage=((count%pageSize==0)?(count/pageSize):(count/pageSize+1));
		
		return "list";
	}
	
	public String detail(){
		product = productService.getById(id);
		System.out.println(product);//tostring
		
		List<EbProduct> recent = (List<EbProduct>)session().get("recent");
		if(recent==null){
			recent = new ArrayList();
			session().put("recent",recent);//纠结顺序
		}else{
			Iterator<EbProduct> ite = recent.iterator();
			while(ite.hasNext()){
				EbProduct temp = ite.next();
				if(temp.equals(product)){
					ite.remove();
				}
			}
		}
		if(recent.size()>=5)//保证recent始终小于5
			recent.remove(0);
		recent.add(product);
		
		return "detail";
	}
	
	
	
	
	

	public List<EbProduct> getProductlist() {
		return productlist;
	}

	public void setProductlist(List<EbProduct> productlist) {
		this.productlist = productlist;
	}

	public EbProduct getProduct() {
		return product;
	}

	public void setProduct(EbProduct product) {
		this.product = product;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
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
