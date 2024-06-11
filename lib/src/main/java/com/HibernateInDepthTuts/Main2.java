package com.HibernateInDepthTuts;



import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main2 {
	public static void main(String[] args) {
		GetSessionFactoryObj getSessionFactoryObj = new GetSessionFactoryObj();
		SessionFactory sessionFactory = getSessionFactoryObj.getSessionFactory();
		sessionFactory.getSchemaManager().exportMappedObjects(true);
		Session session = sessionFactory.openSession();
		HibernateServices services = new HibernateServices();
		System.out.println(services.getUserById(session,1));
		
//		services.deleteUserById(session, 3);

//		Products getFirstProduct = products.get(0);
//		byte[] getBytes = getFirstProduct.getImage();
//		try {
//			FileOutputStream fileOutputStream = new FileOutputStream(
//					"F://Hibernate Java//HibernateInDepth//lib//src//main//java//com//HibernateInDepthTuts//girl3.jpg");
//			fileOutputStream.write(getBytes);
//			fileOutputStream.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}



		session.close();

	}
}
