package Entity;
// Generated 3 лют. 2016 15:34:39 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="publisher")
public class Publisher  implements java.io.Serializable {


     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name = "id_publisher")
     private int idPublisher;
     
     @Column(name = "name")
     private String name;
     
/*   @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
     @JoinColumn(name = "id_book", referencedColumnName = "id_book")*/
     private Book books;

    public Publisher() {
    }

	
    public Publisher(int idPublisher) {
        this.idPublisher = idPublisher;
    }
    public Publisher(int idPublisher, String name, Book books) {
       this.idPublisher = idPublisher;
       this.name = name;
       this.books = books;
    }
   
    public int getIdPublisher() {
        return this.idPublisher;
    }
    
    public void setIdPublisher(int idPublisher) {
        this.idPublisher = idPublisher;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public Book getBooks() {
        return this.books;
    }
    
    public void setBooks(Book books) {
        this.books = books;
    }




}


