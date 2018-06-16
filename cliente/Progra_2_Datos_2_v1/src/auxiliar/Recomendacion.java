package auxiliar;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Recomendation")
public class Recomendacion
{
	private String userName;
	private String songName;
	private String friend;
	private String artist;
	
	public Recomendacion(){}
	public Recomendacion(String x, String y)
	{
		this.userName = x;
		this.songName = y;
	}
	
	
	@XmlElement(name = "UserName")
	public String getUserName(){return userName;}
	public void setUserName(String userName){this.userName = userName;}
	
	@XmlElement(name = "Friend")
	public String getFriend(){return friend;}
	public void setFriend(String userName){this.friend = userName;}
	
	@XmlElement(name = "Recomend")
	public String getSongName(){return songName;}
	public void setSongName(String songName){this.songName = songName;}
	
	@XmlElement(name = "Artist")
	public String getArtist(){return artist;}
	public void setArtist(String userName){this.artist = userName;}
	
	
}
