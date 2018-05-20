package admin;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Library")
/**
 * Clase utilizada para almacenar los elementos de la libreria musical
 */
public class Library
{
	private String something;
	private String indice;
	
	
	public Library()
	{
		this.something = "Title";
		this.indice = "0";
	}
	
	
	@XmlElement(name = "Sort")
	public String getSomething(){return something;}
	public void setSomething(String something){this.something = something;}

	
	@XmlElement(name = "Index")
	public String getIndice(){return indice;}
	public void setIndice(String indice){this.indice = indice;}
	
	

}
