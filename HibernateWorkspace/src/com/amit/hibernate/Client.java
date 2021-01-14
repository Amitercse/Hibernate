package com.amit.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Client {

	public static void main(String[] args) {
		Session session= HibernateUtil.getSession();
		Student student = new Student("student 1", "computer science", "01/01/1993");
		Transaction tx= session.beginTransaction();
		session.save(student);
		tx.commit();
		session.close();
	}
}
