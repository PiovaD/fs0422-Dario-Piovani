package models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "getIsStreaming", query = "SELECT concert FROM Concerto concert WHERE concert.inStreaming = :isSt")
@NamedQuery(name = "getConcertGenre", query = "SELECT concert FROM Concerto concert WHERE concert.genere = :genere")
public class Concerto extends Evento {

	@Enumerated(EnumType.STRING)
	private GenereConcerto genere;

	private Boolean inStreaming;

	public Concerto() {
	}

	public Concerto(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			int numeroMassimoPartecipanti, Location location, GenereConcerto genere, Boolean inStreaming) {
		super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);

		this.genere = genere;
		this.inStreaming = inStreaming;
	}

	public GenereConcerto getGenere() {
		return genere;
	}

	public void setGenere(GenereConcerto genere) {
		this.genere = genere;
	}

	public Boolean getInStreaming() {
		return inStreaming;
	}

	public void setInStreaming(Boolean inStreaming) {
		this.inStreaming = inStreaming;
	}

	@Override
	public String toString() {
		return "Concerto [genere=" + genere + ", inStreaming=" + inStreaming + ", getTitolo()=" + getTitolo()
				+ ", getDataEvento()=" + getDataEvento() + ", getDescrizione()=" + getDescrizione()
				+ ", getTipoEvento()=" + getTipoEvento() + ", getNumeroMassimoPartecipanti()="
				+ getNumeroMassimoPartecipanti() + ", getLocation()=" + getLocation() + "]";
	}

}
