package cn.com.hq.test;

import cn.com.hq.runable.MyRunnable;

import com.hq.service.InterFaceService;
import com.hq.serviceimpl.InterFaceServiceimpl;

public class Main {
    public static void main(String[] args) {
    	InterFaceService interFaceService = new InterFaceServiceimpl();
    	/*interFaceService.insertOrderBaseInfo("ABC", "10", "CLXX");
    	
		for(int i=1;i<=5;i++){
			Runnable myRunnable = new MyRunnable(i+"--");
			Thread thread1 = new Thread(myRunnable);
			thread1.start();
		}*/
    	//System.out.println( interFaceService.getTheRestOfQuery("ABC"));
    }
    
}
