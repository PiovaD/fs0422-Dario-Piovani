package playerMultimediale;

public class Video extends ElementoMultimediale implements IShowable, IPlayable {

	private int volume;
	private int duration;
	private int brightness;

	public Video(String title, int duration, int volume, int brightness) {
		super(title);
		this.volume = volume;
		this.duration = duration;
		this.brightness = brightness;
	}

	public int getDuration() {
		return this.duration;
	}

	public int getVolume() {
		return this.volume;
	}

	public int getBrightness() {
		return this.brightness;
	}

	@Override
	public void esegui() {
		for (int i = 0; i < this.duration; i++) {
			this.play();
			this.show();
		}
	}

	public void play() {

		System.out.printf(super.getTitle() + ": %n" + "Volume: ");
		for (int i = 0; i < this.volume; i++) {
			System.out.printf("*");
		}
		System.out.println();

	}

	@Override
	public void show() {
		System.out.printf("Luminosità: ");
		for (int i = 0; i < this.brightness; i++) {
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

	public void brightnessUp() {
		this.brightness++;
	}

	public void brightnessDown() {
		this.brightness--;
	}

}