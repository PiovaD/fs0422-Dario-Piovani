package m5w3d4.es2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Libro extends ComponenteLibro{

	private String titolo;
	
	private List<String> autori;
	private List<ComponenteLibro> listaComponenti = new ArrayList<ComponenteLibro>();
	
	public Libro() {
	}
	
	public Libro(String t) {
		this.titolo = t;
	}

	public void stampa() {
		System.out.println("Libro: " + titolo);
		listaComponenti.forEach(com -> com.stampa());
	}

	public List<String> getAutori() {
		return this.autori;

	}
	
	public void addListaC(ComponenteLibro c) {
		this.listaComponenti.add(c);
	}

	public int getNumeroPagine() {
		Integer numeroPagine = getListaComponenti().stream()
				.collect(Collectors.summingInt(ComponenteLibro::getNumeroPagine));
		return numeroPagine;
	}

	public List<ComponenteLibro> getListaComponenti() {
		return listaComponenti;
	}

	public void setListaComponenti(List<ComponenteLibro> listaComponenti) {
		this.listaComponenti = listaComponenti;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public void setAutori(List<String> autori) {
		this.autori = autori;
	}
}
