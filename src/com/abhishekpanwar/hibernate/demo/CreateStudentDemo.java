package com.abhishekpanwar.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.abhishekpanwar.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			System.out.println("Creating new Student Object...");
			Student tempStudent = new Student("Abhishek","Panwar","abc@gmail.com");
			
			session.beginTransaction();
			
			System.out.println("Saving new Student Object...");
			session.save(tempStudent);
			
			System.out.println("Commiting transaction...");
			session.getTransaction().commit();
			
			System.out.println("Done!");

			
		}
		finally {
			factory.close();
		}

	}

}
