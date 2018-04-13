package com.example.queue;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueue1 {

	public static void main(String[] args) {
		
		Queue<String> clq= new ConcurrentLinkedQueue<>();
		clq.add("Vidit");
		clq.add("Kumar");
		clq.add("Singh");
		
		clq.stream().forEach(System.out::println);
		
		/*if(clq.size() >= 3) {
			clq.remove();
		}*/
		
		clq.poll();
		
		clq.add("New Element");
		clq.stream().forEach(System.out::println);
		
		
	}

}
