package cdt.com.Backend.model;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class OrderDetail {

	@Id
	@GeneratedValue
	int orderId;
	String username;
	Date orderDate;
	double totalShoppingAmount;
	String pmode;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public double getTotalShoppingAmount() {
		return totalShoppingAmount;
	}
	public void setTotalShoppingAmount(double totalShoppingAmount) {
		this.totalShoppingAmount = totalShoppingAmount;
	}
	public String getPmode() {
		return pmode;
	}
	public void setPmode(String pmode) {
		this.pmode = pmode;
	}
	
}
