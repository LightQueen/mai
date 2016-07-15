package org.sshTest.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.sshTest.entity.EbNews;
import org.sshTest.entity.EbUser;

@Repository
public class NewsDao extends HibernateBaseDao<EbNews> {

}
