package com.sxt.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BlockedSleep02_倒计时 {	
	public static void main(String[] args) throws InterruptedException{
		Date endTime=new Date(System.currentTimeMillis()+1000*10);
		long end=endTime.getTime();
		while(true){
			System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
			Thread.sleep(1000);
			endTime=new Date(endTime.getTime()-1000);
			if(end-10000>=endTime.getTime())
				break;
		}
	}
	static void test() throws InterruptedException {
	//倒数10个数字，1秒一个数字
		int num=10;
		while(true){
			Thread.sleep(1000);
			System.out.println(num--);
			if(num<0)
				break;
		}
	}
}


