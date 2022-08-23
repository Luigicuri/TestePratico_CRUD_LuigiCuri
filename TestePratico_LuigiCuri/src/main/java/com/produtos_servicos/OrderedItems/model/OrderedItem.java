package com.produtos_servicos.OrderedItems.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import com.produtos_servicos.items.model.Item;

@Entity
@Table(name = "ordered_items")

public class OrderedItem {
	private Long id;
	//tratar orderId
	//tratar itemId
	private double quantity;
	private double totalValue;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "quantity", nullable = false)
	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	@Column(name = "total_value", nullable = false)
	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}
	
	

	//constructor
	public OrderedItem() {
		super();
	}
	
	public OrderedItem(double quantity, double totalValue, Item itemId) {
		super();
		this.quantity = quantity;
		this.totalValue = totalValue;
	}
	
	
}
