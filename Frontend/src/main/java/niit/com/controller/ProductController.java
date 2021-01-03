package niit.com.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cdt.com.Backend.DAO.CategoryDaoIntf;
import cdt.com.Backend.DAO.ProductDAOImpl;
import cdt.com.Backend.model.Category;
import cdt.com.Backend.model.Product;

@Controller
public class ProductController {
	
	@Autowired
    ProductDAOImpl productDAO;
	
	@Autowired
	CategoryDaoIntf categoryDAO;
	
	@RequestMapping("product")
  public String showProduct(Model m)
  {
	Product product=new Product();
	List<Product> productList=productDAO.listProducts();
	
	m.addAttribute("product", product);
	m.addAttribute("productList", productList);
	
	List<Category> categoryList=categoryDAO.listCategories();
	m.addAttribute("categoryList",this.getCategoryList(categoryList));
	
	   return "Product";
   }
	
	public LinkedHashMap<Integer,String> getCategoryList(List<Category> categoryList)
	{
		LinkedHashMap<Integer,String> categoryList1=new LinkedHashMap<Integer,String>();
		
		for(Category category:categoryList)
		{
			categoryList1.put(category.getCategoryId(), category.getCategoryName());
		}
		return categoryList1;
	}
	
	@RequestMapping(value="/InsertProduct",method=RequestMethod.POST)
	public String insertProduct(@ModelAttribute("product")Product product,@RequestParam("pimage")MultipartFile filedet,Model m)
	{
		Product product1=new Product();
		m.addAttribute("product", product1);
		
		productDAO.addProduct(product);
		
		
		String imagePath="\\indhu\\CDT_DT\\B2028940\\CustomersView\\src\\main\\webapp\\resources\\images\\";
		imagePath=imagePath+String.valueOf(product.getProdid())+".jpg";
		
		File imageFile=new File(imagePath);
		
		if(!filedet.isEmpty())
		{
			try
			{
				byte fileBuffer[]=filedet.getBytes();
				FileOutputStream fos=new FileOutputStream(imageFile);
				BufferedOutputStream bs=new BufferedOutputStream(fos);
				bs.write(fileBuffer);
				bs.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		else
		{
			System.out.println("Error Occured While File Uploading");
		}
		
		List<Product> productList=productDAO.listProducts();
		
		m.addAttribute("productList", productList);
		
		List<Category> categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList", this.getCategoryList(categoryList));
		
		return "Product";
	}
	
	@RequestMapping(value="/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable("productId")int productId,Model m)
	{
		Product product1=new Product();
		m.addAttribute("product", product1);
		
		Product product=productDAO.getProduct(productId);
		productDAO.deleteProduct(product);
		
		List<Product> productList=productDAO.listProducts();
		m.addAttribute("productList", productList);
		
		List<Category> categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList",this.getCategoryList(categoryList));
		
		return "Product";
	}
	
	@RequestMapping(value="/editProduct/{prodid}")
	public String editProduct(@PathVariable("prodid")int productId,Model m)
	{
		Product product1=productDAO.getProduct(productId);
		m.addAttribute("product", product1);
		
		List<Product> productList=productDAO.listProducts();
		m.addAttribute("productList", productList);
		
		List<Category> categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList",this.getCategoryList(categoryList));
		return "UpdateProduct";
	}
	@RequestMapping(value="/Updateproducts", method=RequestMethod.POST)
	public String updateProd(@ModelAttribute("product")Product product,HttpServletRequest request,Model m)
	{
	   System.out.println("First");
		   m.addAttribute("categoryList",categoryDAO.listCategories());
			   		
		   System.out.println("Add image");
		MultipartFile img=product.getPimage();
		System.out.println("Path : "+request.getServletContext().getRealPath("/"));
		//Defining a path
		Path path=Paths.get(request.getServletContext().getRealPath("/")+"/resources/images/"+product.getProdid()+".jpg");
		//transfer the image to the file
		
		product.setPimage(img);
		
		System.out.println("Check image");
		if(!img.isEmpty()&&img!=null){
			try {
				img.transferTo(new File(path.toString()));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 System.out.println("Before update");
	
		 productDAO.updateProduct(product);
		 
		 System.out.println("After update");
		 
		return "UpdateProduct";
	}


	@RequestMapping(value="/productdisplay")
	public String productDisplay(Model m)
	{
		List<Product> productList=productDAO.listProducts();
		m.addAttribute("productList", productList);
		
		List<Category> categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList",this.getCategoryList(categoryList));
		
		return "productDisplay";
	}
	
	@RequestMapping(value="/totalProductDisplay/{prodid}")
	public String totalProductDisplay(@PathVariable("prodid")int productId,Model m)
	{
		Product product1=productDAO.getProduct(productId);
		m.addAttribute("product", product1);
		List<Product> productList=productDAO.listProducts();
		m.addAttribute("productList", productList);
		
		List<Category> categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList",this.getCategoryList(categoryList));
		
		return "allProducts";
	}

	@RequestMapping(value="/allproducts")
	public String Allproducts(Model m)
	{
		List<Product> productList=productDAO.listProducts();
		m.addAttribute("productList", productList);
		
		List<Category> categoryList=categoryDAO.listCategories();
		m.addAttribute("categoryList",this.getCategoryList(categoryList));
		
		return "productDisplay";
	}	
	
	

}
