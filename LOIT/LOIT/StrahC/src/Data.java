import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Data {
	public static Socket socket;
	
	
	public static String StrahVnesok;//
	public static String Type;//
	public static String Year;//
	public static String Area;//
	public static String TermStart;
	public static String TermEnd;
	public static String DateContr;
	public static String Reward;

	public static String FIB;//
	public static String Numb;//
	public static String DateBirthd;
	public static String SerPass;
	public static String NumbPass;
	public static String Address;
	 

	public static void Send() throws IOException {
		InetAddress ipAddress = InetAddress.getByName("77.123.57.3");
		Socket socket;

		socket = new Socket(ipAddress, 4333);
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		out.writeUTF(StrahVnesok);out.flush();
		out.writeUTF(Type);out.flush();
		out.writeUTF(Year);	out.flush();
		out.writeUTF(Area);out.flush();
		out.writeUTF(TermStart);out.flush();
		out.writeUTF(TermEnd);out.flush();
		out.writeUTF(DateContr);out.flush();
		out.writeUTF(Reward);out.flush();
		out.writeUTF(FIB);out.flush();
		out.writeUTF(Numb);out.flush();
		out.writeUTF(DateBirthd);out.flush();
		out.writeUTF(SerPass);out.flush();
		out.writeUTF(NumbPass);out.flush();
		out.writeUTF(Address);out.flush();
		

	}

}