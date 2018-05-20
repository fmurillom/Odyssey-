package auxiliar;


import java.io.File;
import java.io.IOException;

import javax.security.auth.Subject;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import admin.Library;
import admin.Song;
import admin.User;
import estructuras.Lista_Simple;


public class XMLizer
{
	public static void marshallSong(Song song)
	{
		try
		{
			JAXBContext jc = JAXBContext.newInstance(Song.class);
			Marshaller ms = jc.createMarshaller();
			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ms.marshal(song, System.out);
			ms.marshal(song,  new File("src\\"+"Song"+".xml"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void marshallLibrary(Library library)
	{
		try
		{
			JAXBContext jc = JAXBContext.newInstance(Library.class);
			Marshaller ms = jc.createMarshaller();
			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ms.marshal(library, System.out);
			ms.marshal(library,  new File("src\\"+"Library"+".xml"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void marshallRecomendation(Recomendacion r)
	{
		try
		{
			JAXBContext jc = JAXBContext.newInstance(Recomendacion.class);
			Marshaller ms = jc.createMarshaller();
			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ms.marshal(r, System.out);
			ms.marshal(r,  new File("src\\"+"Rec"+".xml"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void marshallDelete(Delete d)
	{
		try
		{
			JAXBContext jc = JAXBContext.newInstance(Delete.class);
			Marshaller ms = jc.createMarshaller();
			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ms.marshal(d, System.out);
			ms.marshal(d,  new File("src\\"+"Del"+".xml"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void marshallUser(User user)
	{
		try
		{
			JAXBContext jc = JAXBContext.newInstance(User.class);
			Marshaller ms = jc.createMarshaller();
			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ms.marshal(user, System.out);
			ms.marshal(user,  new File("src\\"+"coms"+".xml"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static Song unMarshallSong(String songTitle)
	{
		try
		{
			JAXBContext jc = JAXBContext.newInstance(Song.class);
			Unmarshaller unm = jc.createUnmarshaller();
			Song song = (Song)unm.unmarshal(new File("src\\"+songTitle+".xml"));
			//System.out.println(song.toString());
			return song;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	public static void marshallLogInData(LogInData log)
	{
		try
		{
			JAXBContext jc = JAXBContext.newInstance(LogInData.class);
			Marshaller ms = jc.createMarshaller();
			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ms.marshal(log, System.out);
			ms.marshal(log,  new File("src\\"+"LogInData"+".xml"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static Song unMarshallLogInData(String songTitle)
	{
		try
		{
			JAXBContext jc = JAXBContext.newInstance(Song.class);
			Unmarshaller unm = jc.createUnmarshaller();
			Song song = (Song)unm.unmarshal(new File("src\\"+songTitle+".xml"));
			//System.out.println(song.toString());
			return song;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}	
	public static User unMarshallUser(String userName)
	{
		try
		{
			JAXBContext jc = JAXBContext.newInstance(User.class);
			Unmarshaller unm = jc.createUnmarshaller();
			User user = (User)unm.unmarshal(new File("src\\"+userName+".xml"));
			//System.out.println(user.toString());
			return user;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	public void nya() throws SAXException, IOException, ParserConfigurationException
	{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
	    Document doc = db.parse(new File("src\\" + "title" + ".xml"));
	    
	    doc.getDocumentElement().normalize();
	    //System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());
	    NodeList nList = doc.getChildNodes();
	    //System.out.println("--------------------------------");
	    
	    for(int i=0; i < nList.getLength(); i++)
	    {
			Node nNode = nList.item(i);
			//System.out.println("\nCurrent Element: <" + nNode.getNodeName()+">");
			
			if(nNode.getNodeType() == Node.ELEMENT_NODE)
			{
				Element eElement = (Element)nNode;
				
				String title = eElement.getElementsByTagName("Title").item(0).getTextContent();
				String album = eElement.getElementsByTagName("Album").item(0).getTextContent();
				//
				NodeList node_list = eElement.getElementsByTagName("Genre");
				String[] genres = new String[node_list.getLength()];
				for(int j=0; j < node_list.getLength(); j++)genres[j] = node_list.item(j).getTextContent();
				//
				String raiting = eElement.getElementsByTagName("Raiting").item(0).getTextContent();	
				String path = eElement.getElementsByTagName("Path").item(0).getTextContent();
				
				
				System.out.println("Title: " + title);
				System.out.println("Album: " + album);
				System.out.print("Genres: ");for(int j=0; j < genres.length; j++)System.out.print(genres[j] + " ");System.out.println();
				System.out.println("Raiting: " + raiting);
				System.out.println("Path: " + path);
				
			}
				    	
	    }
	    //XML xml = new XML();
	    //xml.changeTagName(doc, "title", "title", "AAA");


	}

	public static NodeList getXML_value(String name, String tag) throws SAXException, IOException, ParserConfigurationException
	{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
	    Document doc = db.parse(new File("src\\" + name + ".xml"));
	    doc.getDocumentElement().normalize();
	    NodeList nList = doc.getChildNodes();
	    System.out.println("AAA");
	    for(int i=0; i < nList.getLength(); i++)
	    {
			Node nNode = nList.item(i);
			System.out.println(nNode.getNodeName());
			if(nNode.getNodeType() == Node.ELEMENT_NODE)
			{
				Element eElement = (Element)nNode;
				return eElement.getElementsByTagName(tag);
			}
	    }
		return null;
	}

	public static Lista_Simple<Song> getXML_lib(String name, String tag) throws SAXException, IOException, ParserConfigurationException
	{
		Lista_Simple<Song> songs = new Lista_Simple<>();
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
	    Document doc = db.parse(new File("src\\" + name + ".xml"));
	    doc.getDocumentElement().normalize();
	    
	    
	    NodeList nList = doc.getChildNodes().item(0).getChildNodes();
	    for(int i=0; i < nList.getLength(); i++)
	    {
			Node nNode = nList.item(i);
			if(nNode.getNodeName().equals(tag))
			{
				Song song = new Song();
				Element eElement = (Element)nNode;
				String Title = eElement.getElementsByTagName("Title").item(0).getTextContent();//System.out.println(Title);
				String Album = eElement.getElementsByTagName("Album").item(0).getTextContent();//System.out.println(Album);
				String Artist = eElement.getElementsByTagName("Artist").item(0).getTextContent();//System.out.println(Artist);
				String Genre = eElement.getElementsByTagName("Genre").item(0).getTextContent();//System.out.println(Genre);
				String Rating = eElement.getElementsByTagName("Rating").item(0).getTextContent();//System.out.println(Rating);
				String Path = eElement.getElementsByTagName("Path").item(0).getTextContent();//System.out.println(Path);
				song.setTitle(Title);
				song.setAlbum(Album);
				song.setArtist(Artist);
				String[] genres = {Genre};song.setGenre(genres);
				song.setRaiting(Rating);
				song.setPath(Path);
				songs.insertar_al_final(song);
			}
		}
	    return songs;
	}
	
	
}

