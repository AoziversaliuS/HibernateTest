package pojo;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import type.Sex;

@Entity
@Table(name="players")//设置table名为players
public class Player {
	
	private int id;
	private String name;
	
	private Pet pet; //一对一关联映射
	private Sex sex;//枚举类型存储
	private Weapon weapon;//组件关联
	private String wife;//设置某一属性不保存到数据库中

	public Player() {
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

	public Player(String name) {
		this.name = name;
	}

	public Player(String name, String wife, Sex sex) {
		super();
		this.name = name;
		this.wife = wife;
		this.sex = sex;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	@Column(name="player_name",unique=true)//名字唯一
	public String getName() {
		return name;
	}
	
	//单向一对一关联
	@OneToOne(cascade=CascadeType.REFRESH,fetch=FetchType.LAZY) 
	public Pet getPet() {
		return pet;
	}
	
	
	
	//枚举类型的自动转换
	@Enumerated(EnumType.STRING)
	public Sex getSex() {
		return sex;
	}
	@Embedded
	public Weapon getWeapon() {
		return weapon;
	}
	@Transient  //在数据库中忽略此属性
	public String getWife() {
		return wife;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public void setPet(Pet pet) {
		this.pet = pet;
	}
	public void setSex(Sex sex) {
		this.sex = sex;
	}
	
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	public void setWife(String wife) {
		this.wife = wife;
	}
	
	
	
}
