package interfaces.loans;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.*;

import javax.swing.border.LineBorder;
public class windowLoans extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					windowLoans frame = new windowLoans();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public windowLoans() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	
		setBounds(100, 100, 1100, 700);
		setLocationRelativeTo(null);
		
		
		
	// panel azul izquierdo
			JPanel panel = new JPanel();
			panel.setBackground(new Color(0, 0, 153));
			panel.setBounds(0, 0, 232, 700);
			
			setLocationRelativeTo(null);
			contentPane.add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Biblioteca");
			lblNewLabel.setBounds(42, 10, 136, 30);
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
			
			JLabel lblNewLabel_1 = new JLabel("Préstamos");
			lblNewLabel_1.setForeground(new Color(0, 0, 128));
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
			lblNewLabel_1.setBounds(284, 49, 191, 56);
			contentPane.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Usuario:");
			lblNewLabel_2.setBackground(new Color(240, 240, 240));
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 23));
			lblNewLabel_2.setBounds(374, 147, 125, 56);
			contentPane.add(lblNewLabel_2);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(384, 206, 358, 27);
			contentPane.add(comboBox);
			
			JLabel lblNewLabel_3 = new JLabel("Libro");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 23));
			lblNewLabel_3.setBounds(384, 331, 125, 35);
			contentPane.add(lblNewLabel_3);
			
			JComboBox comboBox_1 = new JComboBox();
			comboBox_1.setBounds(384, 391, 375, 27);
			contentPane.add(comboBox_1);
			

				

				JLabel lblNewLabel_4 = new JLabel();
				lblNewLabel_4.setBounds(100, 100, 50, 50);

				contentPane.add(lblNewLabel_4);
				
				JButton btnNewButton_4 = new JButton("Prestar");
				btnNewButton_4.setBounds(780, 570, 120, 40);

				
				
				btnNewButton_4.addActionListener(new ActionListener() {
					
				    @Override
				    public void actionPerformed(ActionEvent e) {
				    	
				    	if(comboBox.getSelectedItem() == null  ||
				    	comboBox_1.getSelectedItem() == null) {
				    		
				    		JOptionPane.showMessageDialog(null, "Seleccione usuario y libro ");
							return;
				    	}
				    	
				    	

				        JOptionPane.showMessageDialog(null, "Préstamo realizado correctamente\n" 
				        	                                   );
				       
				        
                                        
				    }
				    


				});
				btnNewButton_4.addActionListener(new ActionListener() {
					
				
					public void actionPerformed(ActionEvent e) {
						

                     	
						
						
						
	
					}
					
				
				;
				
				});
				btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 18));
				btnNewButton_4.setBackground(new Color(42, 47, 210));
				btnNewButton_4.setForeground(new Color(255, 255, 255));
				btnNewButton_4.setBounds(374, 529, 149, 56);
				contentPane.add(btnNewButton_4);
				btnNewButton_4.setBackground(Color.decode("#2A2FD2"));
				btnNewButton_4.setForeground(Color.WHITE);
				btnNewButton_4.setOpaque(true);
				btnNewButton_4.setBorderPainted(false);
				btnNewButton_4.setFocusPainted(false);
	
	}}

			
	
		
	
			
			
			
	