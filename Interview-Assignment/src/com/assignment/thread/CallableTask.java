package com.assignment.thread;

import java.util.concurrent.Callable;

import com.assignment.custom.CustomArrayList;

/**
 * 
 * @author Kablu
 *
 */
public class CallableTask implements Callable<CustomArrayList<String>> {

	CustomArrayList<String> cal;
	String data;
	
	public CallableTask(CustomArrayList<String> cal, String data) {
		this.cal = cal;
		this.data = data;
	}

	@Override
	public CustomArrayList<String> call() throws Exception {
		
		try {
			cal.add(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Thread Name:" + Thread.currentThread().getName() + "\tData:" + data);
		
		return cal;
	}

	
}
