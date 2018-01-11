package com.example.concurrency;

public class SleepAndJoin {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(()-> {
			for(int i =1;i<=10;i++) {
				System.out.println("User Thread : " + Thread.currentThread().getName());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		try {	
			//will cause to first complete execution of thread t1.
			t1.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		for(int i =1;i<=5;i++) {
			System.out.println("Main Thread : " + Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
