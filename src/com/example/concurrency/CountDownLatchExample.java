package com.example.concurrency;

import java.util.concurrent.CountDownLatch;

/*When we create an object of CountDownLatch, we specify the number if threads it should wait for.
 * Any thread, usually main thread of application, which calls CountDownLatch.await() will wait until count reaches zero
or its interrupted by another thread.
All other thread are required to do count down by calling CountDownLatch.countDown() 
once they are completed or ready.

As soon as count reaches zero, Thread awaiting starts running
CountDownLatch in Java is a type of synchronizer 
which allows one Thread to wait for one or more Threads before it starts processing.

Consider a scenario where manager divided modules between development teams (A and B) 
and he wants to assign it to QA team for testing only when both the teams completes their task.*/

public class CountDownLatchExample {

	public static void main(String[] args) {
		 	CountDownLatch countDownLatch = new CountDownLatch(2);
	        MyDevTeam teamDevA = new MyDevTeam(countDownLatch, "devA");
	        MyDevTeam teamDevB = new MyDevTeam(countDownLatch, "devB");
	        teamDevA.start();
	        teamDevB.start();
	        try {
				countDownLatch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	        MyQATeam qa = new MyQATeam();
	        qa.start();

	}

}

class MyDevTeam extends Thread {   
    CountDownLatch countDownLatch;
    public MyDevTeam (CountDownLatch countDownLatch, String name) {
        super(name);
        this.countDownLatch = countDownLatch;       
    }   
    @Override
    public void run() {
        System.out.println("Task assigned to development team " + Thread.currentThread().getName());
        try {
                Thread.sleep(2000);
        } catch (InterruptedException ex) {
                ex.printStackTrace();
        }
    System.out.println("Task finished by development team" + Thread.currentThread().getName());
            this.countDownLatch.countDown();
    }
}

class MyQATeam extends Thread {   
    @Override
    public void run() {
        System.out.println("Task assigned to QA team");
        try {
                Thread.sleep(2000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Task finished by QA team");
    }
}
