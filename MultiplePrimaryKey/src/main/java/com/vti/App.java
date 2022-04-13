package com.vti;

import com.vti.entity.Order;
import com.vti.repository.OrderRepository;

public class App {
	public static void main(String[] args) {
		OrderRepository repository = new OrderRepository();

		Order.OrderPK pk = new Order.OrderPK();
		pk.setOrderId(2);
		pk.setProductId(3);

		Order order = new Order();
		order.setId(pk);
		order.setTitle("Order 4");

		repository.createOrder(order);
	}
}




