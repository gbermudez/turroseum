package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JComboBox;

import com.sun.net.ssl.internal.www.protocol.https.Handler;

import model.Invento;
import model.Inventor;
import model.Periodo;
import model.SQLHandler;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.Window.Type;

public class InventosSimilares extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public InventosSimilares(final Invento invento) throws SQLException {
		setResizable(false);
		setModal(true);
		
		final SQLHandler handler = new SQLHandler();
		ResultSet inventos = handler.getInventosSimilares(invento.getPeriodo().getId(), invento.getId());
		
		setBounds(100, 100, 419, 196);
		getContentPane().setLayout(null);
		final JComboBox comboBox = new JComboBox();
		comboBox.removeAll();
		JLabel lblInvento = new JLabel("INVENTOS SIMILARES");
		lblInvento.setHorizontalAlignment(SwingConstants.CENTER);
		lblInvento.setFont(new Font("Dialog", Font.BOLD, 20));
		lblInvento.setBounds(12, 12, 388, 31);
		getContentPane().add(lblInvento);
		
		

		while (inventos.next()) {
			Invento i = new Invento();
			i.setNombre(inventos.getString("nombre"));
			i.setId(inventos.getInt("id"));
			i.setPeriodo(handler.getPeriodo(inventos.getInt("periodo")));
			i.setDescripcion(inventos.getString("descripcion"));
			comboBox.addItem(i);
		}
		
		JButton btnVer = new JButton("Ver");
		btnVer.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				try {
					new FichaInvento((Invento) comboBox.getSelectedItem());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnVer.setBounds(334, 111, 59, 25);
		getContentPane().add(btnVer);
		
		JLabel label = new JLabel("Turrogrammers Inc.");
		label.setBounds(253, 148, 147, 15);
		getContentPane().add(label);
		
		comboBox.setBounds(12, 75, 377, 24);
		getContentPane().add(comboBox);
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		handler.sumarVista(invento.getId());
		setVisible(true);
	}
}
