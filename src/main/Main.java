package main;

import controllerUser.UserController;
import interfaces.users.FrmUser;


public class Main {

	public static void main(String[] rgs)  {
		// TODO Auto-generated method stub
	
		
		// USUARIO
		FrmUser view = new FrmUser();

		new UserController(view);

		view.setVisible(true);
		        
		        
	}


}

	

