/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlle;

import ENUM.SearchType;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;



@ManagedBean
@RequestScoped
public class SearchTypeController {
private Map<String,SearchType>searchList=new HashMap<String,SearchType>();
    public SearchTypeController() {
        
        ResourceBundle bundle=ResourceBundle.getBundle("nls.messages", FacesContext.getCurrentInstance().getViewRoot().getLocale());
        searchList.clear();
        searchList.put(bundle.getString("author_name"),SearchType.AUTHOR);
        searchList.put(bundle.getString("book_name"),SearchType.TITLE);
    }
    
    public  Map<String,SearchType> getSearchList(){
        return searchList;  
    }
    
}
