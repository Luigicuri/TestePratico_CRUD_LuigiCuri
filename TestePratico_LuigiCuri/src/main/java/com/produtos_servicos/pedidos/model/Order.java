package com.produtos_servicos.pedidos.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.produtos_servicos.OrderedItems.model.OrderedItem;
@Entity
@Table(name = "orders")
public class Order {
	private Long id;
	private int number;
	private Date timestamp;
	private double percentualDiscount;
	private double totalValue;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "number", nullable = false)
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	@Column(name = "timestamp", nullable = false)
	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	@Column(name = "percentual_discount", nullable = false)
	public double getPercentualDiscount() {
		return percentualDiscount;
	}

	public void setPercentualDiscount(double percentualDiscount) {
		this.percentualDiscount = percentualDiscount;
	}
	@Column(name = "total_value", nullable = false)
	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}
	

	//constructor
	public Order() {
		super();
	}

	public Order(int number, Date timestamp, double percentualDiscount, double totalValue, OrderedItem orderedItem) {
		super();
		this.number = number;
		this.timestamp = timestamp;
		this.percentualDiscount = percentualDiscount;
		this.totalValue = totalValue;
	}
	@Override
    public String toString() {
        return "Order [id=" + id + ", number=" + number + ", timestamp=" + timestamp + ", percentualDiscount=" 
    + percentualDiscount + ", totalValue" + totalValue + "]";
    }
	
	
	
}
