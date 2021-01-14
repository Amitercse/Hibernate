/**
 * @author Amit sharma
 *
 */
module HibernateWorkspace {
	requires org.hibernate.orm.core;
	requires java.persistence;
	requires java.sql;
	opens com.amit.hibernate;
}