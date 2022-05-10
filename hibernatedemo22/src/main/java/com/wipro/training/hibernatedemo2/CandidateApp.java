package com.wipro.training.hibernatedemo2;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CandidateApp {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml"); // configures hibernate with DB
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();  // physical connection with db is established

		Transaction t=session.beginTransaction();

		// object in  transient state i.e not associated
		// with any session
		Candidate c1= new Candidate("Harry","Potter","harrypotter@gmail.com");
		

		session.save(c1);  // object in persistent state
		t.commit();
		System.out.println("Candidate Details successfully Saved to DB");
		session.close();  // object in detached state
		
		System.out.println("****** DISPLAY CANDIDATE DETAILS *******");
		
		session = sf.openSession();
		
		List<Candidate> cd = session.createQuery("from Candidate",Candidate.class).list();
		
		cd.forEach(i -> System.out.println(i.getId()+" "+i.getFirstName()+" "+i.getLastName()+" "+i.getEmail()));
		
		sf.close();
	}

}