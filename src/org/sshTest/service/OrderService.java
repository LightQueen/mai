package org.sshTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.sshTest.dao.OrderDao;
import org.sshTest.dao.UserDao;
import org.sshTest.entity.EbOrder;
import org.sshTest.entity.EbUser;

@Service
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class OrderService {
	@Autowired
	private OrderDao orderDao;

	@Transactional(propagation=Propagation.REQUIRED)
	public List<EbOrder> getAll(){
		return orderDao.getAll();
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public EbOrder getById(Integer id){
		return orderDao.getById(id);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public EbOrder buy(){
		EbOrder order = new EbOrder();
		orderDao.saveOrUpdate(order);
		return null;
	}
	
}
