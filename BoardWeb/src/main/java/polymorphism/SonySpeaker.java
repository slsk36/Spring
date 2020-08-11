package polymorphism;

import org.springframework.stereotype.Component;

//@Component("sony")
public class SonySpeaker implements Speaker {
	public SonySpeaker() {
		System.out.println("===> Sonyspeaker 객체 생성");
	}
	public void volumeUp() {
		System.out.println("SonySpeaker 소리올린다");
	}
	public void volumeDown() {
		System.out.println("SonySpeaker 소리내린다.");
	}
}
