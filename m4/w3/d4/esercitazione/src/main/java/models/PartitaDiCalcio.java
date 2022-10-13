package models;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("partita_di_calcio")
public class PartitaDiCalcio extends Evento{
    
    private String squadraCasa;
    private String squadraOspite;
    private String squadraVincente;
    private int golCasa;
    private int golOspite;
    

    public PartitaDiCalcio() {}


	public PartitaDiCalcio( 
			String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			int numeroMassimoPartecipanti, Location location, String squadraCasa, String squadraOspite, int golCasa,int golOspite) {
		
		super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);

		this.squadraCasa = squadraCasa;
		this.squadraOspite = squadraOspite;
		this.golCasa = golCasa;
		this.golOspite = golOspite;
		this.setSquadraVincente();
	}


	public String getSquadraCasa() {
		return squadraCasa;
	}


	public void setSquadraCasa(String squadraCasa) {
		this.squadraCasa = squadraCasa;
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


	public void setSquadraVincente() {
		if(this.golCasa > this.golOspite) {
			this.squadraVincente = this.squadraCasa;
		}else if(this.golCasa < this.golOspite){
			this.squadraVincente = this.squadraOspite;
		}else {
			this.squadraVincente = "pareggio";
		}
	}


	public int getGolCasa() {
		return golCasa;
	}


	public void setGolCasa(int golCasa) {
		this.golCasa = golCasa;
	}


	public int getGolOspite() {
		return golOspite;
	}


	public void setGolOspite(int golOspite) {
		this.golOspite = golOspite;
	}


	@Override
	public String toString() {
		return "PartitaDiCalcio [squadraCasa=" + squadraCasa + ", squadraOspite=" + squadraOspite + ", squadraVincente="
				+ squadraVincente + ", golCasa=" + golCasa + ", golOspite=" + golOspite + "]";
	};
    




}
