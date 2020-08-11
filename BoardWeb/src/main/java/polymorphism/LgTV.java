package polymorphism;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV{
	@Autowired
//	@Qualifier("apple")
//	@Resource(name="apple")
	private Speaker speaker;
	
	public LgTV() {
		System.out.println("====>LgTV객체 생성");
	}
	
	public void powerOn() {
		System.out.println("LGTV----전원켠다.");
	}
	
	public void powerOff() {
		System.out.println("LGTV----전원끈다.");
	}
	
	public void volumeUp() {
//		System.out.println("LGTV----볼륨업.");
		speaker.volumeUp();
	}
	
	public void volumeDown() {
//		System.out.println("LGTV----볼륨다운.");
		speaker.volumeDown();
	}
}
