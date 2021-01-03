package cdt.com.Backend.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cdt.com.Backend.model.UserDetails;

@Repository("UserDAO")
@Transactional
public class UserDAOImpl  implements UserDAO{
	
	@Autowired
	SessionFactory sessionFactory;

	public boolean registerUser(UserDetails userDetail) {
		try
		{
		sessionFactory.getCurrentSession().save(userDetail);
		System.out.println("Registered");
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean updateUser(UserDetails userDetail) {
		try
		{
		sessionFactory.getCurrentSession().update(userDetail);
		return true;
	}
		catch(Exception e)
		{
			return false;
		}
	}
	

	public UserDetails getUser(String username) {
		Session session=sessionFactory.openSession();
		UserDetails user=session.get(UserDetails.class, username);
		session.close();
		return user;
		
	}

	

	
}
