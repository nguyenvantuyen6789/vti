package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "`Order`")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderPK id;

	private String title;

	public Order() {
	}

	public OrderPK getId() {
		return id;
	}

	public void setId(OrderPK id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Embeddable
	public static class OrderPK implements Serializable {

		private static final long serialVersionUID = 1L;

		@Column(name = "order_id")
		private Integer orderId;

		@Column(name = "product_id")
		private Integer productId;

		public OrderPK() {
		}

		public Integer getOrderId() {
			return orderId;
		}

		public void setOrderId(Integer orderId) {
			this.orderId = orderId;
		}

		public Integer getProductId() {
			return productId;
		}

		public void setProductId(Integer productId) {
			this.productId = productId;
		}
	}

}
