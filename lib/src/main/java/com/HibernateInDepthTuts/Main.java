package com.HibernateInDepthTuts;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.SelectionQuery;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaRoot;

import com.HibernateInDepthTuts.Entity.Address;
import com.HibernateInDepthTuts.Entity.Products;
import com.HibernateInDepthTuts.Entity.Users;

import jakarta.persistence.Query;

import static org.hibernate.cfg.AvailableSettings.*;

import java.awt.print.Book;
import java.util.List;

import org.hibernate.SessionFactory;

public class Main {
	public static void main(String[] args) {
		SessionFactory sessionFactory=new Configuration().addAnnotatedClass(Products.class)
				.addAnnotatedClass(Users.class)
				.addAnnotatedClass(Address.class)
			.setProperty(URL,"jdbc:h2:mem:hybernatetuts")
			.setProperty(USER, "root")
			.setProperty(PASS,"root")
			.setProperty("hibernate.agroal.maxSize", 20)
			.setProperty(SHOW_SQL, true)
            .setProperty(FORMAT_SQL, true)
            .setProperty(HIGHLIGHT_SQL, true)
            .buildSessionFactory();
		
		sessionFactory.getSchemaManager().exportMappedObjects(true);
		
		sessionFactory.inTransaction(session->{
			session.persist(new Products("Apple Laptop","",100000,null));
		});
        // query data using HQL
		
		sessionFactory.inSession(session->{
			String hql = "from Products";
			SelectionQuery<Products> query=session.createSelectionQuery(hql,Products.class);
			List<Products> list=query.getResultList();
			System.out.println(list);
			
			System.out.println();
		});
		// query data using criteria API
		System.out.println("-------Criteria API----------------");
		sessionFactory.inSession(session->{
			HibernateCriteriaBuilder builder=session.getCriteriaBuilder();
			JpaCriteriaQuery<String> query=builder.createQuery(String.class);
			JpaRoot<Products> products=query.from(Products.class);
			
			query.select(products.get("productTitle"));
			System.out.println(session.createSelectionQuery(query).getSingleResult());
		});
	}
}
