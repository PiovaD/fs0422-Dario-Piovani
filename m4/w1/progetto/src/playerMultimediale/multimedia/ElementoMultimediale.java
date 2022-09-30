package playerMultimediale.multimedia;

public abstract class ElementoMultimediale {

	private String title;

	protected ElementoMultimediale(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public abstract void esegui();
}
