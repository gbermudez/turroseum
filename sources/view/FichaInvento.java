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

public class FichaInvento extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public FichaInvento(final Invento invento) throws SQLException {
		setResizable(false);
		setModal(true);
		
		final SQLHandler handler = new SQLHandler();

		setBounds(100, 100, 419, 388);
		getContentPane().setLayout(null);
		
		JLabel lblInvento = new JLabel("INVENTO");
		lblInvento.setHorizontalAlignment(SwingConstants.CENTER);
		lblInvento.setFont(new Font("Dialog", Font.BOLD, 20));
		lblInvento.setBounds(12, 12, 388, 31);
		getContentPane().add(lblInvento);
		
		JLabel lblName = new JLabel(invento.getNombre());
		lblName.setFont(new Font("Dialog", Font.BOLD, 18));
		lblName.setForeground(Color.RED);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(12, 71, 388, 15);
		getContentPane().add(lblName);
			
		
		
		
		JLabel lblPeriodo = new JLabel(invento.getPeriodo().getNombre());
		lblPeriodo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPeriodo.setForeground(Color.GRAY);
		lblPeriodo.setBounds(12, 109, 388, 15);
		getContentPane().add(lblPeriodo);
		
		JLabel lblDescripcion = new JLabel(invento.getDescripcion());
		lblDescripcion.setForeground(Color.DARK_GRAY);
		lblDescripcion.setVerticalAlignment(SwingConstants.TOP);
		lblDescripcion.setBounds(12, 143, 388, 78);
		getContentPane().add(lblDescripcion);
		
		JLabel lblInventores = new JLabel("Inventor/es");
		lblInventores.setBounds(12, 237, 93, 15);
		getContentPane().add(lblInventores);
		
		final JComboBox comboBox = new JComboBox();		
		comboBox.setBounds(12, 264, 317, 24);
		getContentPane().add(comboBox);
		
		JButton btnVer = new JButton("Ver");
		btnVer.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				if (comboBox.getSelectedIndex() >= 0) {
					setVisible(false);
					new FichaInventor((Inventor)comboBox.getSelectedItem());
				}
				else {
					
				}
			}
		});
		btnVer.setBounds(341, 264, 59, 25);
		getContentPane().add(btnVer);
		
		JLabel label = new JLabel("Turrogrammers Inc.");
		label.setBounds(270, 338, 147, 15);
		getContentPane().add(label);
		
		JButton btnVotar = new JButton("Votar");
		btnVotar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					handler.sumarVoto(invento.getId());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnVotar.setBounds(12, 328, 80, 25);
		getContentPane().add(btnVotar);
		
		JButton btnRelacionados = new JButton("Similares");
		btnRelacionados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				try {
					new InventosSimilares(invento);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRelacionados.setBounds(100, 328, 107, 25);
		getContentPane().add(btnRelacionados);
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		handler.sumarVista(invento.getId());
		
		ArrayList<Inventor> inventores = handler.getInventoresByInvento(invento.getId());
		Iterator it = inventores.iterator();
		
		while (it.hasNext()) {
			comboBox.addItem(it.next());
		}
		
		setVisible(true);
	}
}
