package org.sshTest.web;

import java.util.*;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.sshTest.entity.*;
import org.sshTest.service.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Results({ 
	@Result(name = "login", type = "redirect", location = "user!list.action"),
	@Result(name = "error", location = "/error.jsp")
})
public class UserAction extends ActionSupport {
	@Autowired
	private UserService userService;
	
	private List<EbUser> users;
	private Integer id;
	private EbUser user;
	private String cue;
	
	public String getCue() {
		return cue;
	}

	public void setCue(String cue) {
		this.cue = cue;
	}

	public List<EbUser> getUsers() {
		return users;
	}

	public void setUsers(List<EbUser> users) {
		this.users = users;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public EbUser getUser() {
		return user;
	}

	public void setUser(EbUser user) {
		this.user = user;
	}

	public String list() throws Exception {//Deprecated
		users = userService.getAllUsers();
		return "success";
	}

	public String input() throws Exception {//Deprecated
		
		System.out.println("id="+id);
		
		if(id != null){
			user = userService.getUserById(id);
		}else {
			user = new EbUser();
		}
		return INPUT;
	}
	
	public Map session(){
		ActionContext ac = ActionContext.getContext();
		return ac.getSession();
	}
	
	public Map app(){
		ActionContext ac = ActionContext.getContext();
		return ac.getApplication();
	}
	
	public String clear(){
		session().clear();
		app().clear();
		return "clear";
	}
	
	public String login() {
		if(session().get("user")==null){
			user = userService.login(user);
			session().put("user", user);
			return "login";
		}
		cue = "ÄúÒÑµÇÂ½";
		return "error";
	}
	
	public String register(){//±£Ö¤nameÎ¨Ò»
		if(user!=null){
			userService.register(user);//ÊÇ·ñ·µ»ØÅÐ¶Ï
			return "register";
		}
		cue = "×¢²áÊ§°Ü";
		return "error";
	}
	
	
}
