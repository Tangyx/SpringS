package Boh.Sp.Log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.Log4JLogger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//使用注解方式定义的AOP
@Component("aroundAnnotation")
@Aspect
public class AroundAnnotation {
	
	@Around(value="execution(* Boh.Sp.Service.impl.StudentServiceImpl.testStudent(..)))")
	public void around(ProceedingJoinPoint pt) {
		try {
			//执行方法之前 即是前置通知
			System.out.println("---》执行方法之前 即是前置通知");
			Object result= pt.proceed();//执行方法,并接收返回值
			//执行方法之前 即是后置通知
			System.out.println("---》执行方法之前 即是后置通知"+result);
		} catch (Throwable e) {
			//异常通知
		}finally {
			//最终通知
		}
	}
	//@Autowired
}
