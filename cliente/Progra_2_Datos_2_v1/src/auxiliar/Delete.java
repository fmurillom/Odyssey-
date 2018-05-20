package auxiliar;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Delete")
public class Delete
{
	private String title;
	private String album;
	private String artista;
	
	
	
	
	
	
	
	
	
	public Delete(String title, String album, String artista)
	{
		this.title = title;
		this.album = album;
		this.artista = artista;
	}
	
	public Delete()
	{
		super();
	}

	@XmlElement(name = "Title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@XmlElement(name = "Album")
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	@XmlElement(name = "Artist")
	public String getArtista() {
		return artista;
	}
	public void setArtista(String artista) {
		this.artista = artista;
	}
	
	
}
