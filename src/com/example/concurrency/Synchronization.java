package com.example.concurrency;

public class Synchronization {

	public static void main(String[] args) throws InterruptedException {
		Add ad = new Add(); 
		
	Thread t1 = new Thread(()->{
		for(int i=1;i<=5;i++) {
			ad.increment();	
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
		
				e.printStackTrace();
			}//synchronized(ad){ad.increment();}
		}
	});
	t1.start();
	t1.join();
	
	new Thread(()->{
		for(int i=1;i<=5;i++) {
		ad.increment();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
	
			e.printStackTrace();
		}//
		}
	}).start();
	
	}

	
}

class Add {
	int a = 0;
	public void increment() {
		synchronized(this) {
		System.out.println(Thread.currentThread().getName() +" " + ++a);}
	}
	
	/* You may get such Output before synchronization :
	 * Thread-0 0
	Thread-1 1
	Thread-1 3
	Thread-0 2
	Thread-1 4
	Thread-0 5
	Thread-1 6
	Thread-0 7
	Thread-1 8
	Thread-0 9*/

}
