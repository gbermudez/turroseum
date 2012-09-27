package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Inventor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class FichaInventor extends JFrame {

	private JPanel contentPane;

	
	public FichaInventor(Inventor inventor) {
		setResizable(false);
		setTitle("Turroseum v1.0 | INVENTORES | " + inventor.getNombre());
		setBounds(100, 100, 462, 237);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Color.RED);
		lblNombre.setBounds(12, 77, 70, 15);
		contentPane.add(lblNombre);
		
		JLabel lblAnioDeNacimiento = new JLabel("Anio de Nacimiento:");
		lblAnioDeNacimiento.setForeground(Color.RED);
		lblAnioDeNacimiento.setBounds(12, 116, 146, 15);
		contentPane.add(lblAnioDeNacimiento);
		
		JLabel lblLugarDeNacimiento = new JLabel("Lugar de Nacimiento:");
		lblLugarDeNacimiento.setForeground(Color.RED);
		lblLugarDeNacimiento.setBounds(12, 153, 167, 15);
		contentPane.add(lblLugarDeNacimiento);
		
		JLabel lblInventor = new JLabel("Inventor");
		lblInventor.setFont(new Font("Dialog", Font.BOLD, 20));
		lblInventor.setBounds(178, 12, 101, 32);
		contentPane.add(lblInventor);
		
		JLabel namelbl = new JLabel(inventor.getNombre());
		namelbl.setBounds(98, 77, 70, 15);
		contentPane.add(namelbl);
		
		JLabel aniolbl = new JLabel(String.valueOf(inventor.getAnioN()));
		aniolbl.setBounds(170, 116, 70, 15);
		contentPane.add(aniolbl);
		
		JLabel lugarlbl = new JLabel(inventor.getLugarN());
		lugarlbl.setBounds(178, 153, 70, 15);
		contentPane.add(lugarlbl);
		setVisible(true);
	}
}
