package entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

private int id;
private int userId;
private Date submitDate;
private double totalPrice;
public Order(int id, int userId, Date submitDate) {
	super();
	this.id = id;
	this.userId = userId;
	this.submitDate = submitDate;
}


}
