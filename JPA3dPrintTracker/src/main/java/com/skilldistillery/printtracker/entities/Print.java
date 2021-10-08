package com.skilldistillery.printtracker.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Print {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private Integer duration;

	@Column(name = "material_consumed")
	private double materialConsumed;

	@Column(name = "photo_url")
	private String photoUrl;

	// Methods

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

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public double getMaterialConsumed() {
		return materialConsumed;
	}

	public void setMaterialConsumed(double materialConsumed) {
		this.materialConsumed = materialConsumed;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public Print() {
		super();
	}

	@Override
	public String toString() {
		return "Print [id=" + id + ", name=" + name + ", duration=" + duration + ", materialConsumed="
				+ materialConsumed + ", photoUrl=" + photoUrl + "]";
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
		Print other = (Print) obj;
		return id == other.id;
	}

}
