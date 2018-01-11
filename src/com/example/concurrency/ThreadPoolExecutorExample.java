package com.example.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolExecutorExample {

	public static void main(String[] args) {
		
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        for (int i = 0; i <= 5; i++)
        {
            Task task = new Task("Task " + i);
            System.out.println("A new task has been added : " + task.getName());
            executor.execute(task.getT1());
        }
        executor.shutdown();
    }
		

	}

class Task 
{
    private String name;
 
    public Task(String name)
    {
        this.name = name;
    }
     
    public String getName() {
        return name;
    }
 
   Thread t1 = new Thread(()-> {
	   try
       {
          
          synchronized (this){ System.out.println("Doing a task during : " + name);
           Thread.sleep(2000);}
       }
       catch (InterruptedException e)
       {
           e.printStackTrace();
       } 
	   });

public Thread getT1() {
	return t1;
}

public void setT1(Thread t1) {
	this.t1 = t1;
}
}
