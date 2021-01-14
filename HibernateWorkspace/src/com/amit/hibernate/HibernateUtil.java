package com.amit.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;

	private static void buildSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(Student.class);
		configuration.configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	public static Session getSession()
	{
		if(sessionFactory==null)
		{
			buildSessionFactory();
		}
		return sessionFactory.openSession();
	}
	
	public void closeSession()
	{
		sessionFactory.close();
	}
}
