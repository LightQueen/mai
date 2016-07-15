package org.sshTest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.sshTest.dao.NewsDao;
import org.sshTest.dao.NoticeDao;
import org.sshTest.dao.UserDao;
import org.sshTest.entity.EbNews;
import org.sshTest.entity.EbNotice;
import org.sshTest.entity.EbUser;

import java.util.List;

@Service
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class UtilService {
	@Autowired
	private NoticeDao noticeDao;
	private NewsDao newsDao;

	@Transactional(propagation=Propagation.REQUIRED)
	public EbNews getNews(Integer id){
		return newsDao.getById(id);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public EbNotice getNotice(Integer id){
		return noticeDao.getById(id);
	}

}
