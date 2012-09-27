package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;

import model.Invento;
import model.Inventor;

import org.jdesktop.swingx.autocomplete.*;

import controller.MySQL;



public class Busqueda extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busqueda frame = new Busqueda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Busqueda() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		setResizable(false);
		setTitle("Turroseum v.1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		JLabel lblNewLabel = new JLabel("Ingrese datos");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(39, 44, 727, 55);
		contentPane.add(lblNewLabel);
		comboBox.setBounds(39, 193, 727, 55);
		comboBox.setEditable(true);
		comboBox.setName("comboBox");
		AutoCompleteDecorator.decorate(comboBox);
		contentPane.add(comboBox);
		JRadioButton inventorbutton = new JRadioButton("Inventor");
		inventorbutton.setBounds(682, 107, 84, 23);
		contentPane.add(inventorbutton);
		JRadioButton inventobutton = new JRadioButton("Invento");
		inventobutton.setSelected(true);
		inventobutton.setBounds(594, 107, 84, 23);
		ButtonGroup botones = new ButtonGroup();
		botones.add(inventorbutton);
		botones.add(inventobutton);
		contentPane.add(inventobutton);
		
		// listeneo los botones para que cuando haga clic ejecute el handler y cargue db
		inventorbutton.addItemListener(new HandlerBotones("inventor"));
		inventobutton.addItemListener(new HandlerBotones("invento"));
		cargarCombo(comboBox,"invento");
	}
	

	private void cargarCombo(JComboBox comboBox, String tipo) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		comboBox.removeAllItems();
		MySQL db = new MySQL();
		
		if (tipo == "inventor") {
			String query = "SELECT * FROM inventores";
			ResultSet inventores = db.consulta(query);
			while (inventores.next()) {
				Inventor i = new Inventor();
				i.setNombre(inventores.getString("nombre"));
				i.setId(inventores.getInt("id"));
				comboBox.addItem(i);
			}
		}
		else {
			String query = "SELECT * FROM inventos";
			ResultSet inventos = db.consulta(query);
			while (inventos.next()) {
				Invento i = new Invento();
				i.setNombre(inventos.getString("nombre"));
				i.setId(inventos.getInt("id"));
				comboBox.addItem(i);
			}
			
		}
		
		
		
		db.cerrar();
		
		
	}
	// clase privada para handlear los botones 
	private class HandlerBotones implements ItemListener {

		private String tipo;
		
		public HandlerBotones(String tipo) {
			this.tipo = tipo;
		}
		
		public void itemStateChanged(ItemEvent e) {
			try {
				cargarCombo(comboBox,this.tipo);
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException | SQLException e1) {
				
				e1.printStackTrace();
			}
			
		} 
		
	}
	
	
}
