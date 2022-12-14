//Author1: Ninel Benush 324699826 ,Author2: Moraz Tamir 208397455

public class SUV extends Wehicle{

	public SUV(WehicleWasher w, String id) {
		super(w, id, "SUV");
	}

	public void run() {
		try {
			w.wash(this);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
