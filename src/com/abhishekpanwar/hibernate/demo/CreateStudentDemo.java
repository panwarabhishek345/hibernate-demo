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
			List<Student> students = session.createQuery("from Student").list();
			
			System.out.println("All students:");

			for (Student student : students) {
				System.out.println(student);
			}
			
			
			students = session.createQuery("from Student s where s.lastName = 'Doe'").list();
			
			System.out.println("Students with Doe as LastName:");

			for (Student student : students) {
				System.out.println(student);
			}
			
			System.out.println("Commiting transaction...");
			session.getTransaction().commit();
			
			System.out.println("Done!");

			
		}
		finally {
			factory.close();
		}

	}

}
