package com.abhishekpanwar.hibernate.demo;

import java.util.List;

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
		
			session.beginTransaction();
			
			System.out.println("Saving new Student Object...");
			int studentId = 6;
			Student student = session.get(Student.class,studentId);
			
			student.setEmail("hello@mail.com");
		
			session.createQuery("update Student set email='foo@mail.com'")
			.executeUpdate();

			System.out.println("Commiting transaction...");
			session.getTransaction().commit();
			
			System.out.println("Done!");

			
		}
		finally {
			factory.close();
		}

	}

}
