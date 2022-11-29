package com.ex;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class MainLogic {
public static void main(String[] args) {
	ApplicationContext ac=new ClassPathXmlApplicationContext("Spring.xml");
	SpringDao d=ac.getBean(SpringDao.class);
	d.select();
}
}
