package com.amit.hibernate;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Client {

	public static void main(String[] args) {
		saveStudentDetails();
		getStudentData();
	}
	
	private static void saveStudentDetails()
	{
		Session session= HibernateUtil.getSession();
		Student student = new Student("student 1", "computer science", "01/01/1993");
		Transaction tx= session.beginTransaction();
		session.save(student);
		tx.commit();
		session.close();
	}
	
	private static void getStudentData()
	{
		Session session= HibernateUtil.getSession();
		Transaction tx= session.beginTransaction();
		CriteriaQuery<Student> criteriaQuery = session.getCriteriaBuilder().createQuery(Student.class);
	    criteriaQuery.from(Student.class);
	    List<Student> studentList = session.createQuery(criteriaQuery).getResultList();
		tx.commit();
		session.close();
		System.out.println(studentList);
	}
}
