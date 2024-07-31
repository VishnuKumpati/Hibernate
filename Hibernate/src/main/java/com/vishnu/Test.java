package com.vishnu;

import java.io.Serializable;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.vishnu.Entity.Student;

public class Test {
	public static void main(String[] args) {
		SessionFactory sessionfactory=null;
		Session session=null;
		try {
			 sessionfactory= new Configuration()
                                 .configure()
                                 .addAnnotatedClass(Student.class)
                                 .buildSessionFactory();
			 //create session
             session= sessionfactory.openSession();
             //create session
             Transaction trans=session.beginTransaction();
             //crud operation
             Student s=new Student(2,"vishnu","sunny@gmail.com");
             Serializable id=(Serializable) session.save(s);
             System.out.println(id );
             
             trans.commit();
         }
		finally {
			session.close();
			sessionfactory.close();
		}
		
		
	}

}
