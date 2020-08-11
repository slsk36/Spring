package polymorphism;

import org.springframework.stereotype.Component;

//@Component("apple")
public class AppleSpeaker implements Speaker {
	public AppleSpeaker() {
		System.out.println("===> Applespeaker 객체 생성");
	}
	public void volumeUp() {
		System.out.println("AppleSpeaker 소리올린다");
	}
	public void volumeDown() {
		System.out.println("AppleSpeaker 소리내린다.");
	}
}
