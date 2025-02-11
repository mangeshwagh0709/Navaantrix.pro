package Tech.hub.SepExamMvc.Service;


import java.util.List;

import Tech.hub.SepExamMvc.Model.Product;

public interface ProductService 
{
	public String ProductDATA (Product p);
	
     public List<Product> ViewProductData();
     
     public String Addsubpro(String name, String unit, int subproductId);
     
     public String deleteProductById(int productId);
     
     


}
