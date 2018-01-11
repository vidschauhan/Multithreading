package com.example.concurrency;

public class Yield {

	public static void main(String[] args) {
		// One way to Run child Thread. but first Implement Runnable.
		/*Yield obj = new Yield();
		Thread t1 = new Thread(obj);
		t1.start();*/
		
		
		//Java 8 style Creating a Thread.
		new Thread(()-> {
			for (int i = 0; i < 5; i++)
				System.out.println(Thread.currentThread().getName() + " in control");
		}).start();
		
		
		// Inside Main Thread
		for (int i = 0; i < 5; i++) {
			
			//main thread invoked yield() to give control to other thread i.e child thread.
			// Control passes to child thread
			Thread.yield();

			// After execution of child Thread
			// main thread takes over
			System.out.println(Thread.currentThread().getName() + " in control");
		}
		
	}

	// Simple way to implement Runnable 
	/*@Override
	public void run() {
		for (int i = 0; i < 5; i++)
			System.out.println(Thread.currentThread().getName() + " in control");
	}*/

}
