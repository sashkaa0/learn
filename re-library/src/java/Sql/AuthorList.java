package Sql;


import Entity.Author;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AuthorList {
	static Connection connection;
	static Statement stm;
	static ResultSet result;
	private ArrayList<Author> authorList = new ArrayList<Author>();

	public ArrayList<Author> getAuthors() {

		try {
			connection = Connect();
			result = stm.executeQuery("select * from author order by fio");
			while (result.next()) {
				Author author = new Author();
				author.setIdAuthor((int) result.getLong("id_author"));
				author.setFio(result.getString("fio"));
				author.setBirthday(result.getDate("birthday"));

				authorList.add(author);
				System.out.println("Example AuthorList Select   "
						+ result.getLong("id_author") + "		"
						+ result.getString("fio") + "		"
						+ result.getDate("birthday"));

			}
		} catch (SQLException ex) {
			Logger.getLogger(AuthorList.class.getName()).log(Level.SEVERE,
					null, ex);
		} finally {
			try {
				if (stm != null) {
					stm.close();
				}
				if (result != null) {
					result.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException ex) {
				Logger.getLogger(AuthorList.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
		return authorList;
	}

	public ArrayList<Author> getAuthorList() {
		if (!authorList.isEmpty()) {
			return authorList;
		} else {
			return getAuthors();
		}
	}

	static Connection Connect() {
		try {
			Class.forName("com.mysql.jdbs.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		Properties connInfo = new Properties();
		connInfo.put("user", "root");
		connInfo.put("password", "root");
		connInfo.put("useUnicode", "true");
		connInfo.put("characterEncoding", "UTF8");

		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library", connInfo);
			stm = (Statement) connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;

	}
}
