package main;



//<<<<<<< HEAD
//=======

  //>>>>>>> 205600e205dcf27a4782a007f526536e2d768fe8
import models.user.*;
import services.user.ArrayListUser;








public class Main {

	public static void main(String[] rgs)  {
		// TODO Auto-generated method stub

	
	
		
		
		// ejemplo usuario
		User u1= new User(1,18,"5241625","mario","jerez","45f44s","abdiel@gmail.como","jutiapa, jutiapa");
		
		u1.showinf();
		
	
		
	

		
//<<<<<<< HEAD
//=======
		// servicios usuarios
		ArrayListUser service = new ArrayListUser();
	        
	        for (User u :
	                service.listUsers()) {

	            u.showinf();

	            System.out.println();
	        }
		        
		        
	}
//>>>>>>> 205600e205dcf27a4782a007f526536e2d768fe8


}

	

