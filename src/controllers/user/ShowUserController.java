package controllers.user;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import database.UserDatabase;
import interfaces.users.FrmShowUser;
import models.user.User;



public class ShowUserController implements ActionListener {
	

	    private FrmShowUser view;

	    public ShowUserController(FrmShowUser view) {

	        this.view = view;
	        UserDatabase.loadUsers();

	        loadTable();

	        view.btnEdit.addActionListener(this);
	        view.btnSavecam.addActionListener(this);
	        view.btnClose.addActionListener(this);
	   
	    }

	    public void loadTable() {

	        String[] columns = {
	                "ID",
	                "Carnet",
	                "Nombre",
	                "Apellido",
	                "Edad",
	                "Telefono",
	                "Correo",
	                "Direccion"
	        };

	        DefaultTableModel model = new DefaultTableModel();

	        model.setColumnIdentifiers(columns);

	        for (User user : UserDatabase.users) {

	            Object[] row = {
	                    user.getId(),
	                    user.getCarnet(),
	                    user.getName(),
	                    user.getLastname(),
	                    user.getAge(),
	                    user.getPhone(),
	                    user.getMail(),
	                    user.getAddress()
	            };

	            model.addRow(row);
	        }

	        view.tableUsers.setModel(model);
	    }

	    @Override
	    public void actionPerformed(ActionEvent e) { //***************

	        if (e.getSource() == view.btnEdit) {

	            view.tableUsers.setEnabled(true);
	        }

	        if (e.getSource() == view.btnSavecam) {

	            saveChanges();
	        }

	        if (e.getSource() == view.btnClose) {

	            view.dispose();
	            
	        }
	    }

	    public void saveChanges() {

	        try {

	            DefaultTableModel model =
	                    (DefaultTableModel) view.tableUsers.getModel();

	            UserDatabase.users.clear();

	            for (int i = 0; i < model.getRowCount(); i++) {

	                String id = model.getValueAt(i, 0).toString();
	                String carnet = model.getValueAt(i, 1).toString();
	                String name = model.getValueAt(i, 2).toString();
	                String lastname = model.getValueAt(i, 3).toString();

	                int age = Integer.parseInt(
	                        model.getValueAt(i, 4).toString()
	                );

	                String phone = model.getValueAt(i, 5).toString();
	                String mail = model.getValueAt(i, 6).toString();
	                String address = model.getValueAt(i, 7).toString();

	                User user = new User(
	                        id,
	                        carnet,
	                        name,
	                        lastname,
	                        age,
	                        phone,
	                        mail,
	                        address
	                );

	                UserDatabase.updateFile();
	               
	            }

	            JOptionPane.showMessageDialog(null,
	                    "Cambios guardados correctamente");

	            view.tableUsers.setEnabled(false);

	        } catch (Exception ex) {

	            JOptionPane.showMessageDialog(null,
	                    "Error al guardar cambios");
	        }
	        
	        
	        
	        
	    }
	} 