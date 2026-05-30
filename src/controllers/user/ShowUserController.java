package controllers.user;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import database.UserDatabase;
import interfaces.users.WindowShowUser;
import models.user.User;



public class ShowUserController implements ActionListener {
	

	    private WindowShowUser view;

	    public ShowUserController(WindowShowUser view) {

	        this.view = view;
	        UserDatabase.loadUsers();

	        loadTable();

	        view.btnEdit.addActionListener(this);
	        view.btnSavecam.addActionListener(this);
	        view.btnClose.addActionListener(this);
	        view.btnDelete.addActionListener(this);
	        
	   
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
	    public void actionPerformed(ActionEvent e) { 

	        if (e.getSource() == view.btnEdit) {

	            view.tableUsers.setEnabled(true);
	        }

	        if (e.getSource() == view.btnSavecam) {

	            saveChanges();
	        }

	        if (e.getSource() == view.btnClose) {

	            view.dispose();
	            
	        }
	        
	        if (e.getSource() == view.btnDelete) {

	            deleteUser();
	        }
	        
	    }

	    
	    
	    
	    public void saveChanges() {

	        try {

	            DefaultTableModel model =
	                    (DefaultTableModel) view.tableUsers.getModel();

	            // limpiar lista actual
	            UserDatabase.users.clear();

	            // RECORRE LA TABLA
	            for (int i = 0; i < model.getRowCount(); i++) {

	                String id = model.getValueAt(i, 0).toString();
	                String carnet = model.getValueAt(i, 1).toString();
	                String name = model.getValueAt(i, 2).toString();
	                String lastname = model.getValueAt(i, 3).toString();

	                int age = Integer.parseInt(
	                        model.getValueAt(i, 4).toString());

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

	                // AGREGAR USER AL ARRAYLIST
	                UserDatabase.users.add(user);
	            }

	            // GUARDAR TODO EL ARRAYLIST EN EL TXT
	            UserDatabase.updateFile();

	            JOptionPane.showMessageDialog(
	                    null,
	                    "Cambios guardados correctamente"
	            );

	            view.tableUsers.setEnabled(false);

	        } catch (Exception ex) {

	            JOptionPane.showMessageDialog(
	                    null,
	                    "Error al guardar cambios"
	            );
	        }
	    }
	        
	    // METODO BORRAR USER
	    public void deleteUser() {

	        int row = view.tableUsers.getSelectedRow();

	        if (row == -1) {

	            JOptionPane.showMessageDialog(
	                    null,
	                    "Seleccione un usuario"
	            );

	            return;
	        }

	        DefaultTableModel model =
	                (DefaultTableModel) view.tableUsers.getModel();

	        model.removeRow(row);

	        JOptionPane.showMessageDialog(
	                null,
	                "Usuario eliminado de la tabla"
	        );
	    }
	           
	        
	    
	} 