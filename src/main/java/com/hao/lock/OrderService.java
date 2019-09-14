
package com.hao.lock;

public class OrderService implements Runnable {
	private OrderNumGenerator orderNumGenerator = new OrderNumGenerator();
//	private ExtLock extLock = new ZookeeperDistrbuteLock();

	public void run() {
		getNumber00();
	}

//	public void getNumber() {
//		try {
//			extLock.getLock();
//			String number = orderNumGenerator.getNumber();
//			System.out.println("线程:" + Thread.currentThread().getName() + ",生成订单id:" + number);
//		} catch (Exception e) {
//
//		} finally {
//			extLock.unLock();
//		}
//	}
	
	
	//如果是单个服务器的话可以用synchronized关键字
	public synchronized void getNumber00() {
		String number = orderNumGenerator.getNumber();
		System.out.println("线程:"+Thread.currentThread().getName()+"，生成订单id："+number);
		
	}

	
	
	public static void main(String[] args) {
		System.out.println("多线程生成number");
		// OrderService orderService = new OrderService();
		for (int i = 0; i < 100; i++) {
			new Thread(new OrderService()).start();
		}
	}
	
}
