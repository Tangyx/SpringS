package Boh.Sp.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Boh.Sp.Service.IStudentService;


public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IStudentService service = (IStudentService)context.getBean("studentServiceImpl");
		boolean a = service.testStudent();
		//用接口去走
	}

}
