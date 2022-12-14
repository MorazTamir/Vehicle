//Author1: Ninel Benush 324699826 ,Author2: Moraz Tamir 208397455
import java.util.Random;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
		System.out.print("Please enter number of stations: ");
		int n = in.nextInt();
		System.out.print("Please enter number of vehicles: ");
		int m = in.nextInt();
		System.out.print("Please enter number between arrives: ");
		float avgArrive = in.nextFloat();
		System.out.print("Please enter number for washing time: ");
		float avgWash = in.nextFloat();
		WehicleWasher w = new WehicleWasher(n, avgWash);
		for (int i = 0; i < m; i++) {
			int newVe = rand.nextInt(4);
			if (newVe == 0)
				new Thread(new Car(w, "car" + i)).start();
			else if (newVe == 1)
				new Thread(new SUV(w, "suv" + i)).start();
			else if (newVe == 2)
				new Thread(new Truck(w, "truck" + i)).start();
			else
				new Thread(new MiniBus(w, "minibus" + i)).start();
			try {
				Thread.sleep(calcNextArrive(avgArrive));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		in.close();
	}

	public static int calcNextArrive(float avgArrive) {
		Random rand = new Random();
		double u = rand.nextDouble();
		double nextTimeArrive = (-(Math.log(u) / avgArrive)) * 1000;
		return (int) nextTimeArrive;
	}
}
