package catalogoProdotti;

public class Customer {
	
	private static Long idCount = 0L;
	
	private Long id;
	private String name;
	private Integer tier;
	
	public Customer(String name, int tier) {
		this.id = idCount++;
		this.setName(name);
		this.setTier(tier);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTier() {
		return tier;
	}

	public void setTier(Integer tier) {
		this.tier = tier;
	}

	public Long getId() {
		return id;
	}
}
