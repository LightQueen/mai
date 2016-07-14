package org.sshTest.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.sshTest.entity.EbProduct;
import org.sshTest.entity.EbUser;

@Repository
public class ProductDao extends HibernateBaseDao<EbProduct> {

	public Integer getSize(){
		Integer size = 0;
		try{
			size = (Integer) getSession().createQuery("select count (*) from EbProduct").uniqueResult();
		}catch (Exception e){
			e.printStackTrace();
		}
		return size;
	}

	public List<EbProduct> getProductPage(int pageIndex, int pageSize) {
		int start = (pageIndex - 1) * pageSize;
		Session session = getSession();
		List<EbProduct> list = null;
		try {
			Query q = session.createQuery("from EbProduct ").setFirstResult(start).setMaxResults(pageSize);
			list = (List<EbProduct>) q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void main(String[] args) {
		ProductDao pd = new ProductDao();
		pd.getProductPage(2, 4);
	}
}
