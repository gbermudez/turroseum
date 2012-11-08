package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Inventor;
import model.SQLHandler;

import java.awt.Dialog.ModalityType;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AltaInventor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nombre;
	private JTextField anio;
	private JTextField lugar;
	private JLabel mensaje = new JLabel("");


	
	public AltaInventor() {
		setModal(true);
		setBounds(100, 100, 437, 313);
		
		setResizable(false);
		setTitle("Turroseum v1.0 | ALTA INVENTORES");
		getContentPane().setLayout(null);
		
		JLabel lblInventor = new JLabel("ALTA INVENTOR");
		lblInventor.setFont(new Font("Dialog", Font.BOLD, 20));
		lblInventor.setBounds(131, 12, 191, 31);
		getContentPane().add(lblInventor);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Color.RED);
		lblNombre.setBounds(12, 68, 70, 15);
		getContentPane().add(lblNombre);
		
		JLabel lblAnioDeNacimiento = new JLabel("Anio De Nacimiento:");
		lblAnioDeNacimiento.setForeground(Color.RED);
		lblAnioDeNacimiento.setBounds(12, 111, 148, 15);
		getContentPane().add(lblAnioDeNacimiento);
		
		JLabel lblLugarDeNacimiento = new JLabel("Lugar De Nacimiento:");
		lblLugarDeNacimiento.setForeground(Color.RED);
		lblLugarDeNacimiento.setBounds(12, 151, 165, 15);
		getContentPane().add(lblLugarDeNacimiento);
		
		JLabel label = new JLabel("Turrogrammers Inc.");
		label.setBounds(288, 257, 147, 23);
		getContentPane().add(label);
		
		JButton agregar = new JButton("Agregar");
		agregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SQLHandler handler = new SQLHandler();
				
				try {
					if (handler.agregarInventor(nombre.getText(), Integer.parseInt(anio.getText()), lugar.getText())) {
						mensaje.setText("Se agrego correctamente");
					}
					else {
						mensaje.setText("No se agrego");
					}
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});

		agregar.setBounds(152, 190, 94, 25);
		getContentPane().add(agregar);
		
		nombre = new JTextField();
		nombre.setBounds(82, 66, 222, 19);
		getContentPane().add(nombre);
		nombre.setColumns(10);
		
		anio = new JTextField();
		anio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();

			      // Verificar si la tecla pulsada no es un digito
			      if(((caracter < '0') ||
			         (caracter > '9')) &&
			         (caracter != '\b' /*corresponde a BACK_SPACE*/))
			      {
			         e.consume();  // ignorar el evento de teclado
			      }
			}
		});
		anio.setBounds(164, 109, 114, 19);
		getContentPane().add(anio);
		anio.setColumns(10);
		
		lugar = new JTextField();
		lugar.setBounds(174, 149, 211, 19);
		getContentPane().add(lugar);
		lugar.setColumns(10);
		
		mensaje.setHorizontalAlignment(SwingConstants.CENTER);
		mensaje.setForeground(Color.RED);
		mensaje.setBounds(33, 230, 352, 15);
		getContentPane().add(mensaje);
		
		setVisible(true);
		
	}
}

