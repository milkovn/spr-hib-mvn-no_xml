package net.nemanja.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="teams")
public class Team {

	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	private String rating;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Team() {
		super();
	}

	public Team(String name, String rating) {
		super();
		this.name = name;
		this.rating = rating;
	}

	public String toString(){
		return "(Team)[id = " + id + ", name = " + name + "]";
	}
}
