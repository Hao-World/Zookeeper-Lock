
package com.hao.lock;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderNumGenerator {

	// 生成订单号规则
	private static int count = 0;

	//单台服务器上，多个线程同时，生成订单号，线程安全
	public String getNumber() {
		try {
			Thread.sleep(200);
		} catch (Exception e) {

		}
		SimpleDateFormat simpt = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		return simpt.format(new Date()) + "-" + ++count;
	}

}
