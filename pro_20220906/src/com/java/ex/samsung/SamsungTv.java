package com.java.ex.samsung;

import com.java.ex.service.TvTest;

public class SamsungTv implements TvTest{

	
	@Override
	public void powerOn() {
		System.out.println("삼성 전원 On");
	}

	@Override
	public void powerOff() {
		System.out.println("삼성 전원 Off");
	}

	@Override
	public void volumeUp() {
		System.out.println("삼성 소리 키우다");
	}

	@Override
	public void volumeDown() {
		System.out.println("삼성 소리 줄이다");
	}
	
}
