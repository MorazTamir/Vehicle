//Author1: Ninel Benush 324699826 ,Author2: Moraz Tamir 208397455

import java.util.ArrayList;

public class WehicleWasher {
	int n;
	float avgWash;
	long initialTime;
	ArrayList<Wehicle> waiting;
	ArrayList<Wehicle> washing;
	ArrayList<Car> car;
	ArrayList<SUV> suv;
	ArrayList<Truck> truck;
	ArrayList<MiniBus> minibus;

	public WehicleWasher(int n, float avgWash) {
		this.n = n;
		this.avgWash = avgWash;
		this.waiting = new ArrayList<Wehicle>();
		this.washing = new ArrayList<Wehicle>();
		this.car = new ArrayList<Car>();
		this.suv = new ArrayList<SUV>();
		this.truck = new ArrayList<Truck>();
		this.minibus = new ArrayList<MiniBus>();
		this.initialTime = System.currentTimeMillis();
	}

	public synchronized void wash(Wehicle w) throws InterruptedException {
		waiting.add(w);
		printStatus("new vehicle arrived", w);
		while (washing.size() == n)
			w.wait();
		printStatus("The vehicle got into on of the stations", w);
		washing.add(w);
		waiting.remove(w);
		int delay = (int) (avgWash * 1000);
		Thread.sleep(delay);
		if (w instanceof Car)
			car.add((Car) w);
		else if (w instanceof SUV)
			suv.add((SUV) w);
		else if (w instanceof Truck)
			truck.add((Truck) w);
		else
			minibus.add((MiniBus) w);
		printStatus("The vehicle finish to wash himself", w);
		washing.remove(w);
		this.notifyAll();

	}

	public void printStatus(String message, Wehicle w) {
		long currentTime = System.currentTimeMillis() - initialTime;
		System.out.println("---------------------");
		System.out.println("Time from the start: " + currentTime);
		System.out.println("Status: " + message);
		System.out.println("Id: " + w.id + ", Type: " + w.type);
	}

}
