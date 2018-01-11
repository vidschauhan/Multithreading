package com.example.thredConcepts;

public class Java8StyleThread {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(() -> {
			for (int i = 1; i < 10; i++) {
				System.out.println("Thread using lambda function : " + i);
				try {
					Thread.sleep(2000);
				} catch (Exception ex) {
					ex.getMessage();
				}
			}
		});
	t1.start();
	
	new Thread(() -> {
		for (int i = 1; i < 10; i++) {
			System.out.println("Anynomous Thread using lambda function : " + i);
			try {
				Thread.sleep(1000);
			} catch (Exception ex) {
				ex.getMessage();
			}
		}
	}).start();
		
	}

}
