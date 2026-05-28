package controllers.user;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import interfaces.users.WindowAddUser;
import interfaces.users.WindowShowUser;
import interfaces.users.WindowUser;

public class UserController implements ActionListener {

    private WindowUser view;

    public UserController(WindowUser view) {

        this.view = view;

        view.btnAddUser.addActionListener(this);
        view.btnShowUser.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    	if (e.getSource() == view.btnAddUser) {

    	    String id = view.getTxtid().getText();
    	    String carnet = view.getTxtcarnet().getText();

    	    // VALIDAR CAMPOS VACÍOS
    	    if (id.trim().isEmpty() || carnet.trim().isEmpty()) {

    	        JOptionPane.showMessageDialog(
    	            null,
    	            "Debe llenar primero ID y Carnet"
    	        );

    	        return;
    	    }
    	    
    	    
    	    

    	    WindowAddUser addView = new WindowAddUser();

    	    addView.setData(id, carnet);

    	    new AddUserController(addView);

    	    addView.setVisible(true);
    	}

        if (e.getSource() == view.btnShowUser) {

            WindowShowUser showView = new WindowShowUser();

            new ShowUserController(showView);

            showView.setVisible(true);
        }
    }
}