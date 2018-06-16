package auxiliar;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "Edit")
public class Edit {
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
		
		private String ntitle;
		
		private String nartist;
		
		//@XmlAttribute
		private String nalbum;
		
		
		//@XmlAttribute
		private String ngenre;
		
		//@XmlAttribute
		private String nraiting;
		
		//@XmlAttribute
		private String npath;
		
		@XmlElement(name = "Title")
		public String getTitle(){return title;}
		public void setTitle(String title){this.title = title;}

		@XmlElement(name = "Artist")
		public String getArtist(){return artist;}
		public void setArtist(String artist){this.artist = artist;}
		
		@XmlElement(name = "nTitle")
		public String getNtitle() {return ntitle;}
		public void setNtitle(String ntitle) {
			this.ntitle = ntitle;
		}
		
		
		@XmlElement(name = "nArtist")
		public String getNartist() {
			return nartist;
		}
		
		
		public void setNartist(String nartist) {
			this.nartist = nartist;
		}
		@XmlElement(name = "nAlbum")
		public String getNalbum() {
			return nalbum;
		}
		
		public void setNalbum(String nalbum) {
			this.nalbum = nalbum;
		}
		@XmlElement(name = "nGenre")
		public String getNgenre() {
			return ngenre;
		}
		public void setNgenre(String genre2) {
			this.ngenre = genre2;
		}
		
		@XmlElement(name = "nRating")
		public String getNraiting() {
			return nraiting;
		}
		public void setNraiting(String nraiting) {
			this.nraiting = nraiting;
		}
		
		
		
		

}
