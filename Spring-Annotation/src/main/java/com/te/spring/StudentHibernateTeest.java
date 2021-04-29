package com.te.springhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.te.springhibernate.bean.EntityManagerDemo;
import com.te.springhibernate.bean.Student;
import com.te.springhibernate.config.EntityManagerConfig;

public class HibernateTeest {

	public static void main(String[] args) {
		 Student m = new Student();
	        m.setSid(1);
	        m.setSname("koko");
	        m.setNickname("chinna");
	        
		ApplicationContext context = new AnnotationConfigApplicationContext(EntityManagerConfig.class);
               EntityManagerDemo demo= context.getBean(EntityManagerDemo.class);
               EntityManager entityManager=demo.getEntityManager();
               EntityTransaction entityTransaction=entityManager.getTransaction();
               entityTransaction.begin();
               entityManager.persist(m);
               entityTransaction.commit();
               System.out.println("Record inserted succesfully");
	}

}
