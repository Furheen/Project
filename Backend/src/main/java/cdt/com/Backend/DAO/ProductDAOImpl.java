package cdt.com.Backend.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cdt.com.Backend.model.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl  implements productDAO
{

	@Autowired
	SessionFactory sessionFactory;
	public boolean adddProduct(Product product)
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(product);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}
	public boolean deleteProduct(Product product) 
	{
       try
       {
    	  sessionFactory.getCurrentSession().delete(product);
    	  return true;
       }
		catch(Exception e)
       {
			System.out.println(e);
			return false;
       }
	}
	public boolean updateProduct(Product product) 
	{
	
		try
		{
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	public List<Product> listProducts() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product");
		List<Product> productList=query.list();
		session.close();
		return productList;
		
	}
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}
	public Product getProduct(int productId) {
		{
			Session session=sessionFactory.openSession();
			Product product=session.get(Product.class,productId);
			session.close();
			return product;	
		}
	}
	public List<Product> listProductCategoryWise(int categoryId) {
		{
			
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from Product where categoryId=:catid");
			query.setParameter("catid", categoryId);
			List<Product> productList=query.list();
			session.close();
			return productList;
		}
	}
	
}
