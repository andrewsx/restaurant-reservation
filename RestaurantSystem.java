package edu.nyu.pqs.assignment5;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Random;
public class RestaurantSystem {
	private int numSeats = 50;
	private Set<Long> set = new HashSet<Long>();
	//map reservation ID to the person
	private ConcurrentHashMap<Long, Person> map = new ConcurrentHashMap<Long, Person>(); 
	
	protected synchronized void addReservation(Person reserver) {
		//generate new ID and add it to the set to ensure no repeated ids are given out
		if (reserver.getPartyCount() > numSeats) {
			System.out.println("There are no more available seats");
			return;
		}
		
		Random r = new Random();
		
		long id = r.nextLong();
		if (id < 0) {
			id = -id;
		}
		while (set.contains(id)) {
			id = r.nextLong();
			if (id < 0) {
				id = -id;
			}
		}
		
		map.put(id, reserver);
		
		
		set.add(id);
		
		numSeats = numSeats - reserver.getPartyCount();
		for (Long elem: set) {
			System.out.println(elem);
		}
		System.out.println("There are a total of " + numSeats + " left");
	}
	
	
	//changes the party count 
	protected synchronized void modifyReservation(long id, int updatedNum) {
		System.out.println("First ID: " + id);
		Person p = map.get(id);
		int diff = Math.abs(updatedNum - p.getPartyCount());
		if (updatedNum >= p.getPartyCount()) {
			numSeats = numSeats - diff;
		} else {
			numSeats = numSeats + diff; 
		}
		p.setNumPeople(updatedNum);
		
		map.put(id, p); 
		
		for (Map.Entry<Long, Person> entry : map.entrySet()) {
		    Long key = entry.getKey();
		    Person value = entry.getValue();
		    System.out.println("key: " + key + " value: " + value.getFirstName() + " " + value.getLastName()+ " " + value.getEmail()+ " " + value.getPartyCount());
		}
	}
	
	protected synchronized void deleteReservation(long id) {
		Person p = map.get(id);
		
		numSeats = numSeats + p.getPartyCount();
				
		map.remove(id);
		set.remove(id);
		
		// check if it got removed
		for (Map.Entry<Long, Person> entry : map.entrySet()) {
		    Long key = entry.getKey();
		    Person value = entry.getValue();
		    System.out.println("key: " + key + " value: " + value.getFirstName() + value.getLastName()+ value.getEmail());
		}
		System.out.println(numSeats);
	}
	
	public ConcurrentHashMap<Long, Person> getMap() {
		return map;
	}
	
}
