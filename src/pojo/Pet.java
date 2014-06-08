package pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Pet {


	private int id;
	private Player master;
	private String name;
	private String skill;
	
	public Pet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pet(String name, String skill) {
		super();
		this.name = name;
		this.skill = skill;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	@OneToOne(mappedBy="pet")
	public Player getMaster() {
		return master;
	}
	public String getName() {
		return name;
	}
	public String getSkill() {
		return skill;
	}
	public void setId(int id) {
		this.id = id;
	}

	public void setMaster(Player master) {
		this.master = master;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	
	
	

}
