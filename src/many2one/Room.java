package many2one;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Room {

	private int id;
	private String roomName;
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	private List<People> peoples;
	public Room() {
		super();
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	@OneToMany(mappedBy="room",cascade={CascadeType.ALL})//由People类的room属性去匹配
//	@JoinColumn(name="room_id")
	public List<People> getPeoples() {
		return peoples;
	}
	@Override
	public String toString() {
		return "Room [id=" + id + ", peoples=" + peoples + "]";
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setPeoples(List<People> peoples) {
		this.peoples = peoples;
	}


}
