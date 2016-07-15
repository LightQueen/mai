package org.sshTest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.sshTest.dao.CategoryDao;
import org.sshTest.dao.NewsDao;
import org.sshTest.dao.NoticeDao;
import org.sshTest.dao.UserDao;
import org.sshTest.entity.EbNews;
import org.sshTest.entity.EbNotice;
import org.sshTest.entity.EbProCategory;
import org.sshTest.entity.EbUser;

import java.util.List;
import java.util.Locale;

@Service
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class UtilService {
	@Autowired
	private NoticeDao noticeDao;
	@Autowired
	private NewsDao newsDao;
	@Autowired
	private CategoryDao categoryDao;

	@Transactional(propagation=Propagation.REQUIRED)
	public EbNews getNews(Integer id){
		return newsDao.getById(id);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public EbNotice getNotice(Integer id){
		return noticeDao.getById(id);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public List<EbNews> getAllNews(){
		return (List<EbNews> )newsDao.getAll();
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public List<EbNotice> getAllNotice(){
		return (List<EbNotice>)noticeDao.getAll();
	}


	@Transactional(propagation=Propagation.REQUIRED)
	public List<EbProCategory> getAllCategory(){
		return (List<EbProCategory>)categoryDao.getAll();
	}
}
