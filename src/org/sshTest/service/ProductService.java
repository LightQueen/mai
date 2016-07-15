package org.sshTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.sshTest.dao.ProductDao;
import org.sshTest.dao.UserDao;
import org.sshTest.entity.EbProduct;

@Service
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class ProductService {
	@Autowired
	private ProductDao productDao; 

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public List<EbProduct> getProductPage(int pageIndex,int pageSize){
		return productDao.getProductPage( pageIndex, pageSize);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public Integer getSize(){
		return productDao.getSize();
	}



	@Transactional(propagation=Propagation.REQUIRED)
	public List<EbProduct> getAll(){
		return productDao.getAll();
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public EbProduct getById(Integer id){
		return productDao.getById(id);
	}
	
	
}
