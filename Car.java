//Author1: Ninel Benush 324699826 ,Author2: Moraz Tamir 208397455

public class Car extends Wehicle{
	public Car(WehicleWasher w, String id) {
		super(w, id, "Car");
	}

	public void run() {
		try {
			w.wash(this);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
