import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server extends Thread {
	public static DataInputStream dIn;
		private Socket socket;

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(4333);
			System.out.println("server is started");
			while (true) {
				new Server(server.accept());
			}
		} catch (Exception e) {
			System.out.println("Server " + e);
		}
	}

	public Server(Socket socket) {
		this.socket = socket;
		setDaemon(true);
		setPriority(NORM_PRIORITY);
		start();
	}

	public void run() {
		System.out.println("start run");
		while (true) {
			DataInputStream dIn = null;
			try {
				dIn = new DataInputStream(socket.getInputStream());

				int StrahVnesok = ConvertTnt(dIn.readUTF());
				String Type = dIn.readUTF();
				int Year = ConvertTnt(dIn.readUTF());
				int Area = ConvertTnt(dIn.readUTF());
				String TermStart = Convert(dIn.readUTF());
				String TermEnd = Convert(dIn.readUTF());
				String DateContr = Convert(dIn.readUTF());
				int Reward = ConvertTnt(dIn.readUTF());
				String FIB = dIn.readUTF();
				int Numb = ConvertTnt(dIn.readUTF());
				String DateBirthd = Convert(dIn.readUTF());
				String SerPass = dIn.readUTF();
				int NumbPass = ConvertTnt(dIn.readUTF());
				String Address = dIn.readUTF();
				try {
					JDBC.Update(FIB, SerPass, NumbPass, DateBirthd, Address,
							Numb, StrahVnesok, Type, Year, Area, TermStart,
							TermEnd, DateContr, Reward);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			} catch (IOException e) {

				e.printStackTrace();
				try {
					dIn.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	private static String Convert(String a) {
		 Date docDate = null;
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd mm yyyy");
			dateFormat.applyPattern("dd.MM.yyyy");
			
				try {
					docDate = dateFormat.parse(a);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			
			 
			 dateFormat = new SimpleDateFormat("yyyy.MM.dd");
			
			 System.out.println(dateFormat.format( docDate ));
		return dateFormat.format( docDate );
	}

	private static int ConvertTnt(String a) {
		return Integer.parseInt(a);
	}
}
