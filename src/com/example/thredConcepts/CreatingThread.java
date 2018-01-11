package com.example.thredConcepts;

//By extending Thread class.
public class CreatingThread extends Thread {
	
	public void run()
	{
		for(int i = 0 ; i<10; i++) {
			System.out.println("Thread : " + i);
		try {
			Thread.sleep(1000);
		} catch(Exception ex) {
			ex.getMessage();
		}
		}
	}

	public static void main(String[] args) {
		
		CreatingThread th = new CreatingThread();
		th.start();

	}

}
