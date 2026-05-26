package controllerUser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import database.UserDatabase;
import interfaces.users.FrmAddUser;
import models.user.User;
import validations.UserValidations;

public class AddUserController implements ActionListener {

    private FrmAddUser view;

    public AddUserController(FrmAddUser view) {

        this.view = view;

        view.btnGUARDAR.addActionListener(this);
        view.btnCANCELAR.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == view.btnGUARDAR) {

            try {

                String id = view.getTextID().getText();
                String carnet = view.getTextCARNET().getText();
                
                
				// ---------------------------------------------------------------------------
				String name = view.getTextNOMBRE().getText();
				// VALIDAR NOMBRE
				if (!UserValidations.onlyLetters(name)) {

					JOptionPane.showMessageDialog(null, "NONBRE INVALIDO, AGREGE LETRAS");

					return;
				}
				// ---------------------------------------------------------------------------

				String lastname = view.getTextAPELLIDOS().getText();
				// VALIDAR APELLIDO
				if (!UserValidations.onlyLetters(lastname)) {

					JOptionPane.showMessageDialog(null, "Apellido inválido");

					return;
				}
				// ---------------------------------------------------------------------------

				int age = Integer.parseInt(view.getTextEDAD().getText());
				// VALIDAR EDAD
				if (age <= 0 || age > 100) {

					JOptionPane.showMessageDialog(null, "Edad inválida");

					return;
				}

				String phone = view.getTextTELEFONO().getText();
				// VALIDAR TELÉFONO
				if (!UserValidations.onlyNumbers(phone)) {

					JOptionPane.showMessageDialog(null, "Teléfono inválido");

					return;
				}

				String mail = view.getTextCORREO().getText();
				// VALIDAR CORREO
				if (!UserValidations.validMail(mail)) {

					JOptionPane.showMessageDialog(null, "Correo inválido");

					return;
				}

				String address = view.getTextDIRECCION().getText();
             

             

                // VALIDAR CAMPOS VACÍOS
                if (
                    UserValidations.emptyField(name) ||
                    UserValidations.emptyField(lastname) ||
                    UserValidations.emptyField(phone) ||
                    UserValidations.emptyField(mail) ||
                    UserValidations.emptyField(address)
                ) {

                    JOptionPane.showMessageDialog(
                        null,
                        "Hay campos vacíos"
                    );

                    return;
                }

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

                UserDatabase.saveUser(user); // AGUARDA USUARISOS EN TXT
               

                JOptionPane.showMessageDialog(null,
                        "Usuario guardado correctamente");

                view.dispose();

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null,
                        "Error al guardar usuario");
            }
        }

        if (e.getSource() == view.btnCANCELAR) {

            view.dispose();
        }
    }
}