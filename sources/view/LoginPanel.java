package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import model.SQLHandler;

import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.JPasswordField;
import java.awt.Color;

public class LoginPanel extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField pwdPassword;
	private JLabel errorTxt = new JLabel("");

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public LoginPanel() {
		setTitle("Turroseum 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblAdministracion = new JLabel("Administracion");
		lblAdministracion.setFont(new Font("Dialog", Font.BOLD, 20));
		lblAdministracion.setBounds(131, 12, 196, 15);
		contentPane.add(lblAdministracion);
		
		txtUsuario = new JTextField();
		txtUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					txtUsuario.setText("");
				
			}
		});

		errorTxt.setForeground(Color.RED);
		errorTxt.setBounds(68, 138, 352, 15);
		contentPane.add(errorTxt);
		txtUsuario.setText("Usuario");
		txtUsuario.setBounds(142, 40, 152, 19);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SQLHandler handler = new SQLHandler();
				try {
					// chequeo usuario y pass si esta mal seteo lbl.
					if (!handler.loguear(txtUsuario.getText(), pwdPassword.getText())) {
						errorTxt.setText("Error en el usuario o password ingresado");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEntrar.setBounds(175, 102, 97, 25);
		contentPane.add(btnEntrar);
		
		pwdPassword = new JPasswordField("pass");
		pwdPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					pwdPassword.setText("");
				
				
			}
		});
		pwdPassword.setText("password");
		pwdPassword.setBounds(141, 71, 153, 19);
		contentPane.add(pwdPassword);
		
		JLabel label = new JLabel("Turrogrammers Inc.");
		label.setBounds(305, 165, 147, 23);
		contentPane.add(label);
		
	}
}
