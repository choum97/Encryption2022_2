package com.java.ex.service;

import com.java.ex.lg.LgTv;
import com.java.ex.samsung.SamsungTv;

public class BeanFactory {
	public Object getBean(String beanName) {
		if(beanName.equals("samsung")) {
			return new SamsungTv();
		}else if(beanName.equals("lg")){
			return new LgTv();
		}
		return null;
	}
}
