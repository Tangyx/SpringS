package Boh.Sp.Log;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

//前置通知： AOP
public class BeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		System.out.println("---->前置通知： AOP"+arg0.getName());
	}

}
