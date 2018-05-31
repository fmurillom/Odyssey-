package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.sun.jna.NativeLibrary;

import admin.Library;
import admin.Song;
import auxiliar.Delete;
import auxiliar.VG;
import auxiliar.XMLizer;
import estructuras.Lista_Simple;
import uk.co.caprica.vlcj.component.EmbeddedMediaListPlayerComponent;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;
import uk.co.caprica.vlcj.player.AudioTrackInfo;
import uk.co.caprica.vlcj.player.TrackInfo;
import uk.co.caprica.vlcj.player.TrackType;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JProgressBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Player extends JFrame {

	private JPanel contentPane;
	private JLabel lblCurrentTime;
	private JLabel lblTotalTime;
	private JButton btnAtras;
	private JButton btnPausar;

	String estrella_negra		= "resources/20-20-30c0b39ab90fe047c67adaef12538b6c-star.png";
	String estrella_blanca		= "resources/20-20-262b0c87b6266d7ecc05b679585e7b16.png";
	String estrella_amarilla	= "resources/20-20-12fd97039b0b75db54aa7f64e84251d4.png";
	String pausa 				= "resources/24-24-7f94cbb88c4da5c5d4660a475d0d33b6.png";
	String atras 				= "resources/24-24-f9bfcd176faf105f9604ef3f7c99e557-back.png";
	String pausa_pq 			= "resources/20-20-7f94cbb88c4da5c5d4660a475d0d33b6.png";
	String share 				= "resources/share.png";
	String share_pq 			= "resources/share_pq.png";
	String load 				= "resources/load.png";
	String load_pq 				= "resources/load_pq.png";
	String upload 				= "resources/upload.png";
	String upload_pq 			= "resources/upload_pq.png";
	
	Lista_Simple<Song> songs = new Lista_Simple<>();
	DefaultTableModel model = new DefaultTableModel();
	
	int INDEX = 0;
	
	private final EmbeddedMediaPlayerComponent EMPC = new EmbeddedMediaPlayerComponent();
	
	private JButton buttonShare;
	private JTable table;
	private JButton buttonRecharge;
	private JButton buttonSend;
	private JButton buttonBorrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		//new NativeDiscovery().discover();
		NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "/usr/lib/x86_64-linux-gnu/");
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Player frame = new Player();
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
	 * @throws InterruptedException 
	 * @throws ParserConfigurationException 
	 * @throws SAXException 
	 */
	public Player() throws IOException, InterruptedException, SAXException, ParserConfigurationException
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		contentPane = new JPanel();
		contentPane.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent e)
			{
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					
				}
			}
			@Override
			public void keyTyped(KeyEvent e)
			{
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					
				}				
			}
		});
		contentPane.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				
			}
			@Override
			public void mouseEntered(MouseEvent e)
			{
				
			}
			@Override
			public void mousePressed(MouseEvent e)
			{
				
			}
		});
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		try
		{
					
		}
		catch(Exception ex){System.out.println(ex);}
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		
		
		JSlider slider = new JSlider();
		slider.setBackground(Color.DARK_GRAY);
		
		
		lblCurrentTime = new JLabel("0.00");
		lblCurrentTime.setForeground(Color.white);
		
		
		lblTotalTime = new JLabel("0.00");
		lblTotalTime.setForeground(Color.white);
		
		
		JButton btnPlay = new JButton("");
		btnPlay.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				EMPC.getMediaPlayer().play();
				System.out.println(EMPC.getMediaPlayer().getPosition());
			}
		});
		btnPlay.setBackground(Color.DARK_GRAY);
		btnPlay.setIcon(new ImageIcon("resources/24-24-9c7a40b082dc2533216bc547c9315bf3.png"));
		btnPlay.setPressedIcon(new ImageIcon("resources/20-20-9c7a40b082dc2533216bc547c9315bf3.png"));
		btnPlay.setBorder(null);
		
		
		
		btnPausar = new JButton("");
		btnPausar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				EMPC.getMediaPlayer().pause();
			}
		});
		btnPausar.setBackground(Color.DARK_GRAY);
		btnPausar.setIcon(new ImageIcon(pausa));
		btnPausar.setPressedIcon(new ImageIcon(pausa_pq));
		
		btnAtras = new JButton("");
		btnAtras.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				LogIn l = new LogIn();
				l.setVisible(true);
				dispose();
			}
		});		
		btnAtras.setBackground(Color.DARK_GRAY);
		btnAtras.setIcon(new ImageIcon(atras));
		
								
		buttonShare = new JButton("");
		buttonShare.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Share s = new Share();
				s.show();
			}
		});
		
		
		buttonShare.setIcon(new ImageIcon(share));
		buttonShare.setPressedIcon(new ImageIcon(share_pq));
		buttonShare.setBorder(null);
		buttonShare.setBackground(Color.DARK_GRAY);
		
		buttonBorrar = new JButton("");
		buttonBorrar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String title = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
				String album = table.getModel().getValueAt(table.getSelectedRow(), 2).toString();
				String artist = table.getModel().getValueAt(table.getSelectedRow(), 1).toString();
				
				Delete l = new Delete(title, album, artist);
				
				

				XMLizer.marshallDelete(l);
				try
				{
					EMPC.getMediaPlayer().stop();
					VG.sendFile(VG.PORT, "src/Del.xml", VG.HOST);
					System.out.println("Solicitud de borrar: " + title);
					Thread.sleep(500);
					VG.recieveFile();
					songs = XMLizer.getXML_lib("recieved", "Song");
					setRows();
				}
				catch (IOException e2)
				{
					e2.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SAXException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParserConfigurationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try
				{
					Thread.sleep(500);
				}
				catch (InterruptedException e1)
				{
					e1.printStackTrace();
				}

				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		buttonBorrar.setBackground(Color.DARK_GRAY);
		
		//btnAtras.setBorder(null);
		
		
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblCurrentTime)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(slider, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(lblTotalTime))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnAtras, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnPlay, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnPausar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(buttonShare, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(buttonBorrar, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 12, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblTotalTime))
						.addComponent(lblCurrentTime)
						.addComponent(slider, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnAtras, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
						.addComponent(btnPausar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
						.addComponent(btnPlay, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
						.addComponent(buttonShare, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonBorrar, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);




//		String[] g1 = {"Rock"};
//		String[] g2 = {"Jazz"};
//		String[] g3 = {"Dubstep"};
//		String[] g4 = {"Electronic"};
//		String[] g5 = {"Clasic"};;
//		Song s1 = new Song("A1", "B1", "C1", g1, "D1", "E1");
//		Song s2 = new Song("A2", "B2", "C2", g2, "D2", "E2");
//		Song s3 = new Song("A3", "B3", "C3", g3, "D3", "E3");
//		Song s4 = new Song("A4", "B4", "C4", g4, "D4", "E4");
//		Song s5 = new Song("A5", "B5", "C5", g5, "D5", "E5");
		
		
//		Lista_Simple<Song> songs = new Lista_Simple<>();
//		songs.insertar_al_final(s1);
//		songs.insertar_al_final(s2);
//		songs.insertar_al_final(s3);
//		songs.insertar_al_final(s4);
//		songs.insertar_al_final(s5);
//		songs.mostrarln();


//		Library l = new Library();
//		XMLizer.marshallLibrary(l);
//		VG.sendFile(VG.PORT, "src/Library.xml", VG.HOST);
//		Thread.sleep(500);
//		VG.recieveFile();		
//		songs = XMLizer.getXML_lib("recieved", "Song");
//		songs.mostrarln();
		

		//table = new JTable(new DefaultTableModel(new Object[]{"Title", "Artist", "Album", "Genre", "Rating"}, 1000));
		
		table = new JTable(model); 
		table.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				Object o = table.getModel().getValueAt(table.getSelectedRow(), 0);
				String s = o.toString();
				System.out.println(s);
				
				String path = "";
				for(int i=0; i < songs.getCantidad_de_nodos(); i++)
				{
					Song song = songs.get_dato_por_indice(i);
					if(song.getTitle().equals(s))
					{
						path = song.getPath();
					}
				}
								
				System.out.println("Path: " + path);
				EMPC.getMediaPlayer().playMedia(path);
				
				
			}
		});

		// Create a couple of columns 
		model.addColumn("Title"); 
		model.addColumn("Artist");
		model.addColumn("Album");
		model.addColumn("Genre");
		model.addColumn("Rating");

		setRows();
			
		JScrollPane jsc = new JScrollPane(table);
		jsc.setPreferredSize(new Dimension(400, 150));
		getContentPane().add(jsc);		
		
		
		
		
		
		
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println(comboBox.getSelectedItem().toString());//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
				Library l = new Library();
				l.setSomething(comboBox.getSelectedItem().toString());
				l.setIndice(INDEX+"");
				INDEX++;
				XMLizer.marshallLibrary(l);
				try
				{
					VG.sendFile(VG.PORT, "src/Library.xml", VG.HOST);
				}
				catch (IOException e2)
				{
					e2.printStackTrace();
				}
				try
				{
					Thread.sleep(500);
				}
				catch (InterruptedException e1)
				{
					e1.printStackTrace();
				}
				try
				{
					VG.recieveFile();
					
					songs = XMLizer.getXML_lib("recieved", "Song");
					songs.mostrarln();
					setRows();
					
					
				}catch (IOException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SAXException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParserConfigurationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}		
				
			}
		});
		comboBox.addItem("Title");
		comboBox.addItem("Album");		
		comboBox.addItem("Artist");
		
		
		
		buttonRecharge = new JButton("");
		buttonRecharge.setIcon(new ImageIcon(load));
		buttonRecharge.setPressedIcon(new ImageIcon(load_pq));
		buttonRecharge.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				

				Library l = new Library();
				//l.setSomething(comboBox.getSelectedItem().toString());
				l.setIndice(INDEX+"");
				INDEX++;
				XMLizer.marshallLibrary(l);
				try
				{
					VG.sendFile(VG.PORT, "src/Library.xml", VG.HOST);
				}
				catch (IOException e2)
				{
					e2.printStackTrace();
				}
				try
				{
					Thread.sleep(500);
				}
				catch (InterruptedException e1)
				{
					e1.printStackTrace();
				}
				try
				{
					VG.recieveFile();
					
					Lista_Simple<Song> more = XMLizer.getXML_lib("recieved", "Song");
					more.mostrarln();
					addRows(more);

					
					
				}catch (IOException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SAXException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParserConfigurationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}		

				
				
			}
		});
		buttonRecharge.setBackground(Color.DARK_GRAY);
		

		
		
		
		
		buttonSend = new JButton("");
		buttonSend.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JFileChooser jf = new JFileChooser();
				jf.showOpenDialog(buttonSend);
				File file = jf.getSelectedFile();
				if(file != null)
				{
					System.out.println(file.getAbsolutePath());
					VG.filePath = file.getAbsolutePath();
					Metadata m = new Metadata();
					m.show();
				}

			}
		});
		buttonSend.setBackground(Color.DARK_GRAY);
		buttonSend.setIcon(new ImageIcon(upload));
		buttonSend.setPressedIcon(new ImageIcon(upload_pq));

		
		
		
		
		
		
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
						.addComponent(table, GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(buttonSend, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(buttonRecharge, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 429, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(buttonRecharge, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonSend, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
		
		
		
		
		
		
		
		
		
		
		
		
		
		contentPane.add(EMPC, BorderLayout.PAGE_END);

		

		

		
		
		

		
		
		
		
		
	}
	
	
	
	
	
	
	
	public JLabel getLblCurrentTime() {
		return lblCurrentTime;
	}
	public JLabel getLblTotalTime() {
		return lblTotalTime;
	}
	public JButton getBtnAtras() {
		return btnAtras;
	}
	public JButton getBtnPausar() {
		return btnPausar;
	}
	public JButton getButtonShare() {
		return buttonShare;
	}
	public JButton getButtonRecharge() {
		return buttonRecharge;
	}
	public JButton getButtonSend() {
		return buttonSend;
	}

	public void setRows()
	{
		int x = model.getRowCount();
		for(int i=0; i < x; i++)
		{
			model.removeRow(0);
		}
		table.updateUI();
		
		for(int i=0; i < songs.getCantidad_de_nodos(); i++)
		{
			Song s = songs.get_dato_por_indice(i);
			
			// Append a row 
			model.addRow(new Object[]{s.getTitle(), s.getArtist(), s.getAlbum(), s.getGenre()[0], s.getRaiting()});
		}
	}
	public void addRows(Lista_Simple<Song> more)
	{
		
		for(int i=0; i < more.getCantidad_de_nodos(); i++)
		{
			Song s = more.get_dato_por_indice(i); 
			model.addRow(new Object[]{s.getTitle(), s.getArtist(), s.getAlbum(), s.getGenre()[0], s.getRaiting()});
		}
		table.updateUI();
	}
	public JButton getButtonBorrar() {
		return buttonBorrar;
	}
}
