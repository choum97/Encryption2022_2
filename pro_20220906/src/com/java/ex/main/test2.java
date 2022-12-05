package com.java.ex.main;

import com.java.ex.lg.LgTv;
import com.java.ex.samsung.SamsungTv;
import com.java.ex.service.BeanFactory;
import com.java.ex.service.TvTest;

public class test2 {

	public static void main(String[] args) {
		//LgTv lgTv = new LgTv();
		//SamsungTv samsungTv = new SamsungTv();
		
		/*
		lgTv.powerOn();
		lgTv.volumeUp();
		lgTv.volumeDown();
		lgTv.powerOff();
		
		samsungTv.powerOn();
		samsungTv.volumeUp();
		samsungTv.volumeDown();
		samsungTv.powerOff();
		*/
		
		BeanFactory factory = new BeanFactory();
		
		TvTest tv = (TvTest) factory.getBean(args[0]);
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		
	}
}
