package com.java.ex.lg;

import com.java.ex.service.TvTest;

public class LgTv implements TvTest{

	@Override
	public void powerOn() {
		System.out.println("lg 소리 키다");
	}
	@Override
	public void powerOff() {
		System.out.println("lg 소리 끄다");
	}

	@Override
	public void volumeUp() {
		System.out.println("lg 소리 키우다");
	}
	@Override
	public void volumeDown() {
		System.out.println("lg 소리 줄이다");
	}
}
