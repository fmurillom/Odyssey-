package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.sun.jna.NativeLibrary;

import admin.Library;
import auxiliar.LogInData;
import auxiliar.VG;
import auxiliar.XMLizer;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class LogIn extends JFrame
{
	private JPanel contentPane;
	private JTextField textField_username;
	private JTextField textField_password;
	private JButton btnLogIn;
	private JButton btnRegistrarse;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		new NativeDiscovery().discover();
		EventQueue.invokeLater(new Runnable(){
			public void run()
			{
				try
				{
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					LogIn frame = new LogIn();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LogIn()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 338, 206);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				String nick = "";
				nick = textField_username.getText();
				
				String pass = "";
				pass = textField_password.getText();
				
				if(!nick.equals("") && !pass.equals(""))
				{
					LogInData log = new LogInData(nick, pass);
					XMLizer.marshallLogInData(log);
					try
					{
						VG.sendFile(VG.PORT, "src//LogInData.xml", VG.HOST);
						Thread.sleep(500);
						VG.recieveFile();						
						
						
						NodeList n = XMLizer.getXML_value("recieved", "Status");
						String success = n.item(0).getTextContent();						
						if(success.equals("success"))
						{
							Player p = new Player();
							
							
							Library l = new Library();
							l.setSomething(nick);
							XMLizer.marshallLibrary(l);
							VG.sendFile(VG.PORT, "src/Library.xml", VG.HOST);
							Thread.sleep(500);
							VG.recieveFile();
							
							
							p.setVisible(true);
							dispose();							
						}
						else
						{
							JOptionPane.showMessageDialog(null, "No es un Usuario registrado");
						}
					}
					catch (IOException e1)
					{
						e1.printStackTrace();
					}
					catch (InterruptedException e1)
					{
				
						e1.printStackTrace();
					}
					catch (SAXException e1)
					{
						e1.printStackTrace();
					}
					catch (ParserConfigurationException e1)
					{
						e1.printStackTrace();
					}
				}
			}
		});
		textField_username = new JTextField();
		textField_username.setColumns(10);
		textField_password = new JTextField();
		textField_password.setColumns(10);		
		lblNewLabel = new JLabel("Username:");
		lblNewLabel_1 = new JLabel("Password:");		
		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				Registrarse r = new Registrarse();
				r.setVisible(true);
				dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(64, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField_password)
								.addComponent(textField_username, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnRegistrarse)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnLogIn, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)))
					.addGap(62))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField_username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(textField_password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnLogIn)
						.addComponent(btnRegistrarse))
					.addContainerGap(48, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		//this.getContentPane().setBackground(new Color(4,4,4));
		//contentPane.setBackground(Color.BLACK);		
		contentPane.setBackground(new Color(44,44,44));
		lblNewLabel.setForeground(Color.white);
		lblNewLabel_1.setForeground(Color.white);
	}
	
	public JButton getBtnLogIn()
	{
		return btnLogIn;
	}
	public JButton getBtnRegistrarse()
	{
		return btnRegistrarse;
	}
	public JTextField getTextField_password()
	{
		return textField_password;
	}
	public JTextField getTextField_username()
	{
		return textField_username;
	}
	public JLabel getLbl_username()
	{
		return lblNewLabel;
	}
	public JLabel getLbl_password()
	{
		return lblNewLabel_1;
	}
}
