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
@Table(name = "team")

public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy="createdby")
	private List<Document> documentlist;
	
	@OneToMany(mappedBy="key.isMemberOf")
	private List<Membership> listofteam;
	
	public List<Document> getDocumentlist(){
		return this.documentlist;
	}
	
	public void setDocumentlist(List<Document> documentlist){
		this.documentlist = documentlist;
	}
	
	public List<Membership> getListofteam(){
		return this.listofteam;
	}
	
	public void setListofteam(List<Membership> listofteam){
		this.listofteam = listofteam;
	}
	
	public int getId() {
		return id;
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
