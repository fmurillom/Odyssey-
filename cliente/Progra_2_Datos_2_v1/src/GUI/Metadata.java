package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import admin.Song;
import auxiliar.VG;
import auxiliar.XMLizer;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Metadata extends JDialog {
	private JTextField textFieldTitle;
	private JTextField textFieldArtist;
	private JTextField textFieldAlbum;
	private JTextField textFieldGenre;
	private JRadioButton radioButtonStar1;
	private JRadioButton radioButtonStar2;
	private JRadioButton radioButtonStar3;
	private JRadioButton radioButtonStar4;
	private JRadioButton radioButtonStar5;
	
	String estrella_negra		= "resources/20-20-30c0b39ab90fe047c67adaef12538b6c-star.png";
	String estrella_blanca		= "resources/20-20-262b0c87b6266d7ecc05b679585e7b16.png";
	String estrella_amarilla	= "resources/20-20-12fd97039b0b75db54aa7f64e84251d4.png";
	private JLabel lblTitle;
	private JLabel lblAlbum;
	private JLabel lblArtist;
	private JLabel lblGenre;
	private JButton btnOk;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			Metadata dialog = new Metadata();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Metadata()
	{
		getContentPane().setBackground(Color.DARK_GRAY);
		setBounds(100, 100, 281, 248);
		textFieldTitle = new JTextField();
		textFieldTitle.setColumns(10);
		textFieldArtist = new JTextField();
		textFieldArtist.setColumns(10);
		textFieldAlbum = new JTextField();
		textFieldAlbum.setColumns(10);
		textFieldGenre = new JTextField();
		textFieldGenre.setColumns(10);
		
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
				Genre = textFieldGenre.getText();
				
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
				Song s = new Song(Title, Album, Artist, genres, Raiting, "");
				
				
				XMLizer.marshallSong(s);
				try
				{
					VG.sendFile(VG.PORT, "src/Song.xml", VG.HOST);
					Thread.sleep(500);
					VG.sendFile(VG.PORT_to_send, VG.filePath, VG.HOST);
					JOptionPane.showMessageDialog(null, "Se envio el archivo");
					dispose();
				}
				catch (IOException e1)
				{
					
					JOptionPane.showMessageDialog(null, "No se envio el archivo");
					e1.printStackTrace();
				}
				catch (InterruptedException e1)
				{
					JOptionPane.showMessageDialog(null, "No se envio el archivo");
					e1.printStackTrace();
				}

			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(31)
							.addComponent(lblGenre)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textFieldGenre, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(35)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblArtist)
								.addComponent(lblAlbum)
								.addComponent(lblTitle))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textFieldTitle)
								.addComponent(textFieldArtist)
								.addComponent(textFieldAlbum, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(118, Short.MAX_VALUE)
					.addComponent(btnOk)
					.addGap(102))
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
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldGenre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGenre))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnOk)
					.addGap(58))
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
