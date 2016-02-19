/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlle;


import java.util.ArrayList;
import java.util.List;

public class Pager<T> {
    private int totalBookCount=8;
    private final int booksCountOnPage=2;
    private int selectedPageNumber=1;
    private List<T> list;
    
     Pager(int totalBookCount,int selectedPageNumber){
          System.out.println("total   "  +totalBookCount);
}
    Pager(){
         System.out.println("total   "  +totalBookCount);
    }

    public int getFrom() {
        return selectedPageNumber*booksCountOnPage-booksCountOnPage;
    }
   public   int getTo() {
      return booksCountOnPage;
    }
    public List<T> getList(){
    return list;
}
   
   public void setList(List<T> list) {
       this.list=list;
    }
public void setTotalBookCount(long totalBooksCount){
    this.totalBookCount=(int) totalBooksCount;
}
  public int getTotalBooksCount(){
      return totalBookCount;
  }
  
  public void setSelectedPageNumber(int selectedPageNumber){
    this.selectedPageNumber=selectedPageNumber;
}
  public int getSelectedPageNumber(){
      return selectedPageNumber;
  }
  private List<Integer> pageNumbers=new ArrayList<Integer>();
  
    public List<Integer> getPageNumber(){
        System.out.println("getPageNumber______total   "  +totalBookCount);
        int pageCount=0;
        
        if(totalBookCount%booksCountOnPage==0){
            pageCount=booksCountOnPage>0? (int)(totalBookCount/booksCountOnPage):0;
        }else{
            pageCount=booksCountOnPage>0? (int)(totalBookCount/booksCountOnPage)+1:0;
        }
       pageNumbers.clear();
       for(int i=1;i<=pageCount;i++){
            pageNumbers.add(i);
        }
        return pageNumbers;
    } 
}
