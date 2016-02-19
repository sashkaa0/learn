package Controlle;

import Entity.Genre;

import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(eager=true)
@ApplicationScoped
public class GanreController implements Serializable{
private ArrayList<Genre> ganreList ;
public GanreController(){
    ganreList=(ArrayList<Genre>) DataHelper.getInstance().getAllGenres();
}
public ArrayList<Genre>getGanreList(){
        return ganreList;
    }
   
}
   
    

