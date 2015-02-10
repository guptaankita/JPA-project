package jpaquestion2;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "roletype")
public class RoleType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "type")
	private String type;
	
	@OneToMany(mappedBy="key.hasRole")
	private List<Role> listofrole;
	
	public List<Role> getListofrole(){
		return this.listofrole;
	}

	public void setListofrole(List<Role> listofrole){
		this.listofrole = listofrole;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	


}
