package Boh.Sp.Socket;

import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketTest {
	public static void main(String[] args) {
		ObjectOutputStream output = null;
		try {
			Socket socket = new Socket("10.147.58.102", 9999);
			output = new ObjectOutputStream( socket.getOutputStream());
			output.writeUTF("123");
			output.writeUTF("123");
			output.writeObject(null);
			output.writeObject(null);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (output != null) {
				try {
					output.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}		
		}
	}
}
