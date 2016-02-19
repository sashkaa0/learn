package Entity;
// Generated 3 лют. 2016 15:34:39 by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "book")
public class Book  implements java.io.Serializable {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_book")
     private Integer idBook;
     
     @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_author", referencedColumnName = "id_author")
     private Author author;
     
     @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_genre", referencedColumnName = "id_genre")
     private Genre genre;
     
     @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_publisher", referencedColumnName = "id_publisher")
     private Publisher publisher;
     
     @Column(name = "namebook")
     private String namebook;
     
     @Column(name = "content")
     private String content;
     
     @Column(name = "pagecount")
     private Integer pagecount;
     
     @Column(name = "isbn")
     private String isbn;
     
     @Column(name = "publishDate")
     private Date publishDate;
     
     @Column(name = "image")
     private String image;

    public Book() {
    }

    public Book(Author author, Genre genre, Publisher publisher, String namebook, String content, Integer pagecount, String isbn, Date publishDate, String image) {
       this.author = author;
       this.genre = genre;
       this.publisher = publisher;
       this.namebook = namebook;
       this.content = content;
       this.pagecount = pagecount;
       this.isbn = isbn;
       this.publishDate = publishDate;
       this.image = image;
    }
   
    public Integer getIdBook() {
        return this.idBook;
    }
    
    public void setIdBook(Integer idBook) {
        this.idBook = idBook;
    }
    public Author getAuthor() {
        return this.author;
    }
    
    public void setAuthor(Author author) {
        this.author = author;
    }
    public Genre getGenre() {
        return this.genre;
    }
    
    public void setGenre(Genre genre) {
        this.genre = genre;
    }
    public Publisher getPublisher() {
        return this.publisher;
    }
    
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
    public String getNamebook() {
        return this.namebook;
    }
    
    public void setNamebook(String namebook) {
        this.namebook = namebook;
    }
    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    public Integer getPagecount() {
        return this.pagecount;
    }
    
    public void setPagecount(Integer pagecount) {
        this.pagecount = pagecount;
    }
    public String getIsbn() {
        return this.isbn;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public Date getPublishDate() {
        return this.publishDate;
    }
    
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
    public String getImage() {
        return this.image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }

public String toString(){
    return namebook+"       "+author.getFio();
}


}


