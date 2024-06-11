package com.HibernateInDepthTuts;

import static org.hibernate.cfg.JdbcSettings.FORMAT_SQL;
import static org.hibernate.cfg.JdbcSettings.HIGHLIGHT_SQL;
import static org.hibernate.cfg.JdbcSettings.JAKARTA_JDBC_PASSWORD;
import static org.hibernate.cfg.JdbcSettings.SHOW_SQL;
import static org.hibernate.cfg.JdbcSettings.URL;
import static org.hibernate.cfg.JdbcSettings.USER;

import static org.hibernate.cfg.AvailableSettings.JAKARTA_HBM2DDL_DATABASE_ACTION;
import static org.hibernate.tool.schema.Action.UPDATE;



import static org.hibernate.cfg.JdbcSettings.DRIVER;
import static org.hibernate.cfg.JdbcSettings.DIALECT;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.HibernateInDepthTuts.Entity.Address;
import com.HibernateInDepthTuts.Entity.Products;
import com.HibernateInDepthTuts.Entity.Users;

public class GetSessionFactoryObj {
	private static SessionFactory sessionFactory=null;
	public SessionFactory getSessionFactory() {
		this.sessionFactory=new Configuration().setProperty(JAKARTA_HBM2DDL_DATABASE_ACTION, UPDATE).addAnnotatedClass(Products.class)
				.addAnnotatedClass(Users.class)
				.addAnnotatedClass(Address.class)
			.setProperty(URL,"jdbc:mysql://localhost:3306/hybernatetuts")
				.setProperty(DRIVER, "com.mysql.cj.jdbc.Driver")
			.setProperty(USER, "root")
			.setProperty(JAKARTA_JDBC_PASSWORD,"root")
			.setProperty("hibernate.agroal.maxSize", 20)
			.setProperty(SHOW_SQL, true)
            .setProperty(FORMAT_SQL, true)
            .setProperty(HIGHLIGHT_SQL, true)
            .setProperty(DIALECT, "org.hibernate.dialect.MySQLDialect")
            .buildSessionFactory();
		return this.sessionFactory;
	}
	
	
}
