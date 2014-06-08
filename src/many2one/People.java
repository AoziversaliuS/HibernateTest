package many2one;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class People {

	private int id;
	private String name;
//	private Room room;
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
//	@ManyToOne
//	public Room getRoom() {
//		return room;
//	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
//	public void setRoom(Room room) {
//		this.room = room;
//	}
	
	
}
