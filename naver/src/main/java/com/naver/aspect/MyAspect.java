package com.naver.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {

	@Pointcut("execution(public * com.naver(..))")
	public void targetMethod() {}
	
	@Around(value="targetMethod")
	public Object measure(ProceedingJoinPoint joinPoint)throws Throwable{
		try {
			System.out.println("��ü ����ȭ");
			Object result = joinPoint.proceed();
			return result;
		}
		finally {
			System.out.println("���� ������ �´�");
		}
	}
}
