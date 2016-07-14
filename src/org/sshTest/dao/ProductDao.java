package org.sshTest.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.sshTest.entity.EbProduct;
import org.sshTest.entity.EbUser;

@Repository
public class ProductDao extends HibernateBaseDao<EbProduct> {
	public List<EbProduct> getProductPage(int pageIndex, int pageSize) {
		System.out.println("i'm in dao");
		int start = (pageIndex - 1) * pageSize;
		Session session = getSession();
		List<EbProduct> list = null;
		List<EbUser> list2 = null;
		try {
			System.out.println("n");
			Query q2 = getSession().createQuery("from EbProduct ");
			
			list = (List<EbProduct>) q2.list();
//			Query q = session.createQuery("from EbProduct ").setFirstResult(start).setMaxResults(pageSize);
//			if (q == null)
//				System.out.println("null");
//			list = (List<EbProduct>) q.list();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("yi");
		}
		for (EbProduct p : list) {
			System.out.print("en" + p);
		}
//		for (EbUser p : list2) {
//			System.out.print("en" + p);
//		}
		return list;
	}

	public static void main(String[] args) {
		ProductDao pd = new ProductDao();
		pd.getProductPage(2, 4);
	}
}
