package cdt.com.Backend.DAO;

import java.util.List;

import cdt.com.Backend.model.Product;

public interface productDAO {

	public boolean addProduct(Product product);
	public boolean deleteProduct(Product product);
	public boolean updateProduct(Product product);
	public List<Product> listProducts();
	public Product getProduct(int productId);
	public List<Product> listProductCategoryWise(int categoryId);
	
}
