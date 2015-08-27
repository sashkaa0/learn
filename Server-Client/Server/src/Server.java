import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Server extends Thread {
	static ArrayList<String> list = new ArrayList<>();
	private Socket socket;

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(2121);
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
		SocketList.addSocketToList(socket);
		start();
	}

	public void run() {

		System.out.println("start run");
		try {
			while (true) {
				DataInputStream dIn = new DataInputStream(
						socket.getInputStream());
				DataOutputStream dOut = new DataOutputStream(
						socket.getOutputStream());
				String Data = dIn.readUTF();
				for (Socket socket : SocketList.getSocketList()) {
					try {
						dOut.writeUTF(Data);
					} catch (NullPointerException ignor) {
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}