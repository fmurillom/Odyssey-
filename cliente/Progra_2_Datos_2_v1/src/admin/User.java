package admin;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import estructuras.Lista_Simple;

//<?xml version="1.0" ?>
//<Register>
//    <UserName>chizco06</UserName>
//    <Password>holis</Password>
//    <Name>Francisco Murillo Morgan</Name>
//    <Age>21</Age>
//    <Genre>pop</Genre>
//    <Genre>rock</Genre>
//    <Friend>loop</Friend>
//    <Friend>priramro</Friend>
//</Register>

@XmlRootElement(name = "Register")
/**
 * CLase utilizada para almacenar los datos de los usuarios
 */
public class User
{	
	private String usrName;
	private String password;
	private String name;
	private String age;
	private Lista_Simple<String> favGenres;
	private Lista_Simple<String> friendList;

	
    public User()
    {
        this.usrName =	"";
        this.password = "";
        this.name =		"";
        this.age =		"";
        this.favGenres =	new Lista_Simple<>();
        this.friendList =	new Lista_Simple<>();
    }

    
    public User(String usrName, String password, String name, String age, String[] favGenres, String[] friendList)
    {
        this.usrName = usrName;
        this.password = password;
        this.name = name;
        this.age = age;
        this.favGenres = toList(favGenres);
        this.friendList = toList(friendList);    	
    }

    
    @XmlElement(name = "UserName")
    public String getUsrName(){return usrName;}
    public void setUsrName(String usrName){this.usrName = usrName;}

    
    @XmlElement(name = "Password")
    public String getpassword(){return password;}
    public void setPassword(String password){this.password = password;}

    
    @XmlElement(name = "Name")
    public String getName(){return name;}
    void setName(String name){this.name = name;}

    
    @XmlElement(name = "Age")
    String getAge(){return age;}
    void setAge(String age){this.age = age;}


    @XmlElement(name = "Genre")
    public String[] getFavGenres(){return toArray(favGenres);}
    public void setFavGenres(Lista_Simple<String> genres){this.favGenres = genres;}
    void addFavGenre(String genre){this.favGenres.insertar_al_final(genre);}

    
    @XmlElement(name = "Friend")
    public String[] getFriendList(){return toArray(friendList);}
    public void setFriendList(Lista_Simple<String> friends){this.friendList = friends;}
    void addFriend(String usr){this.friendList.insertar_al_final(usr);}

    
	@Override
	public String toString(){return "User {usrName=" + usrName + ", password=" + password + ", name=" + name + ", age=" + age + ", favGenres=" + favGenres + ", friendList=" + friendList + "}";}

       
    private String[] toArray(Lista_Simple<String> lista)
    {
    	String[] array = new String[lista.getCantidad_de_nodos()];
    	for(int i=0; i <lista.getCantidad_de_nodos(); i++)
    	{
    		array[i] = lista.get_dato_por_indice(i);
    	}
    	return array;
    }

    private Lista_Simple<String> toList(String[] array)
    {
    	Lista_Simple<String> lista = new Lista_Simple<>();
    	for(int i=0; i <array.length; i++)
    	{
    		lista.insertar_al_final(array[i]);
    	}
    	return lista;
    }

}

