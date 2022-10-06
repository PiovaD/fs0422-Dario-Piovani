package catalogoProdotti;

public class Product {

	private static Long idCount = 0L;

	private Long id;
	private String name;
	private String category;
	private Double price;

	public Product(String name, String category, Double price) {
		this.id = idCount++;
		this.setName(name);
		this.setCategory(category);
		this.setPrice(price);
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Id: " + this.id + " | Nome: " + this.name + " | Categoria: " + this.category + " | Prezzo "
				+ this.price + '€';
	}
}
