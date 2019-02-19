package Boh.Sp.Utils;

import java.lang.reflect.Method;
import java.util.Base64;

import org.apache.commons.codec.digest.DigestUtils;

public class JavaSecurity {

	public static String Xor(String sr) {
		String rString = "";
		char[] chs = sr.toCharArray();
		/*for(char c:chs) {
			c=(char) (c^123);//异或操作
		}*/
		for(int i=0;i<chs.length;i++) {
			chs[i]=(char) (chs[i]^3);//异或操作
		}
		rString = new String(chs);
		return rString;
	}
	
	@SuppressWarnings("static-access")
	public static String md5Encode(String sr) {
		DigestUtils digestUtils = new DigestUtils();
		String rs = digestUtils.md5Hex(sr);//MD5加密方法	
		return new String(rs);
	}
	
	@SuppressWarnings("static-access")
	public static String shaEncode(String sr) {
		DigestUtils digestUtils = new DigestUtils();
		String rs = digestUtils.sha1Hex(sr);//sha1加密方法	
		return new String(rs);
	}
	
	
	public static String base64Encoding(String rs) {
		byte[] result;
		//调用base64
		result = Base64.getEncoder().encode(rs.getBytes());
		return new String(result);
	}
	
	//使用反射MD5
	@SuppressWarnings("unchecked")
	public static String base64reflectEncoding(String rs) {
		String result = null;
		//com.sun.org.apache.xerces.internal.impl.dv.util.Base64.encode(rs.getBytes());
		try {
			Class clazz = Class.forName("com.sun.org.apache.xerces.internal.impl.dv.util.Base64");
			Method method = clazz.getMethod("encode", byte[].class);
			result = (String) method.invoke(clazz, rs.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static String base64Decoding(String rs) {
		byte[] result;
		//调用base64
		result = Base64.getDecoder().decode(rs);
		return new String(result);
	}
	
	public static void main(String[] args) {
		String rs = "boh";
		rs = Xor(rs);
		System.out.println("The First XOR Encoding:"+rs);
		rs = Xor(rs);//第二次异或将还原
		System.out.println("The Second XOR Encoding:"+rs);
		//MD5
		System.out.println("MD5加密："+md5Encode(rs));
		//SHA1
		System.out.println("SHA1加密："+shaEncode(rs));
		String rs64 = "hello";
		//Base64加密
		String rsbase = base64Encoding(rs64);
		System.out.println("base64Encoding加密："+rsbase);
		//Base64加密
		System.out.println("base64Encoding加密："+base64Decoding(rsbase)); 
		//发现使用此方法和使用java.utils里的直接加密结果是一样的
		System.out.println("base64反射Encoding加密："+base64reflectEncoding(rs64));
		
	}
}
