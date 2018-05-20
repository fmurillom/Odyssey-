package admin;

import javax.xml.bind.annotation.*;


//@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Song")
//@XmlRootElement
//@XmlType(name = "Song")
public class Song
{
	//@XmlAttribute(name = "Data Title")
	private String title;
	
	private String artist;
	
	//@XmlAttribute
	private String album;
	
	
	//@XmlAttribute
	private String[] genre;
	
	//@XmlAttribute
	private String raiting;
	
	//@XmlAttribute
	private String path;
	
	@XmlElement(name = "Title")
	public String getTitle(){return title;}
	public void setTitle(String title){this.title = title;}

	@XmlElement(name = "Artist")
	public String getArtist(){return artist;}
	public void setArtist(String artist){this.artist = artist;}
	
	@XmlElement(name = "Album")
	public String getAlbum(){return album;}
	public void setAlbum(String album){this.album = album;}

	@XmlElement(name = "Genre")
	public String[] getGenre(){return genre;}
	public void setGenre(String[] genre){this.genre = genre;}
	
	@XmlElement(name = "Rating")
	public String getRaiting(){return raiting;}
	public void setRaiting(String raiting){this.raiting = raiting;}
	
	@XmlElement(name = "Path")
	public String getPath(){return path;}
	public void setPath(String path){this.path = path;}
	
	@Override
	public String toString()
	{
		return "Song {title=" + title + ", artist=" + artist +", album=" + album + ", genre=" + genre + ", raiting=" + raiting + ", path="+ path + "}";
	}
	
	public Song(String title, String artist, String album, String[] genre, String raiting, String path)
	{
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.genre = genre;
		this.raiting = raiting;
		this.path = path;
	}
	public Song()
	{
		super();
	}

	
}
