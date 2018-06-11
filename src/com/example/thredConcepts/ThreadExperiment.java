package com.example.thredConcepts;

public class ThreadExperiment {

	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Run of anynomous Runnable ");
			}
			
		});
		thread.start();

	}

}
