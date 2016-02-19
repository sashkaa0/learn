
package beans;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@SessionScoped
    public class User implements Serializable{
    private String username;
    private String password;
    
    public User(){
        
    }
   
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username=username;
    }
     public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }
    
    public String login(){
        try {
         // ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).login(username,password);
          FacesContext context = FacesContext.getCurrentInstance();  
           HttpServletRequest request = (HttpServletRequest) context  
                                              .getExternalContext().getRequest();  
             
           
                request.login(username, password);  
           return "books";
        } catch (ServletException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
           return "books";
        }
        
    }
    
      public String logout(){
          String result="/index.xhtml?faces-redirect=true";
          FacesContext context=FacesContext.getCurrentInstance();
          HttpServletRequest request=(HttpServletRequest) context.getExternalContext().getRequest();
              try {
                  request.logout();
              } catch (ServletException ex) {
                  Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
              }
              FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
              return result;
      }
}
//rendered="#{request.isUserInRole('ADMIN')}"