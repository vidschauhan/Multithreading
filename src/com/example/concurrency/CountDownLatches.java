package com.example.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatches {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(5);
		ExecutorService executor = Executors.newCachedThreadPool();
		
		for(int i=1;i<=5;i++) {
			executor.submit(new WorkerThread(Integer.toString(i),latch));
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
System.out.println("Main thread!");
		
	}

}

class WorkerThread implements Runnable{
	
	String threadName;
	CountDownLatch  latch;
	public WorkerThread(String threadName,CountDownLatch  latch) {
	this.latch=latch;
	}
	
	@Override
	public void run() {
		try
        {
            Thread.sleep(2000);
            latch.countDown();
            System.out.println(Thread.currentThread().getName()
                               + " finished");
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
	}
}
