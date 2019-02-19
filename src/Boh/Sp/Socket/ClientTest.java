package Boh.Sp.Socket;

import java.lang.reflect.Method;
import java.net.InetSocketAddress;

public class ClientTest {

	public static void main(String[] args) {
		Client cc = new Client();
		try {
			Object bohProxy = cc.BohProxy(Class.forName("Rpc.ServiceInterface.IBohService"), new InetSocketAddress("10.147.58.102", 9999));
			try {
				Method method = bohProxy.getClass().getMethod("rpcSay", String.class);
				method.invoke(bohProxy, "My Son");
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
