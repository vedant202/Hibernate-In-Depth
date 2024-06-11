package com.HibernateInDepthTuts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.SelectionQuery;

import com.HibernateInDepthTuts.Entity.Address;
import com.HibernateInDepthTuts.Entity.Products;
import com.HibernateInDepthTuts.Entity.Users;

public class HibernateServices {
	
	public List<Products> getAllProducts(Session session) {
		String hql = "FROM Products";

		// products selection query
		SelectionQuery<Products> selectionQuery = session.createSelectionQuery(hql, Products.class);
		List<Products> products = selectionQuery.getResultList();
		System.out.println(products);
		return products;
		
	}
	
	public List<Users> getAllUsers(Session session) {
//		Users selection query
		String hql2 = "from Users";
		SelectionQuery<Users> userSelectionQuery = session.createSelectionQuery(hql2, Users.class);
		List<Users> users = userSelectionQuery.getResultList();
		System.out.println(users);
		return users;
		
	}
	
	public List<Address> getAllAddresses(Session session) {
//		Users selection query
		String hql3 = "from Address";
		// address selection query

		SelectionQuery<Address> addressSelectionQuery = session.createSelectionQuery(hql3, Address.class);
		var addresses = addressSelectionQuery.getResultList();
		System.out.println(addresses);
		session.close();
		return addresses;
		
	}
	
	public void saveProduct(Session session,String path,Products product) {
//		"F://Hibernate Java//HibernateInDepth//lib//src//main//java//com//HibernateInDepthTuts//girl.jpg"
		Transaction t = session.beginTransaction();
		File file = new File(
				path);
		byte[] fileBytes = null;
		if (file.isFile()) {
			System.out.println("File is present");
			try {
				fileBytes = new byte[(int) file.length()];
				FileInputStream inputStream = new FileInputStream(file);
				inputStream.read(fileBytes);
				inputStream.close();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		session.save(product);
		
		
		t.commit();
	}
	
	public void saveUser(Session session,Users user) {
		Transaction t = session.beginTransaction();
		session.persist(user);
		t.commit();
		
	}
	
	public void saveAddress(Session session,Address address) {
		Transaction t = session.beginTransaction();
		
		session.persist(address);
		t.commit();

		
	}
	
	public Users getUserById(Session session,long id) {
		Optional<Users> user = Optional.of(session.find(Users.class, id));
		return user.orElseThrow(()->new RuntimeException("User not found exception"));
	}
	
	public void deleteUserById(Session session,long id) {
		Transaction t = session.beginTransaction();
		Users user = session.find(Users.class, id);
		if(user==null) {
			throw new RuntimeException("User not found exception");
		}
		session.remove(user);
		
		t.commit();
		
		
	}

}
