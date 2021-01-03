package cdt.com.Backend.DAO;

import java.util.List;

import cdt.com.Backend.model.Category;

public interface CategoryDaoIntf {

	public boolean addCategory(Category category);
	public boolean deleteCategory(Category category);
	public boolean updateCategory(Category category);
	public Category getCategory(int categoryId);
	public List<Category> listCategories();
}
