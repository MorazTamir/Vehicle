//Author1: Ninel Benush 324699826 ,Author2: Moraz Tamir 208397455

public abstract class Wehicle implements Runnable{
		WehicleWasher w;
		String id;
		String type;

		public Wehicle(WehicleWasher w, String id, String type) {
			this.w = w;
			this.id = id;
			this.type = type;
		}
}

