package auxiliar;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "LogIn")
public class LogInData
{
	private String nick;
	private String pass;
	
	
	@XmlElement(name = "UserName")
	public String getNick(){return nick;}
	public void setNick(String nick){this.nick = nick;}

	@XmlElement(name = "Password")
	public String getPass(){return pass;}
	public void setPass(String pass){this.pass = pass;}
	
	
	public LogInData(String nick, String pass)
	{
		this.nick = nick;
		this.pass = pass;
	}
	public LogInData(){super();}
	
	
	
	
}
