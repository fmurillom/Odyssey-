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

import admin.Song;
import admin.Video;
import auxiliar.Edit;
import auxiliar.VG;
import auxiliar.XMLizer;

public class EditaData extends JFrame{
	
	Edit edit;

	private JTextField textFieldTitle;
	private JTextField textFieldArtist;
	private JTextField textFieldAlbum;
	private JRadioButton radioButtonStar1;
	private JRadioButton radioButtonStar2;
	private JRadioButton radioButtonStar3;
	private JRadioButton radioButtonStar4;
	private JRadioButton radioButtonStar5;
	private JRadioButton rdbtnVideo;
	private JRadioButton rdbtnMusic;
	private JComboBox comboBox;
	
	String estrella_negra		= "../Progra_2_Datos_2_v1/resources/20-20-30c0b39ab90fe047c67adaef12538b6c-star.png";
	String estrella_blanca		= "../Progra_2_Datos_2_v1/resources/20-20-262b0c87b6266d7ecc05b679585e7b16.png";
	String estrella_amarilla	= "../Progra_2_Datos_2_v1/resources/20-20-12fd97039b0b75db54aa7f64e84251d4.png";
	private JLabel lblTitle;
	private JLabel lblAlbum;
	private JLabel lblArtist;
	private JLabel lblGenre;
	private JButton btnOk;
	
