package test;


import java.awt.geom.GeneralPath;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import admin.Library;
import admin.Song;
import admin.User;
import auxiliar.VG;
import auxiliar.XMLizer;
import estructuras.Lista_Simple;


public class xml
{

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, InterruptedException
	{


//		String[] _genres = {"Black","Rock","Shooter"};
//		Song song = new Song("title", "album", _genres, "raiting", "path");
//		XMLizer.marshallSong(song);
//		Song song2 = XMLizer.unMarshallSong("title");
//		System.out.println(song2.toString());


//		String[] _genres = {"Black","Rock","Shooter"};
//		String[] friends = {"Gold","Saw","Master"};
//		User u = new User("Loop", "207680955", "Ale", "21", _genres, friends);
//		XMLizer.marshallUser(u);
//		User u2 = XMLizer.unMarshallUser("Loop");
//		System.out.println(u2.toString());


//		NodeList n = XMLizer.getXML_value("Ale", "Password");
//		String password = n.item(0).getTextContent();
//		System.out.println(password);

		
//		Library l = new Library();
//		XMLizer.marshallLibrary(l);
//		VG VG = new VG();
//		VG.sendFile(VG.PORT, "src/Library.xml", VG.HOST);
//		Thread.sleep(500);
//		VG.recieveFile();		
//		Lista_Simple<Song> songs = XMLizer.getXML_lib("recieved", "Song");
//		songs.mostrarln();
		

		
	}

}

