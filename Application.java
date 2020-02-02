package edu.nyu.pqs.assignment5;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Application {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//we assume that when modification or deletion, the user provides information on updated head count
		RestaurantSystem system = new RestaurantSystem();
		
		RestaurantBookingThread t1 = new RestaurantBookingThread(new Person("Alicia", "Keys", "2124121523", "ak234@gmail.com", 6), ReservationAction.ADD, system);
		RestaurantBookingThread t2 = new RestaurantBookingThread(new Person("Dwayne", "Wade", "1426231323", "dwade@miamiheat.com", 10), ReservationAction.ADD, system);
		RestaurantBookingThread t3 = new RestaurantBookingThread(new Person("Alan", "Turing", "9231331483", "aturing@oxford.edu", 4), ReservationAction.ADD, system);
		
		
		
		//Testing modification restaurant reservations
//		ConcurrentHashMap<Long, Person> m = system.getMap();
//		m.put(133235443l, new Person("Santa", "Claus", "2121121523", "sc143@gmail.com", 4));
//		m.put(138235473l, new Person("Leonard", "Ulchter", "2124128123", "lu892@gmail.com", 5));
//		m.put(156235493l, new Person("Sam", "Chiu", "5124128123", "sc86692@gmail.com", 5));
//		m.put(542312493l, new Person("Sean", "Nordquist", "4123128123", "snord21692@gmail.com", 2));
//		RestaurantBookingThread t4 = new RestaurantBookingThread(133235443l, ReservationAction.MODIFY, system, 8);
//		RestaurantBookingThread t5 = new RestaurantBookingThread(138235473l, ReservationAction.MODIFY, system, 12);
		
		
		//Testing deleting restaurant reservations
//		ConcurrentHashMap<Long, Person> m = system.getMap();
//		m.put(133235443l, new Person("Santa", "Claus", "2121121523", "sc143@gmail.com", 4));
//		m.put(138235473l, new Person("Leonard", "Ulchter", "2124128123", "lu892@gmail.com", 5));
//		m.put(156235493l, new Person("Sam", "Chiu", "5124128123", "sc86692@gmail.com", 5));
//		RestaurantBookingThread t6 = new RestaurantBookingThread(133235443l, ReservationAction.DELETE, system);
//		RestaurantBookingThread t7 = new RestaurantBookingThread(138235473l, ReservationAction.DELETE, system);

		
		t1.start();
		t2.start();
		t3.start();
//		t4.start();
//		t5.start();
//		t6.start();
//		t7.start();
	}

}
