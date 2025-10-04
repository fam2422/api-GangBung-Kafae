package project.model;

import jakarta.persistence.*;

public class OrderItem {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private Long menuId;
	private Long orderId;
	private int qty;
	
	public OrderItem(Long id, Long menuId, Long orderId, int qty) {
        this.id = id;
        this.menuId = menuId;
        this.orderId = orderId;
        this.qty = qty;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	
	
	
}
