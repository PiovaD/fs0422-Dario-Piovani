package playerMultimediale.multimedia;

public class Immagine extends ElementoMultimediale implements IShowable {

	private int brightness;

	public Immagine(String title, int brightness) {
		super(title);
		this.brightness = brightness;
	}

	public int getBrightness() {
		return this.brightness;
	}

	public void setBrightness(int b) {
		this.brightness = b;
		}
	
	@Override
	public void esegui() {
		System.out.println(super.getTitle());
		this.show();
	}

	@Override
	public void show() {
		System.out.printf("Luminosità: ");
		for (int i = 0; i < this.brightness; i++) {
			System.out.printf("!");
		}
		System.out.println();
	}

	public void brightnessUp() {
		this.brightness++;
	}

	public void brightnessDown() {
		if (this.brightness > 0) {
			this.brightness--;
		}
	}

}
