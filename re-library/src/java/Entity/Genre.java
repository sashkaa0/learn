package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="genre")
public class Genre  implements java.io.Serializable {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name = "id_genre")
     private int idGenre;
     
     @Column(name="name")
     private String name;
     
     /* @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
     @JoinColumn(name = "id_book", referencedColumnName = "id_book")*/
     private Book books;

    public Genre() {
    }

	
    public Genre(int idGenre) {
        this.idGenre = idGenre;
    }
    public Genre(int idGenre, String name, Book books) {
       this.idGenre = idGenre;
       this.name = name;
       this.books = books;
    }
   
    public int getIdGenre() {
        return this.idGenre;
    }
    
    public void setIdGenre(int idGenre) {
        this.idGenre = idGenre;
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
    public void setId_genre(long aLong) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

public String toString(){
    return getName();
}



}


