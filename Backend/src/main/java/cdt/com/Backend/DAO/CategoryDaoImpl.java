package cdt.com.Backend.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cdt.com.Backend.model.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDaoImpl implements CategoryDaoIntf
{
	@Autowired
	SessionFactory sessionFactory;

	public boolean addCategory(Category category) 
	{
		try
		{
			System.out.println("Impl");
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		System.out.println("Impl Test");
		return true;	
		}
		catch(Exception e)
		{
		return false;
		}
	
		
		
		
	}

	public boolean deleteCategory(Category category)
	{
		try
		{
		sessionFactory.getCurrentSession().delete(category);
		return true;	
		}
		catch(Exception e)
		{
		return false;
		}
	
		
	}

	public boolean updateCategory(Category category) 
	{
		try
		{
		sessionFactory.getCurrentSession().update(category);
		return true;	
		}
		catch(Exception e)
		{
		return false;
		}

		
	}

	public Category getCategory(int categoryId) 
	{
		Session session=sessionFactory.openSession();
		Category category=(Category)session.get(Category.class,categoryId);
		session.close();
		return category;

	
	}

	public List<Category> listCategories()
	{
		Session session=sessionFactory.openSession();
		List<Category> listCategories=(List<Category>)session.createQuery("from Category").list();
		session.close();
		return listCategories;
	}



}
