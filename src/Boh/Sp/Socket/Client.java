package Boh.Sp.Socket;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

 public static Object BohProxy(Class clazz,InetSocketAddress addr) {	
	 
	
	return (Object) Proxy.newProxyInstance(clazz.getClassLoader(),new Class<?>[] {clazz} ,new InvocationHandler() {
		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			try {
				//10.147.58.102 9999
				Socket ct = new Socket();
				ct.connect(addr);
				ObjectInputStream in = null;
				ObjectOutputStream out = null;
				out = (ObjectOutputStream) ct.getOutputStream();
				//客户端请求 把代理类、方法名、和参数类型、参数发送过去
				out.writeUTF(clazz.getName());//proxy  回头试一下
				out.writeUTF(method.getName());
				//参数类型、参数
				out.writeObject(method.getParameterTypes());
				out.writeObject(args);
				
				//服务器进行了相应
				in = (ObjectInputStream) ct.getInputStream();
				Object rs = in.readObject(); 
				return rs;
			}catch(Exception e){
				e.printStackTrace();
			}
			return null;
		}
	});
 }
	 
}
