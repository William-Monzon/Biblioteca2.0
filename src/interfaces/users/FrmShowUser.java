package interfaces.users;


import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;



public class FrmShowUser extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    public JTable tableUsers;

    public JButton btnEdit;
    public JButton btnSavecam;
    public JButton btnClose;
   

    
    
    

    public FrmShowUser() {

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 900, 500);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(30, 30, 820, 300);
        contentPane.add(scrollPane);

        tableUsers = new JTable();
        tableUsers.setEnabled(false);

        scrollPane.setViewportView(tableUsers);

        btnEdit = new JButton("EDITAR");
        btnEdit.setBounds(100, 370, 180, 40);
        contentPane.add(btnEdit);

        btnSavecam = new JButton("GUARDAR");
        btnSavecam.setBounds(350, 370, 180, 40);
        contentPane.add(btnSavecam);
  

        btnClose = new JButton("CERRAR");
        btnClose.setBounds(600, 370, 180, 40);
        contentPane.add(btnClose);
        
    
        
        
    }
}
  

