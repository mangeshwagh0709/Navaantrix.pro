package Tech.hub.SepExamMvc.Model;

import java.util.List;

public class Product extends SubProduct {
    private int id;
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<SubProduct> getSubProducts() {
		return subProducts;
	}
	public void setSubProducts(List<SubProduct> subProducts) {
		this.subProducts = subProducts;
	}
	private String name;
    private String type;
    private List<SubProduct> subProducts; 

}

