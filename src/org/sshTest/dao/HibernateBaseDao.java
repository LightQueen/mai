package org.sshTest.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class HibernateBaseDao<T> {
	@Resource
	protected SessionFactory sessionFactory;

	protected Class<T> entity;

	public HibernateBaseDao() {
		entity = (Class<T>) ((ParameterizedType) (getClass()
				.getGenericSuperclass())).getActualTypeArguments()[0];
		System.out.println(entity);
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public List<T> getAll() {
		List<T> list =getSession().createCriteria(entity).list();
		for(T t : list){
			System.out.println(t.toString());
		}
		return list;
	}

	public T getById(Integer id) {
		return (T) getSession().load(entity, id);
	}

	public void saveOrUpdate(Object obj) {
		getSession().saveOrUpdate(obj); 
	}
	
        
    public int excuteBySql(String sql)    
    {    
        int result ;    
        SQLQuery query = this.getSession().createSQLQuery(sql);    
        result = query.executeUpdate();    
        return result;    
    }
}
