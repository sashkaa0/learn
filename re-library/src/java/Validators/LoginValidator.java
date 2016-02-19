
package Validators;

import java.util.ArrayList;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("Validators.LoginValidator")
public class LoginValidator implements Validator{
    
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
       ResourceBundle bundle;
            bundle = ResourceBundle.getBundle("nls.messages",FacesContext.getCurrentInstance().getViewRoot().getLocale());

            
            String newValue=value.toString();
        
        if(newValue.length() <= 3 || (value.toString().trim().length()==0)){
            
                    FacesMessage message=new FacesMessage(bundle.getString("login_length_error"));
                    message.setSeverity(FacesMessage.SEVERITY_ERROR);
                    throw new ValidatorException(message);
                
        }
        else if(getList().contains(newValue)){
            FacesMessage message=new FacesMessage(bundle.getString("login_was_used"));
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
       
    }   
     private static ArrayList<String> getList(){
            ArrayList<String>list=new ArrayList<String>();
            
            list.add("login");
            return list;
        }
}