	public EditaData(Edit edit1) {
		
		this.edit = edit1;
		
		getContentPane().setBackground(Color.DARK_GRAY);
		setBounds(100, 100, 281, 407);
		textFieldTitle = new JTextField();
		textFieldTitle.setColumns(10);
		textFieldArtist = new JTextField();
		textFieldArtist.setColumns(10);
		textFieldAlbum = new JTextField();
		textFieldAlbum.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		
		radioButtonStar1 = new JRadioButton("");
		radioButtonStar1.setBackground(Color.DARK_GRAY);
		radioButtonStar1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(radioButtonStar1.isSelected())
				{
					radioButtonStar1.setIcon(new ImageIcon(estrella_amarilla));
				}
				else
				{
					radioButtonStar1.setIcon(new ImageIcon(estrella_blanca));
					radioButtonStar2.setSelected(false);radioButtonStar2.setIcon(new ImageIcon(estrella_blanca));
					radioButtonStar3.setSelected(false);radioButtonStar3.setIcon(new ImageIcon(estrella_blanca));
					radioButtonStar4.setSelected(false);radioButtonStar4.setIcon(new ImageIcon(estrella_blanca));
					radioButtonStar5.setSelected(false);radioButtonStar5.setIcon(new ImageIcon(estrella_blanca));
				}
			}
		});
		radioButtonStar1.setIcon(new ImageIcon(estrella_blanca));
		radioButtonStar1.setBorder(null);
						
		radioButtonStar2 = new JRadioButton("");
		radioButtonStar2.setBackground(Color.DARK_GRAY);
		radioButtonStar2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(radioButtonStar1.isSelected() && radioButtonStar2.isSelected())
				{
					radioButtonStar2.setIcon(new ImageIcon(estrella_amarilla));
				}
				else
				{
					radioButtonStar2.setIcon(new ImageIcon(estrella_blanca));
					radioButtonStar3.setSelected(false);radioButtonStar3.setIcon(new ImageIcon(estrella_blanca));
					radioButtonStar4.setSelected(false);radioButtonStar4.setIcon(new ImageIcon(estrella_blanca));
					radioButtonStar5.setSelected(false);radioButtonStar5.setIcon(new ImageIcon(estrella_blanca));
				}
			}
		});
		radioButtonStar2.setIcon(new ImageIcon(estrella_blanca));
		radioButtonStar2.setBorder(null);
				
		radioButtonStar3 = new JRadioButton("");
		radioButtonStar3.setBackground(Color.DARK_GRAY);
		radioButtonStar3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(radioButtonStar1.isSelected() && radioButtonStar2.isSelected() && radioButtonStar3.isSelected())
				{
					radioButtonStar3.setIcon(new ImageIcon(estrella_amarilla));
				}
				else
				{
					radioButtonStar3.setIcon(new ImageIcon(estrella_blanca));
					radioButtonStar4.setSelected(false);radioButtonStar4.setIcon(new ImageIcon(estrella_blanca));
					radioButtonStar5.setSelected(false);radioButtonStar5.setIcon(new ImageIcon(estrella_blanca));
				}				
			}
		});
		radioButtonStar3.setIcon(new ImageIcon(estrella_blanca));
		radioButtonStar3.setBorder(null);
						
		radioButtonStar4 = new JRadioButton("");
		radioButtonStar4.setBackground(Color.DARK_GRAY);
		radioButtonStar4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(radioButtonStar1.isSelected() && radioButtonStar2.isSelected() && radioButtonStar3.isSelected() && radioButtonStar4.isSelected())
				{
					radioButtonStar4.setIcon(new ImageIcon(estrella_amarilla));
				}
				else
				{
					radioButtonStar4.setIcon(new ImageIcon(estrella_blanca));
					radioButtonStar5.setSelected(false);radioButtonStar5.setIcon(new ImageIcon(estrella_blanca));
				}								
			}
		});
		radioButtonStar4.setIcon(new ImageIcon(estrella_blanca));
		radioButtonStar4.setBorder(null);
						
								
		radioButtonStar5 = new JRadioButton("");
		radioButtonStar5.setBackground(Color.DARK_GRAY);
		radioButtonStar5.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(radioButtonStar1.isSelected() && radioButtonStar2.isSelected() && radioButtonStar3.isSelected() && radioButtonStar4.isSelected() && radioButtonStar5.isSelected())
				{
					radioButtonStar5.setIcon(new ImageIcon(estrella_amarilla));
				}
				else
				{
					radioButtonStar5.setIcon(new ImageIcon(estrella_blanca));
				}												
			}
		});
		radioButtonStar5.setIcon(new ImageIcon(estrella_blanca));
		radioButtonStar5.setBorder(null);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 224, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(22)
					.addComponent(radioButtonStar1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(radioButtonStar2, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(radioButtonStar3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(radioButtonStar4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(radioButtonStar5, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(28))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 47, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(radioButtonStar5, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(radioButtonStar3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(radioButtonStar2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(radioButtonStar4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(radioButtonStar1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		lblTitle = new JLabel("Title:");
		lblTitle.setForeground(Color.white);
		
		lblAlbum = new JLabel("Album:");
		lblAlbum.setForeground(Color.white);
		
		lblArtist = new JLabel("Artist:");
		lblArtist.setForeground(Color.white);
		
		lblGenre = new JLabel("Genre:");
		lblGenre.setForeground(Color.white);
		
		
		
		btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String Title = "";
				String Album = "";
				String Artist = "";
				String Raiting = "";
				String Genre = "";
				
				Title = textFieldTitle.getText();
				Album = textFieldAlbum.getText();
				Artist = textFieldArtist.getText();
				Genre = comboBox.getSelectedItem().toString();
				
				if(radioButtonStar5.isSelected())
				{
					Raiting = "*****";
				}
				else if(radioButtonStar4.isSelected())
				{
					Raiting = "****";
				}
				else if(radioButtonStar3.isSelected())
				{
					Raiting = "***";
				}

				else if(radioButtonStar2.isSelected())
				{
					Raiting = "**";
				}

				else if(radioButtonStar1.isSelected())
				{
					Raiting = "*";
				}
				else
				{
					Raiting = "0";
				}
				String[] genres = {Genre};

				
				edit.setNtitle(Title);
				edit.setNartist(Artist);
				edit.setNalbum(Album);
				edit.setNgenre(Genre);
				edit.setNraiting(Raiting);
				
				XMLizer.marshallEdit(edit);
				
				try {
					VG.sendFile(VG.PORT, "../Edit.xml", VG.HOST);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Blues", "Clasica", "Country", "Cumbia", "Disco", "Electronica", "Folk", "Funk", "Heavy Metal", "Hip Hop", "Indie", "Jazz", "Pop", "Punk", "Rap", "Rock"}));
		

		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(45, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblArtist)
						.addComponent(lblAlbum)
						.addComponent(lblTitle))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textFieldTitle)
						.addComponent(textFieldArtist)
						.addComponent(textFieldAlbum, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
					.addGap(29))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(45, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblGenre)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnOk)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTitle))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldArtist, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAlbum))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldAlbum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblArtist))
					.addGap(36)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addGap(94)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblGenre)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addComponent(btnOk)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
	public JRadioButton getRadioButtonStar1() {
		return radioButtonStar1;
	}
	public JRadioButton getRadioButtonStar2() {
		return radioButtonStar2;
	}
	public JRadioButton getRadioButtonStar3() {
		return radioButtonStar3;
	}
	public JRadioButton getRadioButtonStar4() {
		return radioButtonStar4;
	}
	public JRadioButton getRadioButtonStar5() {
		return radioButtonStar5;
	}
	public JRadioButton getRbtnVideo() {
		return this.rdbtnVideo;
	}
	public JRadioButton getRbtnMusic() {
		return this.rdbtnMusic;
	}
	public JLabel getLblTitle() {
		return lblTitle;
	}
	public JLabel getLblAlbum() {
		return lblAlbum;
	}
	public JLabel getLblArtist() {
		return lblArtist;
	}
	public JLabel getLblGenre() {
		return lblGenre;
	}
	public JButton getBtnOk() {
		return btnOk;
	}
}
