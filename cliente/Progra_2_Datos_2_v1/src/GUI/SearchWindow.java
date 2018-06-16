package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import admin.Song;
import admin.Video;
import auxiliar.Search;
import auxiliar.VG;
import auxiliar.XMLizer;
import estructuras.Lista_Simple;

public class SearchWindow extends JFrame{
	private JRadioButton rdbtnVideo;
	private JRadioButton rdbtnMusic;
	

	String estrella_negra		= "../Progra_2_Datos_2_v1/resources/20-20-30c0b39ab90fe047c67adaef12538b6c-star.png";
	String estrella_blanca		= "../Progra_2_Datos_2_v1/resources/20-20-262b0c87b6266d7ecc05b679585e7b16.png";
	String estrella_amarilla	= "../Progra_2_Datos_2_v1/resources/20-20-12fd97039b0b75db54aa7f64e84251d4.png";
	private JLabel lblArtist;
	private JButton btnOk;
	private JComboBox comboBox;
	private JTextField textField;
	private JComboBox comboBox_1;
	
	Lista_Simple<Song> songL;

	
	public SearchWindow() {
		getContentPane().setBackground(Color.DARK_GRAY);
		setBounds(100, 100, 546, 414);
		
		lblArtist = new JLabel("Results:");
		lblArtist.setForeground(Color.white);
		
		
		
		btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Search search = new Search();
				
				search.setType(comboBox_1.getSelectedItem().toString());
				
				search.setSearch(textField.getText());
				
				XMLizer.marshallSearch(search);
				
				try {
					VG.sendFile(VG.PORT, "../Search.xml", VG.HOST);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					VG.recieveFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					songL = XMLizer.getXML_lib("recieved", "Song");
				} catch (SAXException | IOException | ParserConfigurationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				for(int i = 0; i < songL.getCantidad_de_nodos(); i++) {
					comboBox.addItem(songL.get_dato_por_indice(i));
				}
		
			}
		});
		
		comboBox = new JComboBox();
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblSearch = new JLabel("Search:");
		lblSearch.setForeground(Color.WHITE);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Title", "Artist", "Genre", "Album", "Rating"}));
		

		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(73, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblArtist, Alignment.TRAILING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblSearch)
							.addGap(2)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(71)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnOk)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(45)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(77)
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)))
					.addGap(55))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblSearch))
					.addGap(114)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblArtist)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
							.addComponent(btnOk)
							.addGap(45))))
		);
		getContentPane().setLayout(groupLayout);
	}
}
