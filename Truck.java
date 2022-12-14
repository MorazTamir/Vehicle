//Author1: Ninel Benush 324699826 ,Author2: Moraz Tamir 208397455

public class Truck extends Wehicle{

	public Truck(WehicleWasher w, String id) {
		super(w, id, "Truck");
	}

	public void run() {
		try {
			w.wash(this);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
