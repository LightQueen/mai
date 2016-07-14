package org.sshTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.sshTest.dao.UserDao;
import org.sshTest.entity.EbUser;

@Service
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class UserService {
	@Autowired
	private UserDao userDao;

	@Transactional(propagation=Propagation.REQUIRED)
	public List<EbUser> getAllUsers(){
		return userDao.getAll();
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public EbUser getUserById(Integer id){
		return userDao.getById(id);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public EbUser login(EbUser user){
		return userDao.login(user);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void register(EbUser user){
		userDao.saveOrUpdate(user);
	}
}
