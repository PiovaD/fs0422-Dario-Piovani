package models;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class PartitaDiClacio extends Evento {

	private String squadraDiCasa;
	private String squadraOspite;
	private String squadraVincente;
	private int nGolCasa;
	private int nGolOspite;

	public PartitaDiClacio() {
	}

	public PartitaDiClacio(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			int numeroMassimoPartecipanti, Location location, String squadraDiCasa, String squadraOspite) {
		super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
		this.squadraDiCasa = squadraDiCasa;
		this.squadraOspite = squadraOspite;
	}

	public String getSquadraDiCasa() {
		return squadraDiCasa;
	}

	public void setSquadraDiCasa(String squadraDiCasa) {
		this.squadraDiCasa = squadraDiCasa;
	}

	public String getSquadraOspite() {
		return squadraOspite;
	}

	public void setSquadraOspite(String squadraOspite) {
		this.squadraOspite = squadraOspite;
	}

	public String getSquadraVincente() {
		return squadraVincente;
	}

	public void setSquadraVincente(String squadraVincente) {
		this.squadraVincente = squadraVincente;
	}

	public int getNumGolCasa() {
		return nGolCasa;
	}

	public void setNumGolCasa(int nGolCasa) {
		this.nGolCasa = nGolCasa;
	}

	public int getNumGolOspite() {
		return nGolOspite;
	}

	public void setNumGolOspite(int nGolOspite) {
		this.nGolOspite = nGolOspite;
	}

	
}
