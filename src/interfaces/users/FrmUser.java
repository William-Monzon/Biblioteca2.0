package interfaces.users;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

public class FrmUser extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtcarnet;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmUser frame = new FrmUser();
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
	public FrmUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// panel azul izquierdo
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 102));
		panel.setBounds(0, 0, 201, 663);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Biblioteca");
		lblNewLabel.setBounds(57, 10, 114, 30);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("Préstamos");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 16));
		// color azul del botón
		btnNewButton_2.setBackground(Color.BLUE);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setOpaque(true);
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setBounds(0, 381, 201, 67);
		panel.add(btnNewButton_2);
		
		
		
		JButton btnNewButton_1 = new JButton("Usuarios");
		btnNewButton_1.setBackground(new Color(0, 0, 102)); // 
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 16)); // tipo de letra
		btnNewButton_1.setBounds(0, 251, 201, 70);
		// color azul del botón
		btnNewButton_1.setBackground(Color.BLUE);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setOpaque(true);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setFocusPainted(false);
		panel.add(btnNewButton_1);
		
		
		JButton btnNewButton = new JButton("Libros");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.setBounds(0, 114, 201, 69);
		// color azul del botón
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setOpaque(true);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFocusPainted(false);
		panel.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("Salir");
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(0, 514, 201, 67);
		// color azul del botón
		btnNewButton_3.setBackground(Color.BLUE);
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setOpaque(true);
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setFocusPainted(false);
		panel.add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("Usuarios");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 26));
		lblNewLabel_1.setBounds(229, 158, 117, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_2.setBounds(255, 209, 44, 12);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CARNET");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_3.setBounds(719, 204, 78, 17);
		contentPane.add(lblNewLabel_3);
		
		txtid = new JTextField();
		txtid.setBounds(317, 302, 293, 31);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		txtcarnet = new JTextField();
		txtcarnet.setBounds(609, 302, 300, 31);
		contentPane.add(txtcarnet);
		txtcarnet.setColumns(10);
		
		// boton  agregar usuarios
		JButton btnAddUser = new JButton("Agregar usuarios");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddUser.setBounds(234, 531, 239, 53);
		contentPane.add(btnAddUser);
		
		
		
		// boton mostrar usuarios
		JButton btnShowUser = new JButton("Mostrar usuarios");
		btnShowUser.setBounds(523, 531, 238, 53);
		contentPane.add(btnShowUser);
		
		JButton btnvalidarduplicados = new JButton("Validar duplicados");
		btnvalidarduplicados.setBounds(814, 531, 238, 53);
		contentPane.add(btnvalidarduplicados);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(317, 280, 592, 23);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Carnet"
			}
		));
		scrollPane.setViewportView(table);

	}
}
