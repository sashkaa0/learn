package Controlle;


import Entity.Author;
import Entity.Book;
import Entity.Genre;
import Entity.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class DataHelper {
        private static  SessionFactory sessionFactory=null;
        private static DataHelper dataHelper;
        private static Session session;
        private DetachedCriteria currentCriteria;
        private Pager currentPager;
        public ArrayList<Book>list=new ArrayList<Book>();
        private DataHelper(){
            
                        sessionFactory      =   HibernateUtil.getSessionFactory();
                        session             =   sessionFactory.openSession();
                        
                        session.beginTransaction();
            
        }
        public static DataHelper getInstance(){
            
            return dataHelper==null?new DataHelper():dataHelper;

        }
        private Session getSession(){
            
                        session             =   sessionFactory.openSession();
                                    
                        return session;

        }
        
        public byte[] getContent(int id){
            
                        return (byte[]) getFieldValue("content",id);
        }
         public List<Genre> getAllGenres(){
             
                        return getSession().createCriteria(Genre.class).list();
        }
        public List<Author> getAllAuthors(){
            
                        return getSession().createCriteria(Author.class).list();
            
        }
        public String getImage(int id){
            
                        return  (String) getFieldValue("image",id);
        }
        private List<Book> getBookList(String field, String value){
            
                        return getSession().createCriteria(Book.class).add(Restrictions.ilike(field, value,MatchMode.START)).list();
            
        }
        private Object getFieldValue(String field, int id){
            
                        return getSession().createCriteria(Book.class).setProjection(Projections.property(field)).add(Restrictions.eq("id", id)).uniqueResult();
            
        }
       
        public List getBooksBySearch(String name, Pager pager){
                       
                        currentPager            =pager;
                        Criteria criteria        =session.createCriteria(Book.class,"book").add(Restrictions.ilike("book.namebook", name,MatchMode.ANYWHERE));
                        
                        criteria.setResultTransformer(criteria.DISTINCT_ROOT_ENTITY);
                        
                         long total             = (long) criteria.setProjection(Projections.rowCount()).uniqueResult();
                         
                        currentPager.setTotalBookCount(total);
                       
                        currentCriteria          =DetachedCriteria.forClass(Book.class,"book")
                                                .add(Restrictions.ilike("book.namebook", name,MatchMode.ANYWHERE))
                                                .setResultTransformer(criteria.DISTINCT_ROOT_ENTITY);
                       
                        return runCurrentCriteria();
        }
       
         public List getBooksByLetter(Character letter, Pager pager){
                      
                        currentPager            =   pager;
                       Criteria criteria        =   session.createCriteria(Book.class,"book")
                                                    .add(Restrictions.ilike("book.namebook", letter.toString(),MatchMode.START));
                       
                       criteria.setResultTransformer(criteria.DISTINCT_ROOT_ENTITY);
                       
                       long total               = (long) criteria.setProjection(Projections.rowCount()).uniqueResult();
                       
                       currentPager.setTotalBookCount(total);
                       
                       currentCriteria          =DetachedCriteria.forClass(Book.class,"book")
                                                .add(Restrictions.ilike("book.namebook", letter.toString(),MatchMode.START))
                                                .setResultTransformer(criteria.DISTINCT_ROOT_ENTITY);
                      
                                  return runCurrentCriteria();
        }
          public List getAllBooks(Pager pager){
                     
                        currentPager        =pager;
                        
                       Criteria criteria    =session.createCriteria(Book.class);
                       long total           = (long) criteria.setProjection(Projections.rowCount()).uniqueResult();
                       currentPager.setTotalBookCount(total);
                       currentCriteria  =   DetachedCriteria.forClass(Book.class);
                       
                                   return runCurrentCriteria();
                       
        }
         
       
        public List<Book> getBooksByGenre(int idgenre,Pager pager){
            
                        currentPager             =   pager;
              
                        Criteria criteria        =   session.createCriteria(Book.class).add(Restrictions.eq("genre.idGenre",idgenre));
                        long total               =   (long) criteria.setProjection(Projections.rowCount()).uniqueResult();
                       
                        currentPager.setTotalBookCount(total);
                                
                        currentCriteria =   DetachedCriteria.forClass(Book.class).add(Restrictions.eq("genre.idGenre",idgenre));
                        
                        return runCurrentCriteria();
        }
        
        public List<Book> getBooksById(int id_book,Pager pager){
                        currentPager    =   pager;
                Criteria criteria       =   session.createCriteria(Book.class).add(Restrictions.eq("idBook",id_book));
                    long total          =   (long) criteria.setProjection(Projections.rowCount()).uniqueResult();
                                
                        currentPager.setTotalBookCount(total);
                    
                        currentCriteria =   DetachedCriteria.forClass(Book.class).add(Restrictions.eq("idBook",id_book));
             
                            return runCurrentCriteria();
        }
        
        public List<Book> getBooksByAuthor(String fio,Pager pager){
              currentPager              =   pager;
              Criteria criteria         =   session.createCriteria(Book.class,"book")
                                            .createCriteria("book.author","author")
                                            .add(Restrictions.ilike("author.fio", fio,MatchMode.ANYWHERE));
                      
                       criteria.setResultTransformer(criteria.DISTINCT_ROOT_ENTITY);
                       
                       long total       =   (long) criteria.setProjection(Projections.rowCount()).uniqueResult();
                       
                       currentPager.setTotalBookCount(total);
                       
                       currentCriteria  =   DetachedCriteria.forClass(Book.class,"book")
                                            .createCriteria("book.author","author")
                                            .add(Restrictions.ilike("author.fio", fio,MatchMode.ANYWHERE)).setResultTransformer(criteria.DISTINCT_ROOT_ENTITY);
                         
                                return runCurrentCriteria();
        }
        
         public List<Book> getBooksByName(String name,Pager pager){
                        currentPager     =   pager;
                Criteria criteria        =   session.createCriteria(Book.class).add(Restrictions.ilike("namebook", name,MatchMode.START));
                long        total        =   (long) criteria.setProjection(Projections.rowCount()).uniqueResult();
                        
                        currentPager.setTotalBookCount(total);
                        
                        currentCriteria  =   DetachedCriteria.forClass(Book.class).add(Restrictions.ilike("namebook", name,MatchMode.START));
                            
                        return runCurrentCriteria();
        }
    public List runCurrentCriteria() {
                     Criteria criteria  =   currentCriteria.addOrder(Order.asc("namebook")).getExecutableCriteria(getSession());
                     return criteria.setFirstResult(currentPager.getFrom()).setMaxResults(currentPager.getTo()).list();
                }
     
}
