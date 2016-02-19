package Sql;


import Entity.Genre;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GenreList {
	static Connection connection;
	static Statement stm;
	static ResultSet result;
	private ArrayList<Genre> ganreList = new ArrayList<Genre>();

	public ArrayList<Genre> getGanres() {

		try {
			connection = Connect();
			result = stm.executeQuery("select * from ganre order by name");
			while (result.next()) {
				Genre ganre = new Genre();
				ganre.setName(result.getString("name"));
				ganre.setIdGenre(result.getInt("id_ganre"));
				ganreList.add(ganre);
			}
		} catch (SQLException ex) {
			Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null,
					ex);
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
				Logger.getLogger(BookList.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}
		return ganreList;
	}

	public ArrayList<Genre> getGanreList() {
		if (!ganreList.isEmpty()) {
			return ganreList;
		} else {
			return getGanres();
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
