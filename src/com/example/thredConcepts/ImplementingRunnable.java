package com.example.thredConcepts;

public class ImplementingRunnable implements Runnable {

	public static void main(String[] args) {
		ImplementingRunnable obj = new ImplementingRunnable();
		Thread t1 = new Thread(obj);
		t1.start();
		
	}
	@Override
	public void run() {
		
		for(int i = 0 ; i<10; i++) {
			System.out.println("Runnable class Thread : " + i);
		try {
			Thread.sleep(1000);
		} catch(Exception ex) {
			ex.getMessage();
		}
		}
	}

}
