package jpaquestion2;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "membership")
public class Membership {
	
	@EmbeddedId
	private MembershipPk key;
	@Column(name = "start")
	private Date start;
	
	@Column(name = "end")
	private Date end;

	
	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}


}

@Embeddable
class MembershipPk implements Serializable
{
	@ManyToOne
	@JoinColumn(name = "hasMember")
	Person hasMember;
	
	@ManyToOne
	@JoinColumn(name = "isMemberOf")
	Team isMemberOf;

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
		this.isMemberOf = isMemberOf;
	}
}
