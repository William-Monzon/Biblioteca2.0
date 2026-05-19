package main;




import models.user.*;
import services.user.ArrayListUser;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// ejemplo usuario
		User u1= new User(1,18,"5241625","mario","jerez","45f44s","abdiel@gmail.como","jutiapa, jutiapa");
		
		u1.showinf();
		
	
		
		
		// servicios usuarios
		ArrayListUser service = new ArrayListUser();
	        
	        for (User u :
	                service.listUsers()) {

	            u.showinf();

	            System.out.println();
	        }
		        
		        
}

}
