
package Controlle;

import ENUM.SearchType;
import Entity.Book;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
@ManagedBean(eager=true)
@SessionScoped
public class SearchController implements Serializable {
    private  SearchType                     searchType;
    private String                          searchString;
    private int                             selectedGanreId;
    private char                            selectedLetter;
    private static Map<String,SearchType>   searchList                   =new HashMap<String,SearchType>();
    private ArrayList<Book>                 currentBookList              =new ArrayList<Book>();
    private ArrayList<Integer>              pageNumbers                  =new ArrayList<Integer>();
    
    public Pager                            pager                        =new Pager();
    private int                             selectedPageNumber  =1;
    
    public SearchController() throws SQLException{
       currentBookList=(ArrayList<Book>) fillBooksAll();
      }
   
    public ArrayList<Integer> getPageNumbers(){
        return pageNumbers;
    }
   
    public int getSelectedGanreId(){
        return selectedGanreId;
    }
    public void setPageNumbers(ArrayList<Integer>pageNumbers){
        this.pageNumbers=pageNumbers;
    }
     public String getSearchString(){
        return searchString;
    }
    
    public  SearchType getSearchType(){
        return searchType;
    }
    
    public Map<String,SearchType>getSearchList(){
        return searchList;
    }
    
     public ArrayList<Book> getCurrentBookList(){
       			return currentBookList;
   }
   public void setCurrentBookList(ArrayList<Book> currentBookList) {
       this.currentBookList=currentBookList;
   }
    public void searchTypeChanged(ValueChangeEvent e){
        searchType=(SearchType) e.getNewValue();
    }
    public void searchStringChanged(ValueChangeEvent e){
        searchString=(String) e.getNewValue();
    }
    public void setSearchString(String searchString){
        this.searchString=searchString;
    }
     public Character[] getLetters( ){
         Character letters[]=new Character [26];
    		letters[0] = 'A';
		letters[1] = 'B';
		letters[2] = 'C';
		letters[3] = 'D';
		letters[4] = 'E';
		letters[5] = 'F';
		letters[6] = 'G';
		letters[7] = 'H';
		letters[8] = 'I';
		letters[9] = 'J';
		letters[10] = 'K';
		letters[11] = 'L';
		letters[12] = 'M';
		letters[13] = 'N';
		letters[14] = 'O';
		letters[15] = 'P';
		letters[16] = 'R';
		letters[17] = 'S';
		letters[18] = 'T';
		letters[19] = 'U';
		letters[20] = 'Q';
		letters[21] = 'V';
		letters[22] = 'W';
		letters[23] = 'X';
		letters[24] = 'Y';
		letters[25] = 'Z';
                return letters;
    }
    
    public void  selectPage() throws SQLException{
            Map<String,String>params=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
            selectedPageNumber=Integer.valueOf(params.get("pageNumber"));
            pager.setSelectedPageNumber(selectedPageNumber);
            
    } 
   
    public List fillBooksAll() throws SQLException{
            
        currentBookList     =   (ArrayList<Book>) DataHelper.getInstance().getAllBooks(pager);
        return                  currentBookList;
}
   
   public List fillBooksBySearch() throws SQLException{
       
        if(searchString.trim().length()==0){
            currentBookList= (ArrayList<Book>) DataHelper.getInstance().getAllBooks(pager);
        }
        else{
        if(searchType==SearchType.TITLE){
        currentBookList= (ArrayList<Book>) DataHelper.getInstance().getBooksByAuthor(searchString,pager);
        }
        else if(searchType==SearchType.AUTHOR||searchType==null){
           currentBookList= (ArrayList<Book>) DataHelper.getInstance().getBooksByAuthor(searchString,pager);
        }
         selectedGanreId=-1;
        
        selectedLetter=' ';
        } 
        selectPage();
         return currentBookList;
   }
   public List fillBooksByGanre() throws SQLException{
       
        Map<String,String>params=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
            selectedGanreId=Integer.valueOf(params.get("id_ganre"));
            
        currentBookList =  (ArrayList<Book>) DataHelper.getInstance().getBooksByGenre(selectedGanreId,pager);
        selectedLetter=' ';
        selectPage();
        return currentBookList;
   }
   public void fillBooksByLetter() throws SQLException{
       
        Map<String,String>params=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
                currentBookList=(ArrayList<Book>) DataHelper.getInstance().getBooksByLetter(params.get("letter").charAt(0),pager);
                selectedGanreId=-1;
                selectPage();
   }
}
