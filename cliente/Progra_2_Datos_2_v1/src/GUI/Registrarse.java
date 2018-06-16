package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import admin.User;
import admin.UsrRqst;
import auxiliar.Sender;
import auxiliar.VG;
import auxiliar.XMLizer;
import estructuras.Lista_Simple;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;

public class Registrarse extends JFrame
{
	private JPanel contentPane;
	private JTextField textField_username;
	private JTextField textField_name;
	private JTextField textField_apellido_1;
	private JPasswordField passwordField;
	private JButton btnAtras_atras;
	private JButton btnAgregar_agregar;
	private JSpinner spinner_edad;
	private JLabel lblUsername;
	private JLabel lblName;
	private JLabel lblPassword;
	private JLabel lblLastname;
	private JLabel lblAge;
	private JLabel lblGenres;
	private JLabel lblFriendNickname;
	private JButton btnRegistrarse;

	
	Lista_Simple<String> users = new Lista_Simple<>();
	Lista_Simple<String> genres = new Lista_Simple<>();
	Lista_Simple<String> friends = new Lista_Simple<>();
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[
	                               ] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Registrarse frame = new Registrarse();
					frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ParserConfigurationException 
	 * @throws SAXException 
	 */
	public Registrarse()
	{
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
			comboBox_1.addItem(users.get_dato_por_indice(i));
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textField_username = new JTextField();
		textField_username.setColumns(10);
		
		textField_name = new JTextField();
		textField_name.setColumns(10);
		
		textField_apellido_1 = new JTextField();
		textField_apellido_1.setColumns(10);
		
		spinner_edad = new JSpinner();
		
		passwordField = new JPasswordField();
		btnAgregar_agregar = new JButton("Agregar");
		btnAgregar_agregar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String nickFriend = comboBox_1.getSelectedItem().toString();
				friends.insertar_al_final(nickFriend);
				System.out.println("amigo insertado a la lista");
			}
		});
		btnAtras_atras = new JButton("Atras");
		btnAtras_atras.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				LogIn l = new LogIn();
				l.setVisible(true);
				dispose();
			}
		});
		
		lblUsername = new JLabel("Username:");
		
		lblName = new JLabel("Name:");
		
		lblPassword = new JLabel("Password:");
		
		lblLastname = new JLabel("Lastname:");
		
		lblAge = new JLabel("Age:");
		
		lblGenres = new JLabel("Genres:");
		
		lblFriendNickname = new JLabel("Friend Nickname:");
		
		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String nick = textField_username.getText();
				String name = textField_name.getText() + " " +textField_apellido_1.getText();
				String apellido = textField_apellido_1.getText();
				String password = passwordField.getText();
				String edad = spinner_edad.getValue().toString();
				
		    	String[] generos = new String[genres.getCantidad_de_nodos()];
		    	for(int i=0; i <genres.getCantidad_de_nodos(); i++)
		    	{
		    		generos[i] = genres.get_dato_por_indice(i);
		    	}

		    	String[] amigos = new String[friends.getCantidad_de_nodos()];
		    	for(int i=0; i <friends.getCantidad_de_nodos(); i++)
		    	{
		    		amigos[i] = friends.get_dato_por_indice(i);
		    	}

				
				User u = new User(nick, password, name, edad, generos, amigos);
				XMLizer.marshallUser(u);
				try
				{
					//sendFile(Integer.parseInt(VG.PORT), "src//coms.xml", VG.HOST);
					VG.sendFile(VG.PORT, "../coms.xml", VG.HOST);
				}
				catch (NumberFormatException | IOException e1)
				{
					e1.printStackTrace();
				}
				
				
			}
		});
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Blues", "Clasica", "Country", "Cumbia", "Disco", "Electronica", "Folk", "Funk", "Heavy Metal", "Hip Hop", "Indie", "Jazz", "Pop", "Punk", "Rap", "Rock"}));
		
		JButton button = new JButton("Agregar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String genre = comboBox.getSelectedItem().toString();
				genres.insertar_al_final(genre);
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblAge)
						.addComponent(lblPassword)
						.addComponent(lblLastname)
						.addComponent(lblGenres)
						.addComponent(lblName)
						.addComponent(lblUsername)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(btnAtras_atras)
							.addComponent(lblFriendNickname)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(textField_name, Alignment.LEADING, 134, 175, Short.MAX_VALUE)
										.addComponent(textField_username, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
										.addComponent(textField_apellido_1, Alignment.LEADING, 134, 175, Short.MAX_VALUE)
										.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
										.addComponent(btnRegistrarse, Alignment.LEADING)
										.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
											.addGap(12)
											.addComponent(comboBox_1, 0, 216, Short.MAX_VALUE)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnAgregar_agregar)
									.addGap(20))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
									.addComponent(button, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(76)
							.addComponent(spinner_edad, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblUsername))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblName))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_apellido_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblLastname))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPassword))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblAge)
								.addComponent(spinner_edad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblGenres)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFriendNickname)
								.addComponent(btnAgregar_agregar, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAtras_atras)
						.addComponent(btnRegistrarse))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		contentPane.setBackground(new Color(44,44,44));
		lblUsername.setForeground(Color.white);
		lblName.setForeground(Color.white);
		lblLastname.setForeground(Color.white);
		lblPassword.setForeground(Color.white);
		lblAge.setForeground(Color.white);
		lblGenres.setForeground(Color.white);
		lblFriendNickname.setForeground(Color.white);
		
		this.setTitle("Register");
	}
	
	public JButton getBtnAtras_atras()
	{
		return btnAtras_atras;
	}
	public JButton getBtnAgregar_agregar()
	{
		return btnAgregar_agregar;
	}
	public JPasswordField getPasswordField()
	{
		return passwordField;
	}
	public JSpinner getSpinner_edad()
	{
		return spinner_edad;
	}
	public JTextField getTextField_apellido_1()
	{
		return textField_apellido_1;
	}
	public JTextField getTextField_name()
	{
		return textField_name;
	}
	public JTextField getTextField_username()
	{
		return textField_username;
	}
	public JLabel getLblUsername() {
		return lblUsername;
	}
	public JLabel getLblName() {
		return lblName;
	}
	public JLabel getLblPassword() {
		return lblPassword;
	}
	public JLabel getLblFriendNickname() {
		return lblFriendNickname;
	}
	public JLabel getLblGenres() {
		return lblGenres;
	}
	public JLabel getLblAge() {
		return lblAge;
	}
	public JLabel getLblLastname() {
		return lblLastname;
	}
	
	public JButton getBtnRegistrarse() {
		return btnRegistrarse;
	}
}
