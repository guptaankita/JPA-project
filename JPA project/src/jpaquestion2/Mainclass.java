package jpaquestion2;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;




public class Mainclass {
	EntityManagerFactory entityManagerFactory;
	public static void main(String[] args)
	{
	Mainclass r = new Mainclass();
	try {
		r.setUp();
		List<Document> docs = r.getDocumentByTitle("aaaaa");
		for(Document d:docs){
			System.out.println("Title : "+d.getTitle());
			System.out.println("Team : "+d.getCreatedby().getName());
			List<Person> chairs = r.getPersonByRole("Chair", d.getCreatedby(), d.getCreatedon());
			System.out.print("Chairs : ");
			for(Person p:chairs){
				System.out.print(p.getName()+"; ");
			}
			System.out.println("");
			List<Person> secretaries = r.getPersonByRole("Secretary", d.getCreatedby(), d.getCreatedon());
			System.out.print("Secretaries : ");
			for(Person p:secretaries){
				System.out.print(p.getName()+"; ");
			}
			System.out.println("");
		}
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	}
	protected void setUp() throws Exception {
		entityManagerFactory = Persistence.createEntityManagerFactory("Teams");
	}
	
	protected void saveStudent(Person p) throws Exception {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(p);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
protected List<Document> getDocumentByTitle(String title) {
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	String query = "from Document d where d.title like :title";
	Query q = entityManager.createQuery(query);
	q.setParameter("title", title+"%");
	List<Document> docs = q.getResultList();
	return docs;
}

protected List<Person> getPersonByRole(String role, Team t, Date createdOn) {
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	String query = "select m.key.hasMember from Membership m, Role r where m.key.isMemberOf = :team and r.key.hasRole.type = :role and r.key.hasMember = m.key.hasMember and r.key.isMemberOf = :team and m.start < :created and m.end > :created";
	Query q = entityManager.createQuery(query);
	q.setParameter("team", t);
	q.setParameter("role", role);
	q.setParameter("created", createdOn);
	List<Person> p = q.getResultList();
	return p;
}

}
