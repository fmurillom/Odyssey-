/**
 * 
 */
package admin;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author fmurillom
 *
 */

@XmlRootElement(name = "UsrRequest")
public class UsrRqst {
	String usrName;
	
	public UsrRqst() {
		usrName = "";
	}
	
	public UsrRqst(String usr) {
		this.usrName = usr;
	}
	
	@XmlElement(name = "UserName")
    public String getUsrName(){return usrName;}
    public void setUsrName(String usrName){this.usrName = usrName;}

}
