package Tech.hub.SepExamMvc.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Tech.hub.SepExamMvc.Model.Product;
import Tech.hub.SepExamMvc.Repository.ProductRepositoryImpl;



    @Service("Servicepro")
 	public class ProductServiceImpl implements ProductService {
 		
 		@Autowired
 		ProductRepositoryImpl  Repopro;
 		
		@Override
		public String ProductDATA(Product p) 
		{
			return Repopro.ProductDATA(p);
		}

		@Override
		public List<Product> ViewProductData() {
			
			return Repopro.ViewProductData();
		}

		@Override
		public String Addsubpro(String name, String unit, int subproductId) {
			
			return Repopro.Addsubpro(name, unit, subproductId);
		}

		@Override
		public String deleteProductById(int productId) {
			return Repopro.deleteProductById(productId);
		}

 	 
 	}
