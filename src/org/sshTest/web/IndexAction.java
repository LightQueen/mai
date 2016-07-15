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
	@Result(name = "index", location = "/index.jsp")
})
public class IndexAction extends ActionSupport {


	@Autowired
	private UtilService utilService;

	private List<EbNews> newslist;
	private List<EbNotice> noticelist;
	private List<EbProCategory> categorylist;
	private List<EbProduct> bargainlist;
	private List<EbProduct> hotlist;
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

	//@Action("index")//index.action
	public String execute(){
		newslist = utilService.getAllNews();
		noticelist = utilService.getAllNotice();
		System.out.println(noticelist);
		for(EbNotice n : noticelist){
			System.out.println(n);
		}
		hotlist = utilService.getHot();
		bargainlist = utilService.getBargain();
		categorylist = utilService.getAllCategory();
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

	public List<EbNews> getNewslist() {
		return newslist;
	}

	public void setNewslist(List<EbNews> newslist) {
		this.newslist = newslist;
	}

	public List<EbNotice> getNoticelist() {
		return noticelist;
	}

	public void setNoticelist(List<EbNotice> noticelist) {
		this.noticelist = noticelist;
	}

	public List<EbProCategory> getCategorylist() {
		return categorylist;
	}

	public void setCategorylist(List<EbProCategory> categorylist) {
		this.categorylist = categorylist;
	}

	public List<EbProduct> getBargainlist() {
		return bargainlist;
	}

	public void setBargainlist(List<EbProduct> bargainlist) {
		this.bargainlist = bargainlist;
	}

	public List<EbProduct> getHotlist() {
		return hotlist;
	}

	public void setHotlist(List<EbProduct> hotlist) {
		this.hotlist = hotlist;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EbNews getNews() {
		return news;
	}

	public void setNews(EbNews news) {
		this.news = news;
	}

	public EbNotice getNotice() {
		return notice;
	}

	public void setNotice(EbNotice notice) {
		this.notice = notice;
	}
}
