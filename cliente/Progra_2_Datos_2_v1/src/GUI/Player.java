package GUI;

import java.awt.BorderLayout;
import java.awt.Button;
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
import auxiliar.Edit;
import auxiliar.Sender;
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
	
	Song delSong;

	String estrella_negra		= "../Progra_2_Datos_2_v1/resources/20-20-30c0b39ab90fe047c67adaef12538b6c-star.png";
	String estrella_blanca		= "../Progra_2_Datos_2_v1/resources/20-20-262b0c87b6266d7ecc05b679585e7b16.png";
	String estrella_amarilla	= "../Progra_2_Datos_2_v1/resources/20-20-12fd97039b0b75db54aa7f64e84251d4.png";
	String pausa 				= "../Progra_2_Datos_2_v1/resources/24-24-7f94cbb88c4da5c5d4660a475d0d33b6.png";
	String atras 				= "../Progra_2_Datos_2_v1/resources/24-24-f9bfcd176faf105f9604ef3f7c99e557-back.png";
	String pausa_pq 			= "../Progra_2_Datos_2_v1/resources/20-20-7f94cbb88c4da5c5d4660a475d0d33b6.png";
	String share 				= "../Progra_2_Datos_2_v1/resources/share.png";
	String share_pq 			= "../Progra_2_Datos_2_v1/resources/share_pq.png";
	String load 				= "../Progra_2_Datos_2_v1/resources/load.png";
	String load_pq 				= "../Progra_2_Datos_2_v1/resources/load_pq.png";
	String upload 				= "../Progra_2_Datos_2_v1/resources/upload.png";
	String upload_pq 			= "../Progra_2_Datos_2_v1/resources/upload_pq.png";
	String trash_can			= "../Progra_2_Datos_2_v1/resources/trashcan-512.png";
	String searchM				= "../Progra_2_Datos_2_v1/resources/searchM.png";
	
	Lista_Simple<Song> songs = new Lista_Simple<>();
	DefaultTableModel model = new DefaultTableModel();
	
	int INDEX = 1;
	private JTable table;
	private JButton buttonRecharge;
	private JButton buttonSend;
	private JButton buttonDelete;
	private JButton buttonRecomend;
	private JButton buttonSeeRec;
	private JButton buttonEdit;
	private JButton buttonSearch;

	
	
	
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
		setBounds(100, 100, 1000, 337);
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
		
		//btnAtras.setBorder(null);
		
		
		
	




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
						delSong = song;
					}
				}
								
				System.out.println("Path: " + path);
				Sender send = new Sender(path);
				send.setVisible(true);
				//EMPC.getMediaPlayer().playMedia(path);
				
				
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
				INDEX = 1;
				l.setSomething(comboBox.getSelectedItem().toString());
				l.setIndice(INDEX+"");
				INDEX++;
				XMLizer.marshallLibrary(l);
				try
				{
					Thread.sleep(1000);
					VG.sendFile(VG.PORT, "../Library.xml", VG.HOST);
				}
				catch (IOException e2)
				{
					e2.printStackTrace();
				} catch (InterruptedException e1) {
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
					VG.sendFile(VG.PORT, "../Library.xml", VG.HOST);
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
					
					for(int i = 0; i < more.getCantidad_de_nodos(); i++) {
						songs.insertar_al_final(more.get_dato_por_indice(i));
					}
					

					
					
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
		
		this.buttonDelete = new JButton("");
		buttonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete del = new Delete(delSong.getTitle(), delSong.getAlbum(), delSong.getArtist());
				XMLizer.marshallDelete(del);
				try {
					Thread.sleep(1000);
					VG.sendFile(VG.PORT, "../Del.xml", VG.HOST);
					VG.recieveFile();
				} catch (InterruptedException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		buttonDelete.setBackground(Color.DARK_GRAY);
		buttonDelete.setIcon(new ImageIcon(trash_can));
		
		buttonRecomend = new JButton("");
		buttonRecomend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Song selected;
				
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
						delSong = song;
					}
				}
				
				RecommendWindow rec = new RecommendWindow(delSong);
				
				rec.show();
				
				
			}
		});
		buttonRecomend.setBackground(Color.DARK_GRAY);
		buttonRecomend.setIcon(new ImageIcon(share));
		buttonRecomend.setPressedIcon(new ImageIcon(share_pq));
		
		buttonSeeRec = new JButton("");
		buttonSeeRec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SeeRecomend rec = new SeeRecomend();
				
				rec.show();
			}
		});
		buttonSeeRec.setBackground(Color.DARK_GRAY);
		buttonSeeRec.setIcon(new ImageIcon(share));
		buttonSeeRec.setPressedIcon(new ImageIcon(share_pq));
		
		buttonEdit = new JButton("");
		buttonEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
						delSong = song;
					}
				}
				
				Edit edit = new Edit();
				edit.setArtist(delSong.getArtist());
				edit.setTitle(delSong.getTitle());
				
				EditaData editW = new EditaData(edit);
				
				editW.show();
			}
		});
		buttonEdit.setBackground(Color.DARK_GRAY);
		buttonEdit.setIcon(new ImageIcon(share));
		buttonEdit.setPressedIcon(new ImageIcon(share_pq));
		
		buttonSearch = new JButton("");
		buttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchWindow search = new SearchWindow();
				search.show();
			}
		});
		buttonSearch.setBackground(Color.DARK_GRAY);
		buttonSearch.setIcon(new ImageIcon(searchM));
		
		
		
		

		
		
		
		
		
		
		
		
		
		
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
								.addComponent(buttonRecharge, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(buttonDelete, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(buttonRecomend, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(buttonSeeRec, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(buttonEdit, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(buttonSearch, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))							
						))
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
						.addComponent(buttonSend, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonDelete, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonRecomend, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonSeeRec, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonEdit, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(buttonSearch, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
			)
		);
		contentPane.setLayout(gl_contentPane);
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		

		

		
		
		

		
		
		
		
		
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
}
