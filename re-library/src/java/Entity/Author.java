package Entity;



import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="author")
public class Author  implements java.io.Serializable {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name = "id_author")
     private int idAuthor;
     
     @Column(name = "fio")
     private String fio;
     
     @Column(name = "birthday")
     private Date birthday;
     
     /*@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
     @JoinColumn(name = "id_book", referencedColumnName = "id_book")*/
     private Book books;

    public Author() {
    }

	
    public Author(int idAuthor) {
        this.idAuthor = idAuthor;
    }
    public Author(int idAuthor, String fio, Date birthday, Book books) {
       this.idAuthor = idAuthor;
       this.fio = fio;
       this.birthday = birthday;
       this.books = books;
    }
   
    public int getIdAuthor() {
        return this.idAuthor;
    }
    
    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }
    public String getFio() {
        return this.fio;
    }
    
    public void setFio(String fio) {
        this.fio = fio;
    }
    public Date getBirthday() {
        return this.birthday;
    }
    
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public Book getBooks() {
        return this.books;
    }
    
    public void setBooks(Book books) {
        this.books = books;
    }


public String toString(){
    return getFio();
}


}


