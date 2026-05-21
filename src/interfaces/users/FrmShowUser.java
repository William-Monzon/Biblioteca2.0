package interfaces.users;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JButton;

public class FrmShowUser extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel datoid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmShowUser frame = new FrmShowUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmShowUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 602);
		datoid = new JPanel();
		datoid.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(datoid);
		datoid.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(25, 71, 44, 12);
		datoid.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CARNET:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(25, 127, 72, 12);
		datoid.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("NOMBRE:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(25, 175, 85, 12);
		datoid.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("APELLIDOS:");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(25, 228, 104, 12);
		datoid.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("EDAD:");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(25, 279, 44, 12);
		datoid.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("TELÉFONO:");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(25, 337, 85, 12);
		datoid.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("CORREO:");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(25, 397, 72, 12);
		datoid.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("DIRECCIÓN:");
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(23, 449, 85, 12);
		datoid.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(207, 64, 219, 29);
		datoid.add(lblNewLabel_8);
		
		JLabel datocarnet = new JLabel("New label");
		datocarnet.setBounds(209, 128, 44, 12);
		datoid.add(datocarnet);
		
		JLabel datonombre = new JLabel("New label");
		datonombre.setBounds(209, 176, 44, 12);
		datoid.add(datonombre);
		
		JLabel datoapellidos = new JLabel("New label");
		datoapellidos.setBounds(207, 229, 44, 12);
		datoid.add(datoapellidos);
		
		JLabel datoedad = new JLabel("New label");
		datoedad.setBounds(207, 280, 44, 12);
		datoid.add(datoedad);
		
		JLabel datotelefono = new JLabel("New label");
		datotelefono.setBounds(207, 338, 44, 12);
		datoid.add(datotelefono);
		
		JLabel datocorreo = new JLabel("New label");
		datocorreo.setBounds(209, 398, 44, 12);
		datoid.add(datocorreo);
		
		JLabel datodireccion = new JLabel("New label");
		datodireccion.setBounds(209, 450, 44, 12);
		datoid.add(datodireccion);
		
		JLabel lblNewLabel_9 = new JLabel("Mostrar usuarios");
		lblNewLabel_9.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_9.setBounds(149, 10, 176, 12);
		datoid.add(lblNewLabel_9);
		
		JButton btnNewButton = new JButton("CERRAR");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNewButton.setBounds(207, 511, 127, 44);
		datoid.add(btnNewButton);

	}

}
