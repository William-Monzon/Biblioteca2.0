package controllerUser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import interfaces.users.FrmAddUser;
import interfaces.users.FrmShowUser;
import interfaces.users.FrmUser;

public class UserController implements ActionListener {

    private FrmUser view;

    public UserController(FrmUser view) {

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
    	    
    	    
    	    

    	    FrmAddUser addView = new FrmAddUser();

    	    addView.setData(id, carnet);

    	    new AddUserController(addView);

    	    addView.setVisible(true);
    	}

        if (e.getSource() == view.btnShowUser) {

            FrmShowUser showView = new FrmShowUser();

            new ShowUserController(showView);

            showView.setVisible(true);
        }
    }
}