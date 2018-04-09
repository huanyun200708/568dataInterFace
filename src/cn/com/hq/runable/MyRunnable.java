package cn.com.hq.runable;

import org.apache.log4j.Logger;

import com.hq.action.CLXXInterFaceAction;
import com.hq.model.Order;

public class MyRunnable  implements Runnable {
	private static Logger logger = Logger.getLogger(MyRunnable.class);
	private String name;
	
    public MyRunnable(String name) {
	    super();
	    this.name = name;
    }

	@Override
    public void run() {
		Order order = CLXXInterFaceAction.getOneOrderId("ABC");
    	System.out.println(this.name+"---"+order.getUser_order_id());
    }
    
}
