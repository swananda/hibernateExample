package com.hibjava;

import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class EmpInfo {

	
	public static void main(String[] args) {
		
		SessionFactory sf= new AnnotationConfiguration().configure().buildSessionFactory();
		Session s=sf.openSession();
		Transaction tx= s.beginTransaction();
		
		Criteria cr= s.createCriteria(Employee.class);
		System.out.println("row count: "+cr.setProjection(Projections.rowCount()));
		cr.add(Restrictions.gt("salary", 20000));
		
		cr.addOrder(Order.asc("salary"));
		List<Employee> result=cr.list();
		System.out.println(result);
		s.flush();
		tx.commit();
		
		s.close();
		

	}

}
