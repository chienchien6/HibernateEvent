package model;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import util.HibernateUtil;



public class MyMemberDao {
	
	private SessionFactory factory;
	
	public MyMemberDao() {
		this.factory = HibernateUtil.getSessionFactory();
	}
	
	public MyMember findByUsernameAndPwd(String username, String pwd) {
		Session session = factory.getCurrentSession();
		
		String hql = "from MyMember m where m.memberName = :nn and m.memberPwd = :pwd";
		
		try {
			Query<MyMember> query = session.createQuery(hql, MyMember.class)
					.setParameter("nn", username)
					.setParameter("pwd", pwd);
					
			MyMember result = query.getSingleResult();
			
			return result;
		}catch(NoResultException e) {
//			System.out.println(e);  // debug 再打開
			return null;
		}
		
		
		
		
		
	}

}
