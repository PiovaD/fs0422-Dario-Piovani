package playerMultimediale;

public class Audio extends ElementoMultimediale implements IPlayable {

	private int volume;
	private int duration;

	public Audio(String title, int duration, int volume) {
		super(title);
		this.volume = volume;
		this.duration = duration;
	}

	public int getDuration() {
		return this.duration;
	}

	public int getVolume() {
		return this.volume;
	}

	@Override
	public void esegui() {
		for (int i = 0; i < this.duration; i++) {
			this.play();
		}
	}

	@Override
	public void play() {
		System.out.printf(super.getTitle() + ": %n" + "Volume: ");
		for (int j = 0; j < this.volume; j++) {
			System.out.printf("*");
		}
		System.out.println();
	}

	public void volumeUp() {
		this.volume++;
	}

	public void volumeDown() {
		this.volume--;
	}

}
