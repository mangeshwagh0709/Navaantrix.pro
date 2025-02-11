package Tech.hub.SepExamMvc.Repository;

import java.util.List;

import Tech.hub.SepExamMvc.Model.Product;

public interface ProductRepository {
	
	public String ProductDATA(Product p);
	
    public List<Product> ViewProductData();
    
    public String Addsubpro(String name, String type, int subproductId);
    
    public String deleteProductById(int productId);
	
}
