package catalogoProdotti;

import java.time.LocalDate;
import java.util.List;

public class Order {
	
	private static Long idCount = 0L;

	private Long id;
	private String status;
	private LocalDate orderDate;
	private LocalDate deliveryDate;
	private List<Product> products;
	private Customer customer;
	
	public Order(Customer customer, List<Product> products) {
		this.id = idCount++;
		this.setStatus("PREPARAZIONE");
		this.orderDate = LocalDate.now();
		this.setDeliveryDate(orderDate.plusWeeks(1));
		this.setProducts(products);	
		this.customer = customer;
		
	}
	
	public Order(Customer customer, List<Product> products, LocalDate orderDate) {
		this(customer, products);
		this.orderDate=orderDate;
	}

	public Long getId() {
		return id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public void addProducts(Product product) {
		this.products.add(product);
	}

	public Customer getCustomer() {
		return customer;
	}
}
