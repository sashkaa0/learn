/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlle;

import Entity.Book;
import java.util.Iterator;

public class test {
    public static void main(String[]args){
        Pager pager=new Pager();
        pager.setSelectedPageNumber(2);
        for (Iterator it = DataHelper.getInstance().getAllBooks(pager).iterator(); it.hasNext();) {
            Book book = (Book)it.next();
            System.out.println(book.getNamebook());
        }
    }
}
