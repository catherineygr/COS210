package edu.mccc.cos210.ds.pq;
import java.time.LocalTime;
import edu.mccc.cos210.sp2016.ds.PriorityQueue;

public class PQExample {
	private PriorityQueue<Message> pq = new PriorityQueue<>();
	public static void main(String[] sa) {
		new PQExample().doIt();
	}
	private void doIt() {
		pq.insert(new Message("-Low Priority Message 1")); pause();
		pq.insert(new Message("+High Priority Message 1")); pause();
		pq.insert(new Message("*Very High Priority Message 1")); pause();
		pq.insert(new Message("Normal Message 1")); pause();
		pq.insert(new Message("Normal Message 2")); pause();
		pq.insert(new Message("+High Priority Message 2")); pause();
		pq.insert(new Message("-Low Priority Message 2")); pause();
		pq.insert(new Message("-Low Priority Message 3")); pause();
		pq.insert(new Message("Normal Message 3")); pause();
		pq.insert(new Message("Normal Message 4")); pause();
		pq.insert(new Message("+High Priority Message 3")); pause();
		pq.insert(new Message("*Very High Priority Message 2")); pause();
		while (!pq.isEmpty()) {
			System.out.println(pq.getTop().getMessage());
		}
	}
	private void pause() {
		try {
			Thread.sleep(1);
		} catch (Exception ex) {
		}
	}
	class Message implements Comparable<Message> {
		private int priority;
		private LocalTime time;
		private String message;
		public Message(String s) {
			priority = s.startsWith("*") ? 0 :
							s.startsWith("+") ? 5 :
							s.startsWith("-") ? 100 :
							10
			;
			time = LocalTime.now();
			message = s;
		}
		public int getPriority() {
			return priority;
		}
		public String getMessage() {
			return message;
		}
		@Override
		public int compareTo(Message that) {
			int n = this.priority - that.priority;
			if (n != 0) {
				return n;
			}
			return this.time.compareTo(that.time);
		}
		@Override
		public String toString() {
			return priority + " " + message;
		}
	}
}
