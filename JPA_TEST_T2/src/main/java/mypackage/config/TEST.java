package mypackage.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class TEST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager enma = JPAConfig.getEntityManager();
		 EntityTransaction trans = enma.getTransaction();
		
		 try {
			 
			 trans.begin();
			//gọi phương thức để thực hiện CRUD
			 trans.commit();
		 
		 }
		 catch (Exception e) {

			 e.printStackTrace();
			 trans.rollback();
		 throw e;
		 
		 }
		 finally {
			 
		 enma.close();

		 }
	}


	

}
