package pojo;

import javax.persistence.Column;

public class Weapon {
	
	private String name;
	private int power;
	
	@Column(name="weapon_name")
	public String getName() {
		return name;
	}
	@Column(name="weapon_power")
	public int getPower() {
		return power;
	}
	public Weapon(String name, int power) {
		super();
		this.name = name;
		this.power = power;
	}
	public Weapon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPower(int power) {
		this.power = power;
	}
	
	

}
