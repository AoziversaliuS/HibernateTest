package many2one;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class People {

	private int id;
	private String name;
	private Room room;
	public People() {
		super();
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	@ManyToOne(cascade={CascadeType.PERSIST})
	//只有调用了session.persist()方法之后才能进行级联保存
	//删除的时候PERSIST不会级联把room删除，但all就会
	public Room getRoom() {
		return room;
	}
	@Override
	public String toString() {
		return "People [id=" + id + ", name=" + name + ", room=" + room + "]";
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	
	
}
