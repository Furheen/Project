package cdt.com.Backend.DAO;

import cdt.com.Backend.model.OrderDetail;

public interface OrderDAO 
{

	public boolean payment(OrderDetail orderDetail);
	public boolean updateCartItemStatus(String username,int orderId);
	
}