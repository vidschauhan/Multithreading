package com.example.concurrency;

import java.util.concurrent.Semaphore;

public class SemaPhore {

	public static void main(String[] args) {
		Semaphore sem = new Semaphore(1);
		MyThread t1 = new MyThread("A",sem);
		MyThread t2 = new MyThread("B",sem);
		
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("Final count : " +Shared.count);
	}

}

class MyThread extends Thread{
	Semaphore semaphore;
	String threadName;
	public MyThread(String threadName,Semaphore semaphore) {
	
		super(threadName);
		this.threadName=threadName;
		this.semaphore=semaphore;
		
	}
	
	@Override
	public void run() {
		
		if(threadName.startsWith("A")) {
			
			System.out.println("Threadname :" + threadName);
			System.out.println("Acquiring  lock...");
			try {
				semaphore.acquire();
			
			System.out.println("Allowed permit count : " + semaphore.availablePermits());
			
			for(int i=0;i<5;i++) {
				Shared.count++;
				System.out.println(threadName + ": " + Shared.count);
		         
                // Now, allowing a context switch -- if possible.
                // for thread B to execute
                Thread.sleep(1000);
			}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("Releasing lock now...");
			semaphore.release();
			
		} else {
			
			
			System.out.println("Threadname :" + threadName);
			System.out.println("Acquiring  lock...");
			try {
				semaphore.acquire();
			
			System.out.println("Allowed permit count : " + semaphore.availablePermits());
			
			for(int i=0;i<5;i++) {
				Shared.count--;
				System.out.println(threadName + ": " + Shared.count);
		         
                // Now, allowing a context switch -- if possible.
                // for thread A to execute
                Thread.sleep(1000);
			}}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Releasing lock now...");
			semaphore.release();
			
			
		}
	}
	
}

class Shared 
{
    static int count = 0;
}
