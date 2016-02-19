package Sql;


import Controlle.DataHelper;
import java.sql.SQLException;
import java.util.ArrayList;

import ENUM.SearchType;
import Entity.Book;
import java.util.List;

public class BookList {
	private ArrayList<Book> bookList = new ArrayList<Book>();
        
        public List<Book> getBooksByLetter(Character letter) throws SQLException {
		return DataHelper.getInstance().getBooksByLetter(letter);
	}

	public ArrayList<Book> getBooksBySearch(String search_string,
			SearchType type) throws SQLException {
		if (type == SearchType.AUTHOR) {
		bookList=(ArrayList<Book>) DataHelper.getInstance().getBooksByAuthor(search_string);
		} else if (type == SearchType.TITLE) {
		bookList=(ArrayList<Book>) DataHelper.getInstance().getBooksBySearch(search_string);
		}
		return bookList;
	}

	public List<Book> getBooksByGanre(int id_ganre) throws SQLException {
		return DataHelper.getInstance().getBooksByGenre(id_ganre);
	}

	public List<Book> getAuthorByName(String name) throws SQLException {
		return DataHelper.getInstance().getBooksByAuthor(name);
	}

	public List<Book> getAllBooks() throws SQLException {
		return DataHelper.getInstance().getAllBooks();
	}
       

	public List<Book> getBookList() throws SQLException {
		if (!bookList.isEmpty()) {
			return bookList;
		} else {
			return getAllBooks();
		}
	}
}
