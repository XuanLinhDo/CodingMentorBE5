package entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetails {
private int id;
private int orderId;
private int productId;
private int quantity;
private int price;
private double subtotal;

}
