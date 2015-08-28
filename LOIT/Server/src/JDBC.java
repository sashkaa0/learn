import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class JDBC {
	static Connection connection;
	static Statement stm;
	static ResultSet result;

	public JDBC(String FIB, String SerNumb, int NumbPass, String DateOfBirthd,
			String Address, int Numb, int StrahVnes, String Type, int Year,
			int Area, String Start, String End, String Contract, int Reward)
			throws SQLException {
		Connect();
		Update(FIB, SerNumb, NumbPass, DateOfBirthd, Address, Numb, StrahVnes,
				Type, Year, Area, Start, End, Contract, Reward);

		/* executeUpdate(); *//* executeQuery */

		// "SELECT *FROM Info WHERE Name ='sad'";
		// "UPDATE Registration " +"SET age = 30 WHERE id in (100, 101)"

		while (result.next()) {
			System.out.println("ID " + result.getString(1) + " "
					+ result.getString(2) + " " + result.getString(3) + " "
					+ result.getString(4));
		}
	}

	public static void Update(String FIB, String serNumb, int numbPass,
			String dateOfBirthd, String address, int numb, int strahVnes,
			String type, int year, int area, String start, String end,
			String contract, int reward) throws SQLException {
		 Connect();
		String sql = "INSERT INTO `Clients`(`Client`, `Serial Number Passport`, `Number Passport`, `Date Of Birthd`, `Address`)"
				+ " VALUES ('"
				+ FIB
				+ "','"
				+ serNumb
				+ "',"
				+ numbPass
				+ ",'"
				+ dateOfBirthd + "','" + address + "')";
		System.out.println(sql);
		stm.executeUpdate(sql);
		sql = "INSERT INTO `Orders`(`ID`, `Client`, `Premium`, `Type Object`, `Year (Object)`, `Area`, `Contract Start`,"
				+ " `Contract End`, `Date Of The Contract`, `Reward`) "
				+

				"VALUES ("
				+ numb
				+ ",'"
				+ FIB
				+ "',"
				+ strahVnes
				+ ",'"
				+ type
				+ "',"
				+ year
				+ ","
				+ area
				+ ",'"
				+ start
				+ "','"
				+ end
				+ "','"
				+ contract + "'," + reward + ")";
		System.out.println(sql);
		stm.executeUpdate(sql);
	}

	private static void Connect() throws SQLException {
		try {
			Class.forName("com.mysql.jdbs.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/forInterview", "root", "root");
		stm = (Statement) connection.createStatement();
		result = stm.getResultSet();

	}

}
