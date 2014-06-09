package many2many;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
@Entity
public class Girl {
	
	private List<Boy> boyFriends;
	private int id;
	private String name;
	
	
	
	public Girl() {
		super();
	}
	public Girl(String name, List<Boy> boyFriends) {
		super();
		this.name = name;
		this.boyFriends = boyFriends;
	}
	
	@Override
	public String toString() {
		return "Girl [boyFriends=" + boyFriends + ", id=" + id + ", name="
				+ name + "]";
	}
	@ManyToMany
	@JoinTable(name="center_table",
		joinColumns={@JoinColumn(name="girl_id")},//name属性没有提示，不过要用name才行
		inverseJoinColumns={@JoinColumn(name="boy_id")}
			)
	public List<Boy> getBoyFriends() {
		return boyFriends;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setBoyFriends(List<Boy> boyFriends) {
		this.boyFriends = boyFriends;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
