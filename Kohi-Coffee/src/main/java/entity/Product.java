package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	private int id;
	private String name;
	private int price;
	private String imgName;
	private boolean isNew;
	private int quantity;
	private String description;
	
	 public boolean isNew() {
	        return isNew;
	    }

}
