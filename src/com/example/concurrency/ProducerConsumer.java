package com.example.concurrency;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {

	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
	public static void main(String[] args) throws InterruptedException {
	
		Thread t1 = new Thread(() -> {
			producer();
		});
		

		Thread t2 = new Thread(() -> {
			consumer();
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
	}

	private static void producer() {
		
		while(true) {
			try {
				queue.put(new Random().nextInt(100));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void consumer() {
		boolean start = true;
		while(start) {
			
			try {
				Thread.sleep(100);
				if(new Random().nextInt(10) == 0)
				System.out.println("Message received : " + queue.take() + " Remaining Queue size " + queue.size());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			/*if(!new Scanner(System.in).nextLine().trim().equals("")) {
				continue;
			}else {
				start=false;
			}*/
			
		}
	}
}
