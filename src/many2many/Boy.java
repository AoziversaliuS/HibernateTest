package many2many;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Boy {
	
	private int id;
	private String name;
	
	
	public Boy(String name) {
		super();
		this.name = name;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public Boy() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Boy [id=" + id + ", name=" + name + "]";
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
	
	

}
