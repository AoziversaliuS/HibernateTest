package pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pet {


	private int id;
	private String name;
	private String skill;
	
	public Pet(String name, String skill) {
		super();
		this.name = name;
		this.skill = skill;
	}
	public Pet() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public String getSkill() {
		return skill;
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
	public void setSkill(String skill) {
		this.skill = skill;
	}
	
	
	

}
