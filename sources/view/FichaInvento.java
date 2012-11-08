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
		
		final SQLHandler handler = new SQLHandler();

		setBounds(100, 100, 419, 384);
		getContentPane().setLayout(null);
		
		JLabel lblInvento = new JLabel("INVENTO");
		lblInvento.setFont(new Font("Dialog", Font.BOLD, 20));
		lblInvento.setBounds(151, 12, 130, 31);
		getContentPane().add(lblInvento);
		
		JLabel lblName = new JLabel(invento.getNombre());
		lblName.setForeground(Color.RED);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(12, 71, 388, 15);
		getContentPane().add(lblName);
			
		
		
		
		JLabel lblPeriodo = new JLabel(invento.getPeriodo().getNombre());
		lblPeriodo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPeriodo.setForeground(Color.BLACK);
		lblPeriodo.setBounds(12, 109, 388, 15);
		getContentPane().add(lblPeriodo);
		
		JLabel lblDescripcion = new JLabel(invento.getDescripcion());
		lblDescripcion.setVerticalAlignment(SwingConstants.TOP);
		lblDescripcion.setBounds(12, 143, 388, 78);
		getContentPane().add(lblDescripcion);
		
		JLabel lblInventores = new JLabel("Inventor/es");
		lblInventores.setBounds(12, 237, 93, 15);
		getContentPane().add(lblInventores);
		
		JComboBox comboBox = new JComboBox();		
		comboBox.setBounds(12, 264, 317, 24);
		getContentPane().add(comboBox);
		
		JButton btnVer = new JButton("Ver");
		btnVer.setBounds(341, 264, 59, 25);
		getContentPane().add(btnVer);
		
		JLabel label = new JLabel("Turrogrammers Inc.");
		label.setBounds(270, 329, 147, 24);
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
		btnVotar.setBounds(12, 329, 80, 25);
		getContentPane().add(btnVotar);
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
