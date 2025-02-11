package Tech.hub.SepExamMvc.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.tech.ExamApk.service.Employeeserviceimpl;

import Tech.hub.SepExamMvc.Model.Product;
import Tech.hub.SepExamMvc.Service.ProductService;
import Tech.hub.SepExamMvc.Service.ProductServiceImpl;

@Controller
public class HomeController {

	@Autowired
	ProductServiceImpl Servicepro;
	

	    @RequestMapping("/")
	    public ModelAndView home() 
	    {
	        return new ModelAndView("home");
	    }

	    
	    
	    
	    @RequestMapping("/bookdata")
	    public String addnewproduct(Product p,Map map)
	    {
	    	   List<Product> products = Servicepro.ViewProductData();
		       
		        map.put("pdata", products);
		        
	    	Servicepro.ProductDATA(p);
	    
			return null;
	    }
	    
	    
	    @RequestMapping("/SubProPage")
	    public String SubProPage(Map map)
	    {
	    	   List<Product> products = Servicepro.ViewProductData();
		       
		        map.put("pdata", products);
		        
		        
			return "SubPro";	
	    }
	    
	    
	    @RequestMapping("/viewprodata")
	    public String getAllProducts(Map map) 
	    {
	        List<Product> products = Servicepro.ViewProductData();
	       
	        map.put("pdata", products);
	        
			return "ViewProduct";
	        
	    }
	    
	    
	    @RequestMapping("/addsubpro")
	    public String addSubProduct(
	            @RequestParam("name") String name,
	            @RequestParam("unit") String unit,
	            @RequestParam("subproduct_id") int productId, 
	            Model model
	        ) {
	            String result = Servicepro.Addsubpro(name, unit, productId);

	            model.addAttribute("message", result);

	            return "redirect:/subproductList";  
	        }
	    
	    
	    @RequestMapping("/deleteemp")
	    public String deleteProduct(Map map,@RequestParam("Bdid") int productId) 
	    {
	        String result = Servicepro.deleteProductById(productId);
	        
	        List<Product> products = Servicepro.ViewProductData();
		       
	        map.put("pdata", products);
	    
			return "ViewProduct";
	        	    
	        
	    }

	    

	    

}