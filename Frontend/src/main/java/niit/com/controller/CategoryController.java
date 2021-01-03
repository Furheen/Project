package niit.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cdt.com.Backend.DAO.CategoryDaoIntf;
import cdt.com.Backend.model.Category;

@Controller
public class CategoryController {

	@Autowired
	CategoryDaoIntf categoryDAO;
	
	@RequestMapping(value="/category")
	public String showCategoryPage(Model m)
	{
		List<Category> categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList", categoryList);
		
		return "Category";
	}

	@RequestMapping(value="/insertCategory",method=RequestMethod.POST)
	public String insertCategory(@RequestParam("catName")
	String categoryName,@RequestParam("catDesc")
	String catDesc,Model m)
	{
		Category category=new Category();
		category.setCategoryName(categoryName);
		category.setCategoryDesc(catDesc);
		
		categoryDAO.addCategory(category);
		
		List<Category> categoryList=categoryDAO.
				listCategories();
		m.addAttribute("categoryList", categoryList);
		
		return "Category";
	}
	
	@RequestMapping("/deleteCategory/{categoryId}")
	public String deleteCategory(@PathVariable("categoryId")
	int categoryId,Model m)
	{
		Category category=categoryDAO.
				getCategory(categoryId);
		
		categoryDAO.deleteCategory(category);
		
		List<Category> categoryList=categoryDAO.
				listCategories();
		m.addAttribute("categoryList", categoryList);
		
		return "Category";
		
	}
	
	@RequestMapping("/editCategory/{categoryId}")
	public String editCategory(@PathVariable("categoryId")
	int categoryId,Model m)
	{
		Category category=categoryDAO.
				getCategory(categoryId);
		m.addAttribute("category",category);
		return "UpdateCategory";
	}
	
	@RequestMapping(value="/updateCategory",
			method=RequestMethod.POST)
	public String updateCategoryPage(@RequestParam("catId")
	int categoryId,@RequestParam("catName")
	String categoryName,@RequestParam("catDesc")
	String catDesc,Model m)
	{
		Category category=categoryDAO.
				getCategory(categoryId);
		
		System.out.println("Testing");
		category.setCategoryName(categoryName);
		category.setCategoryDesc(catDesc);
		 
		System.out.println("Updation");
		categoryDAO.updateCategory(category);
		
		List<Category> categoryList=categoryDAO.
				listCategories();
		m.addAttribute("categoryList", categoryList);
		
		return "Category";
	}
}
