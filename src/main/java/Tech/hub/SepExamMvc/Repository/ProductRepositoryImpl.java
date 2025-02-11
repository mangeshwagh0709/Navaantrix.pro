package Tech.hub.SepExamMvc.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import Tech.hub.SepExamMvc.Model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("Repopro")
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private JdbcTemplate template;

    @Override
    public String ProductDATA(final Product p) 
    {

    	System.out.println("--->"+p.getName());
		System.out.println("----->"+p.getType());
    	
       int val=template.update("insert into Product values('0',?,?) ",new PreparedStatementSetter()
    		   {

				@Override
				public void setValues(PreparedStatement ps) throws SQLException 
				{
	
				
				System.out.println("=<===>"+p.getName());
				System.out.println("<====>"+p.getType());

					
				   ps.setString(1,p.getName());
				   ps.setString(2,p.getType());
				   	   
					
				}
    	   
    		   });
   
         return val > 0 ? "Data inserted" : "Not inserted";
         
             
         
    }

	@Override
	public List<Product> ViewProductData() 
	{
		
		String sql = "SELECT p.product_id AS Product_ID, " +
                "p.name AS Product_Name, " +
                "p.type AS Product_Type, " +
                "sp.subproduct_id AS SubProduct_ID, " +
                "sp.unit AS Unit, " +
                "sp.subproname AS Sub_Product " +
                "FROM Product p " +
                "JOIN SubProduct sp ON p.product_id = sp.product_id";

   List<Product> productList = template.query(sql, new RowMapper<Product>() {
       @Override
       public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
           Product product = new Product();
           product.setProductId(rs.getInt("Product_ID"));   
           product.setName(rs.getString("Product_Name"));
           product.setType(rs.getString("Product_Type"));
           product.setProductId(rs.getInt("SubProduct_ID"));  
           product.setUnit(rs.getString("Unit"));
           product.setSubproname(rs.getString("Sub_Product"));

 
           

           return product;
       }
   });

   return productList;
		
		
		
    
          
            
    
	}


	@Override
	public String Addsubpro(String name, String unit, int productId) {
	    String sql = "INSERT INTO subproduct (product_id, unit, subproname) VALUES (?, ?, ?)";

	    int val = template.update(sql, new PreparedStatementSetter() 
	    {
	        @Override
	        public void setValues(PreparedStatement ps) throws SQLException 
	        {
	            System.out.println("📌 Selected Product Name: " + name);
	            System.out.println("📌 Selected Product Type: " + unit);
	            System.out.println("📌 Selected SubProduct ID: " + productId);

	            ps.setInt(1, productId);  
	            ps.setString(2, unit);   
	            ps.setString(3, name);   // Changed "name" to "subproname" as per your DB
	        }
	    });

	    return val > 0 ? "Data inserted" : "Not inserted";
	}

	public String deleteProductById(int productId) {
	    String sql = "DELETE FROM subproduct WHERE product_id = ?";
	    int rowsAffected = template.update(sql, productId);

	    return rowsAffected > 0 ? "Product deleted successfully" : "Product not found";
	}


	

}








































//
//
//
//
//
//
//
//
//
//
//
//package org.tech.repository;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//import org.tech.model.AreaModel;
//import org.tech.model.CityModel;
//import org.springframework.jdbc.core.PreparedStatementSetter;
//import org.springframework.jdbc.core.RowMapper;
//
//@Repository("arearepo")
//public class Arearepoimpl implements Arearepo{
//
//	@Autowired
//	JdbcTemplate template;
//	List<AreaModel> list;
//
////	@Autowired
//
//	
//	@Override
//	public boolean isAddNewArea(final AreaModel amodel) 
//	{
//		int val=template.update("insert into areamaster values('0',?)",new PreparedStatementSetter()
//				{
//
//					@Override
//					public void setValues(PreparedStatement ps) throws SQLException {
//					ps.setString(1,amodel.getAname());
//						
//					}
//			
//				});
//		
//		return val>0 ? true:false;
//	}
//	
//
//	@Override
//	public List<AreaModel> isviewArea() {
//		
//		list=template.query("select * from areamaster",new RowMapper<AreaModel>()
//				{
//
//					@Override
//					public AreaModel mapRow(ResultSet rs, int rowNum) throws SQLException {
//						
//						AreaModel amodel=new AreaModel();
//						amodel.setAid(rs.getInt("arid"));
//						amodel.setAname(rs.getNString("arname"));
//						
//						return amodel;
//					}
//			
//				});
//		
//		return list.size()>0 ? list:null;
//		
//	}
//
//
//	@Override
//	public boolean isDeleteArea(int aid) {
//		
//		int val=template.update("delete from areamaster where arid="+aid);
//		
//		
//		return val>0? true:false;
//	}
//
//
//	@Override
//	public boolean isAreaUpdate(final AreaModel amodel) {
//		
//		int val=template.update("update areamaster set arname=? where arid=? ",new PreparedStatementSetter()
//				{
//
//					@Override
//					public void setValues(PreparedStatement ps) throws SQLException {
//						ps.setString(1,amodel.getAname());
//						ps.setInt(2,amodel.getAid());
//						
//					}
//			
//				});
//		
//		
//		return val>0 ? true:false;
//	}
//
//
//	@Override
//	public List<AreaModel> findAreasByCity(int cityId) {
//	
//		list=template.query("select a.arid, a.arname from cityareajoin ca join areamaster a on ca.arid = a.arid where ca.ctid ="+cityId, new RowMapper<AreaModel>(){
//
//			@Override
//			public AreaModel mapRow(ResultSet rs, int rowNum) throws SQLException {
//			
//				AreaModel amodel=new AreaModel();
//				amodel.setAid(rs.getInt("arid"));
//				amodel.setAname(rs.getString("arname"));
//				
//				return amodel;
//			
//			}
//			
//		});
//		
//		return list.size()>0? list:null;
//	}
//
//
//	@Override
//	public List<AreaModel> SearchArea(String aname) {
//		
//		System.out.println("repo area search data "+aname);
//		
//		list=template.query("SELECT * FROM areamaster WHERE arname LIKE '%"+aname+"%'",new RowMapper<AreaModel>()
//		{
//
//			@Override
//			public AreaModel mapRow(ResultSet rs, int rowNum) throws SQLException {
//				
//				AreaModel amodel=new AreaModel();
//				amodel.setAname(rs.getString("arname"));
//				amodel.setAid(rs.getInt("arid"));
//				
//				return amodel;
//			}
//	
//		});
//
//	
//return list;
//		
//	}
//
//	
//	
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
