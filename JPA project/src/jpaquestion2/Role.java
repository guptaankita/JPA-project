package jpaquestion2;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "role")
public class Role {
	@EmbeddedId
	private RolePk key;
	
	


}


@Embeddable
class RolePk implements Serializable
{
	@ManyToOne
	@JoinColumn(name = "hasMember")
    Person hasMember;
	
	@ManyToOne
	@JoinColumn(name = "isMemberOf")
	Team isMemberOf;
	
	

	
	@ManyToOne
	@JoinColumn(name = "id")
	RoleType hasRole;




	public Person getHasMember() {
		return hasMember;
	}




	public void setHasMember(Person hasMember) {
		this.hasMember = hasMember;
	}




	public Team getIsMemeberOf() {
		return isMemberOf;
	}




	public void setIsMemeberOf(Team isMemeberOf) {
		this.isMemberOf = isMemeberOf;
	}




	public RoleType getHasRole() {
		return hasRole;
	}




	public void setHasRole(RoleType hasRole) {
		this.hasRole = hasRole;
	}
	
}