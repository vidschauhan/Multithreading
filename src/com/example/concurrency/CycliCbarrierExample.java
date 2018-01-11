package com.example.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CycliCbarrierExample {

	public static CyclicBarrier newBarrier = new CyclicBarrier(3);
	
	public static void main(String[] args) {
		
		new Thread(()->{
			System.out.println("Number of parties required to trip the barrier = "+
			        newBarrier.getParties());
			System.out.println("Sum of product and sum = " + (WorkerThread2.product + 
					WorkerThread1.sum));
			
			// creation of child thread // moving child thread to runnable state
	       new WorkerThread1().getW1().start();
	       new WorkerThread2().getW2().start();
	           
	        
	       try
	        {
	    	   CycliCbarrierExample.newBarrier.await();
	        } 
	        catch (InterruptedException | BrokenBarrierException e) 
	        {
	            e.printStackTrace();
	        }
	         
	        // barrier breaks as the number of thread waiting for the barrier
	        // at this point = 3
	        System.out.println("Sum of product and sum = " + (WorkerThread2.product + 
	        WorkerThread1.sum));
	                 
	        // Resetting the newBarrier
	        newBarrier.reset();
	        System.out.println("Barrier reset successful");
	        
		}).start();

	}

}


class WorkerThread1 {
	
	static int sum =0;
	Thread w1 = new Thread(()-> {
		
		for(int i=1;i<10;i++) {
			sum+=2;
		}
		
			try {
				CycliCbarrierExample.newBarrier.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
       
		
	});
	public Thread getW1() {
		return w1;
	}
	public void setW1(Thread w1) {
		this.w1 = w1;
	}
}


class WorkerThread2{
	
	static int product = 1;
	Thread w2 = new Thread(()-> {
		
		for(int i=1;i<10;i++) {
			product*=i;
		}
		
		try {
			CycliCbarrierExample.newBarrier.await(3000, TimeUnit.MILLISECONDS);
			System.out.println("Number of parties waiting at the barrier "+
		            "at this point = " + CycliCbarrierExample.newBarrier.getNumberWaiting());
			
		} catch (InterruptedException | BrokenBarrierException | TimeoutException e) {
			e.printStackTrace();
		}
		
	});
	
	
	public Thread getW2() {
		return w2;
	}
	public void setW2(Thread w1) {
		this.w2 = w1;
	}
}