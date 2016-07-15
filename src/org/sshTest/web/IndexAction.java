package org.sshTest.web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.sshTest.entity.EbNews;
import org.sshTest.entity.EbNotice;
import org.sshTest.entity.EbProCategory;
import org.sshTest.entity.EbProduct;
import org.sshTest.service.ProductService;
import org.sshTest.service.UtilService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


@Results({ 
	@Result(name = "index", location = "/content/product-view.jsp")
})
public class IndexAction extends ActionSupport {
	@Autowired
	private ProductService productService;

	@Autowired
	private UtilService utilService;

	private List<EbNews> newslist;
	private List<EbNotice> noticelist;
	private List<EbProCategory> categoryList;
	private List<EbProduct> bargainList;
	private List<EbProduct> hotList;
	private Integer id;
	private EbNews news;
	private EbNotice notice;

	@Action(value = "news!detail.action", results ={@Result(location = "/news-view.jsp")})
	public String news(){
		news = utilService.getNews(id);
		return "hot";
	}

	@Action(value = "notice!detail.action", results ={@Result(location = "/news-view.jsp")})
	public String notice(){
		notice = utilService.getNotice(id);
		return "notice";
	}

	public String index(){
		return "index";
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
