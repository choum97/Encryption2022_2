package pro_20220906;

public class test1 {

	public static void main(String[] args) {

		SamsungTVtest samsungTv = new SamsungTVtest();
		samsungTv.powerOn();
		samsungTv.volumeUp();
		samsungTv.volumeDown();
		samsungTv.powerOff();
		
		LgTVtest lgTv = new LgTVtest();
		lgTv.turnOn();
		lgTv.soundDown();
		lgTv.soundUp();
		lgTv.turnOff();
		
	}

}
