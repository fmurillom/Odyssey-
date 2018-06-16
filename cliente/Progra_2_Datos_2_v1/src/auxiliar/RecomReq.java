package auxiliar;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "RecomReq")
public class RecomReq {
	
	String usrName;

	
	@XmlElement(name = "UserName")
	public String getUsrName() {
		return usrName;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}
	
	

}
