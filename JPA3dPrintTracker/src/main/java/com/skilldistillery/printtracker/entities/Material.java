package com.skilldistillery.printtracker.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Material {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Column(name="cost_per_kilo")
	private double cost;
	
	private String color;
	
	private String material;
	
	@OneToMany(mappedBy="material")
	@JsonIgnore
	private List<Print> prints;
	
	//Methods

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public List<Print> getPrints() {
		return prints;
	}

	public void setPrints(List<Print> prints) {
		this.prints = prints;
	}

	public Material() {
		super();
	}

	@Override
	public String toString() {
		return "Material [id=" + id + ", name=" + name + ", cost=" + cost + ", color=" + color + ", material="
				+ material + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, cost, id, material, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Material other = (Material) obj;
		return Objects.equals(color, other.color)
				&& Double.doubleToLongBits(cost) == Double.doubleToLongBits(other.cost) && id == other.id
				&& Objects.equals(material, other.material) && Objects.equals(name, other.name);
	}
	
	

}
