package com.example.concurrency;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureAndCallable {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newCachedThreadPool();
		Future<Integer>  future = executor.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {

				System.out.println("Thread Starting...");
				Random r = new Random();
				int duration = r.nextInt(3000);
				Thread.sleep(duration);
				System.out.println("Thread Finished...");
				return duration;
			}

		});
		
		executor.shutdown();
		
		try {
			System.out.println("Time duration of Sleep : " + future.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

	}

}
