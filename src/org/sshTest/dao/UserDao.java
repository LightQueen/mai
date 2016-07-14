package org.sshTest.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.sshTest.entity.EbUser;

@Repository
public class UserDao extends HibernateBaseDao<EbUser> {
	public EbUser login(EbUser user) {
		
		Session session = getSession();
		
		EbUser entity=null;
		try{
			entity = (EbUser) session
			.createQuery(
					"from EbUser t where t.name=:name and t.password=:pass")
			.setParameter("name", user.getName())
			.setParameter("pass", user.getPassword()).uniqueResult();
		}catch (RuntimeException e) {
			e.printStackTrace();
		}
		return entity;
	}
}
