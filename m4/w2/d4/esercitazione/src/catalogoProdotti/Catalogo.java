package catalogoProdotti;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Catalogo {

	public static void main(String[] args) {

		final String line = "-----------------------------------------------------%n";

		List<Product> catalog = new ArrayList<>(Arrays.asList(new Product("Fight Club", "Books", 9.99),
				new Product("Flow", "Books", 5.99), new Product("The Java Handbook", "Books", 129.99),
				new Product("Pannolini", "Baby", 4.99), new Product("Plasmon", "Baby", 2.99),
				new Product("Biberon", "Baby", 6.99), new Product("Figurine Calciatori Panini", "Boys", 5.00),
				new Product("Tuta Adidas", "Boys", 39.99), new Product("Scarpe Nike", "Boys", 6.99)));

		catalog.forEach(System.out::println);

		// es1 categoria books > 20€
		System.out.printf("%nES1" + line);

		List<Product> libriCostosi = catalog.stream()
				.filter((p) -> p.getPrice() > 100 && p.getCategory()
						.equals("Books"))
				.collect(Collectors.toList());
		libriCostosi.forEach(System.out::println);

		// es2 categoria baby
		System.out.printf("%nES2" + line);

		List<Product> baby = catalog.stream()
				.filter((p) -> p.getCategory()
						.equals("Baby"))
				.collect(Collectors.toList());
		baby.forEach(System.out::println);

		// es3 10% discount
		System.out.printf("%nES3" + line);

		List<Product> boysSale = catalog.stream()
				.filter((p) -> p.getCategory()
						.equals("Boys"))
				.map(p ->
					{
						p.setPrice(p.getPrice() - ((p.getPrice() * 10) / 100));
						return p;
					})
				.collect(Collectors.toList());
		boysSale.forEach(System.out::println);

		// es4 lista ordinata clienti tier 2 dal l’01-Feb-2021 al l’01-Apr-2021
		System.out.printf("%nES4" + line);

		Customer c1 = new Customer("Luigi", 1);
		Customer c2 = new Customer("Mario", 2);
		Customer c3 = new Customer("Pippo", 3);
		Customer c4 = new Customer("Aldo", 2);

		Order o1 = new Order(c1, catalog, LocalDate.of(2021, 8, 24));
		Order o2 = new Order(c2, catalog, LocalDate.of(2021, 3, 3));//
		Order o3 = new Order(c3, catalog, LocalDate.of(2021, 2, 8));
		Order o4 = new Order(c4, catalog, LocalDate.of(2022, 6, 4));
		Order o5 = new Order(c1, catalog, LocalDate.of(2020, 2, 9));
		Order o6 = new Order(c2, catalog, LocalDate.of(2022, 4, 9));
		Order o7 = new Order(c3, catalog, LocalDate.of(2020, 1, 5));
		Order o8 = new Order(c4, catalog, LocalDate.of(2021, 3, 5));//

		Stream<Order> orderS = Stream.<Order>builder()
				.add(o1)
				.add(o2)
				.add(o3)
				.add(o4)
				.add(o5)
				.add(o6)
				.add(o7)
				.add(o8)
				.build();

		List<Product> productOrderByT2FebAp = orderS.filter(o -> o.getCustomer()
				.getTier()
				.equals(2)
				&& o.getOrderDate()
						.compareTo(LocalDate.of(2021, 2, 1)) >= 0
				&& o.getOrderDate()
						.compareTo(LocalDate.of(2021, 4, 1)) <= 0)
				.map(p ->
					{
						return p.getProducts();
					})
				.flatMap(List::stream)
				.collect(Collectors.toList());

		productOrderByT2FebAp.forEach(System.out::println);

	}

}
