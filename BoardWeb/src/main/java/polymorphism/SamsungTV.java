package polymorphism;

public class SamsungTV implements TV{
	private Speaker speaker;
	private int price;
	
	public SamsungTV() {
		System.out.println("===> SamsungTV(1) 객체 생성");
	}
	
	public SamsungTV(Speaker speaker) {
		System.out.println("===> SamsungTV(2) 객체 생성");
		this.speaker = speaker;
	}
	
	public SamsungTV(Speaker speaker, int price) {
		System.out.println("===> SamsungTV(3) 객체 생성");
		this.speaker = speaker;
		this.price = price;
	}
	
//	public void initMethod() {
//		System.out.println("객체 초기화 작업 처리..");
//	}
//	public void destroyMethod() {
//		System.out.println("객체 삭제 전에 처리할 로직 처리...");
//	}

	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		System.out.println("==> setSpeaker() 호출");
		this.speaker = speaker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		System.out.println("==> setPrice() 호출");
		this.price = price;
	}

	public void powerOn() {
		System.out.println("SamsungTV----전원켠다. (가격: "+price+")");
	}
	
	public void powerOff() {
		System.out.println("SamsungTV----전원끈다.");
	}
	
	public void volumeUp() {
//		System.out.println("SamsungTV----볼륨업.");
//		speaker = new SonySpeaker();
		speaker.volumeUp();
	}
	
	public void volumeDown() {
//		System.out.println("SamsungTV----볼륨다운.");
//		speaker = new SonySpeaker();
		speaker.volumeDown();
	}
	
}
