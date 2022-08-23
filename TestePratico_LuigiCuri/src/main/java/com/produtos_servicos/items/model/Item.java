package com.produtos_servicos.items.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "items")
public class Item {
	
	private Long id;
	
	private String description;
	private double value;
	private char type;
	
	
	//default constructor
	public Item() {
		super();
	}
	//constructor
	public Item(String description, double value, char type) {
		super();
		this.description = description;
		this.value = value;
		this.type = type;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "description", nullable = false)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Column(name = "value", nullable = false)
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	@Column(name = "type", nullable = false)
	public char getType() {
		return type;
	}
	public void setType(char type) {
		this.type = type;
	}
	
	@Override
    public String toString() {
        return "Item [id=" + id + ", description=" + description + ", value=" + value + ", type=" + type
       + "]";
    }

	
	
	
	
}
