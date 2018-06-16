package GUI;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Panel;
import javax.swing.JSeparator;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Label;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import admin.Song;
import admin.UsrRqst;
import auxiliar.Recomendacion;
import auxiliar.VG;
import auxiliar.XMLizer;
import estructuras.Lista_Simple;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class RecommendWindow extends JFrame{
	
	Song recomend;
	JComboBox comboBox;
	
	Lista_Simple<String> users;
	
	public RecommendWindow(Song song) {
		getContentPane().setBackground(Color.DARK_GRAY);
		
		setBounds(100, 100, 450, 201);
		
		recomend = song;
		
		comboBox = new JComboBox();
		
		UsrRqst request = new UsrRqst("dummy");
		
		XMLizer.marshallUsrRqst(request);
		
		try {
			VG.sendFile(VG.PORT, "../coms.xml", VG.HOST);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try {
			VG.recieveFile();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try {
			users = XMLizer.getXML_usr("recieved", "Users");
		} catch (SAXException | IOException | ParserConfigurationException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		for(int i = 0; i < users.getCantidad_de_nodos(); i++) {
			comboBox.addItem(users.get_dato_por_indice(i));
		}
		
		JLabel lblAmigos = new JLabel("Amigos");
		lblAmigos.setForeground(Color.WHITE);
		
		JButton btnRecommend = new JButton("Recommend");
		btnRecommend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Recomendacion rec = new Recomendacion();
				rec.setUserName(VG.USER);
				rec.setArtist(recomend.getArtist());
				rec.setFriend(comboBox.getSelectedItem().toString());
				rec.setSongName(recomend.getTitle());
				
				XMLizer.marshallRecomendation(rec);
				
				try {
					VG.sendFile(VG.PORT, "../Rec.xml", VG.HOST);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(47)
					.addComponent(lblAmigos)
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnRecommend)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(142, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAmigos))
					.addGap(62)
					.addComponent(btnRecommend)
					.addContainerGap(124, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
}
