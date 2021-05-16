package com.assignment.mock;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.assignment.custom.CustomArrayList;
import com.assignment.thread.CallableTask;

/**
 * 
 * @author Kablu
 *
 */
public class RunnableTaskMain {

	private static final int MYTHREADS = 5;
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService executor = Executors.newFixedThreadPool(MYTHREADS);
		Future<CustomArrayList<String>> submit = null;

		String[] cities = { "Pune", "Mumbai", "Ranchi", "Delhi"};
		
		for (int i = 0; i < cities.length; i++) {
			String city = cities[i];
			Callable<CustomArrayList<String>> callable = new CallableTask(CustomArrayList.getInstance(), city);
			submit = executor.submit(callable);
		}
		CustomArrayList<String> customArrayList = submit.get();
		
		Thread.currentThread().join(5000);
		System.out.println("Display Data:\n" + customArrayList.toString());
		executor.shutdown();
	
		while (!executor.isTerminated()) {
 
		}
		System.out.println("\nFinished all threads");
	}

}
