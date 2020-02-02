package edu.nyu.pqs.assignment5;

import java.util.concurrent.ConcurrentHashMap;

public class RestaurantBookingThread extends Thread {
	
	private Person reserver;
	private ReservationAction action;
	private RestaurantSystem system;
	private long id; 
	private int numParty; 
	//for addition
	public RestaurantBookingThread(Person reserver, ReservationAction action, RestaurantSystem system) {
		this.reserver = reserver;
		this.action = action;
		this.system = system;
		this.id = 0;
		this.numParty = reserver.getPartyCount(); 
	}
	//for modification
	public RestaurantBookingThread(Long resID, ReservationAction action, RestaurantSystem system, int updatedNum) {
		this.action = action;
		this.system = system;
		this.id = resID;
		this.numParty = updatedNum;
	}
	//for deletion
	public RestaurantBookingThread(Long resID, ReservationAction action, RestaurantSystem system) {
		this.action = action;
		this.system = system;
		this.id = resID;
	}

	@Override
	public void run() {
		switch (action) {
			case ADD:
				system.addReservation(reserver);
				break;
			case MODIFY:
				System.out.println("HELLO" + this.id);
				ConcurrentHashMap<Long, Person> mp = system.getMap();
				if (mp.containsKey(this.id)) {
					System.out.println("ENTRY" + this.id);
					system.modifyReservation(id, numParty);
					break;
				}
				
			case DELETE:
				system.deleteReservation(id);
				break;
			
		}
	}
	
}
