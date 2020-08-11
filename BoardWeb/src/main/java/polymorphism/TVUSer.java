package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUSer {
	public static void main(String[] args) {
//		1.spring 컨테이너 구동
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
//		2.spring 컨테이너로부터 필요한 객체를 요청한다.
		TV tv = (TV)factory.getBean("tv");
//		TV tv1 = (TV)factory.getBean("tv");
//		TV tv2 = (TV)factory.getBean("tv");
//		TV tv3 = (TV)factory.getBean("tv");
		
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();
		
//		3.spring 컨테이너를 종료.
		factory.close();
	}
}