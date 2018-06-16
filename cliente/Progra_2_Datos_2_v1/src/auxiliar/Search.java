package auxiliar;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Search")
public class Search {
	
	private String type;
	private String search;
	
	@XmlElement(name = "Type")
	public String getType() {
		return type;
	}
	public void setType(String string) {
		// TODO Auto-generated method stub
		this.type = string;
		
	}

	@XmlElement(name = "Search")
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}

	
	

}
