package com.my;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class MainLogic {

	public static void main(String[] args) {
		SessionFactory sessionFactory = EmployeeConfig.getSessionFactory();
		Session se = sessionFactory.openSession();
		Transaction ts = se.beginTransaction();
//		Query  q = se.createQuery("from Employee ee");
//		Query  q = se.createQuery("select ee.name, ee.salary from Employee ee");
//		Query  q = se.createQuery("select ee.name from Employee ee");
		Query q = se.createQuery("select ee.name,ee.salary,ee.location from Employee ee where ee.name=:input");
//		Query q = se.createQuery("update Employee ee set ee.salary=:m where ee.name=:input");
		q.setParameter("input", "uday kiran");
//		q.setParameter("m", 40000);
//		q.setParameter("input", "mani");
//		int s = q.executeUpdate();
//		ts.commit();
		
		List l = q.list();
	//	Iterator<Employee> li = l.iterator();
		Iterator li = l.iterator();
	//	Iterator<String> li = l.iterator();
		while(li.hasNext()) {
			
			Object[] o =(Object[]) li.next();
			System.out.println(o[0]+" "+o[1]+" "+o[2]);
			
//			String s =  li.next();
//			System.out.println(s);
							
//			Object[] o =(Object[]) li.next();
//			System.out.println(o[0]+" "+o[1]);
			
//			Employee ee = li.next();
//			System.out.println(ee.getEid()+" "+ee.getName()+" "+ee.getSalary()+" "+ee.getLocation()+" "+ee.getDepartment()+" "+ee.getLocation());	
		}
	}

}
