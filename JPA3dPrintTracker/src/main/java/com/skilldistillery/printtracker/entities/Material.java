package com.skilldistillery.printtracker.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@OneToMany(mappedBy="material")
	@JsonIgnore
	private List<Print> prints;
	
	@ManyToOne
	@JoinColumn(name="material_type_id")
	private MaterialType materialType;
	
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

	public List<Print> getPrints() {
		return prints;
	}

	public void setPrints(List<Print> prints) {
		this.prints = prints;
	}

	public MaterialType getMaterialType() {
		return materialType;
	}

	public void setMaterialType(MaterialType materialType) {
		this.materialType = materialType;
	}

	public Material() {
		super();
	}

	@Override
	public String toString() {
		return "Material [id=" + id + ", name=" + name + ", cost=" + cost + ", color=" + color + ", prints=" + prints
				+ ", materialType=" + materialType + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return id == other.id;
	}

	
	
	

}
