//Author1: Ninel Benush 324699826 ,Author2: Moraz Tamir 208397455

import java.util.ArrayList;
import java.util.Random;

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

	public void wash(Wehicle w) throws InterruptedException {
		arriveCar(w);
		synchronized (this) {
			while (washing.size() == n)
				wait();
		}
		washCar(w);
		finishWash(w);
		synchronized (this) {
			notifyAll();
		}
	}

	public void arriveCar(Wehicle w) {
		waiting.add(w);
		printStatus("new vehicle arrived", w);
	}

	public void washCar(Wehicle w) throws InterruptedException {
		printStatus("The vehicle got into on of the stations", w);
		washing.add(w);
		waiting.remove(w);
		Thread.sleep(calcNextTime());
	}

	public void finishWash(Wehicle w) {
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
	}

	public int calcNextTime() {
		Random rand = new Random();
		double u = rand.nextDouble();
		double nextTime = (-(Math.log(u) / avgWash)) * 1000;
		return (int) nextTime;
	}

	public synchronized void printStatus(String message, Wehicle w) {
		long currentTime = System.currentTimeMillis() - initialTime;
		System.out.println("---------------------");
		System.out.println("Time from the start: " + currentTime + " milli seconds");
		System.out.println("Status: " + message);
		System.out.println("Id: " + w.id + ", Type: " + w.type);
	}

}
