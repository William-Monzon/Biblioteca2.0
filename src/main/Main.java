package main;

import javax.swing.JFrame;

import controllerUser.UserController;
import interfaces.users.FrmUser;


public class Main {

	public static void main(String[] rgs)  {
		// TODO Auto-generated method stub
	

        // Crear ventana principal
        FrmUser view = new FrmUser();

        // Crear controlador
        new UserController(view);

        // Abrir maximizado
        view.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Permitir redimensionar
        view.setResizable(true);

        // Centrar ventana
        view.setLocationRelativeTo(null);

        // Mostrar ventana
        view.setVisible(true);
        
	}


}

	

