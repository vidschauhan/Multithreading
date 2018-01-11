package com.example.concurrency;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskExample {

	public static void main(String[] args) {
		// Creating Array of FutureTask
		// FutureTask is a concrete class that
	    // implements both Runnable and Future
		FutureTask<Integer>[] fTask = new FutureTask[5];
		
		for(int i=0;i<5;i++) {
			Callable<Integer> callable = new MyCallable();
			 
			// Create the FutureTask with Callable
			fTask[i] = new FutureTask<Integer>(callable);
			// As it implements Runnable, create Thread with FutureTask
			Thread t1 = new Thread(fTask[i]);
			t1.start();
		}
		
		for(int i=0;i<5;i++) {
			try {
				System.out.println("Values form callable task : " + fTask[i].get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		

	}

}

class MyCallable implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
	
		Random r = new Random();
		int duration = r.nextInt(20);
		
		Thread.sleep(duration * 1000);
		
		return duration;
	}
	
	
}
