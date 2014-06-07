package pojo;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import type.Sex;

@Entity
@Table(name="players")//设置table名为players
public class Player {
	
	private int id;
	private String name;
	
	private String wife;
	private Sex sex;
	
	

	public Player() {
	}
	
	public Player(String name, String wife, Sex sex) {
		super();
		this.name = name;
		this.wife = wife;
		this.sex = sex;
	}

	public Player(String name) {
		this.name = name;
	}
	
	public Player(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
	
	public Player(int id, String name, String wife) {
		super();
		this.id = id;
		this.name = name;
		this.wife = wife;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="player_name",unique=true)//名字唯一
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Transient  //在数据库中忽略此属性
	public String getWife() {
		return wife;
	}
	public void setWife(String wife) {
		this.wife = wife;
	}
	
	//枚举类型的自动转换
	@Enumerated(EnumType.STRING)
	public Sex getSex() {
		return sex;
	}
	public void setSex(Sex sex) {
		this.sex = sex;
	}
	
	
	
}
