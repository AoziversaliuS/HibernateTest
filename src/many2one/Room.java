package many2one;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Room {

	private int id;
	private List<People> peoples;
	public Room() {
		super();
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	@OneToMany
	@JoinColumn(name="room_id")
	public List<People> getPeoples() {
		return peoples;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setPeoples(List<People> peoples) {
		this.peoples = peoples;
	}


}
