package m5w3d4;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import m5w3d4.es1.InfoDataAdapter;
import m5w3d4.es1.Info;
import m5w3d4.es1.UserData;
import m5w3d4.es2.Libro;
import m5w3d4.es2.Pagina;
import m5w3d4.es2.Sezione;
import m5w3d4.es3.Capitano;
import m5w3d4.es3.Colonnello;
import m5w3d4.es3.Generale;
import m5w3d4.es3.Maggiore;
import m5w3d4.es3.Tenente;

public class home {

	public static void main(String[] args) {
		adapter();

		System.out.println("---------------------------------");

		composite();

		System.out.println("---------------------------------");

		chainOfResponsibility();
	}

	public static void adapter() {

		Info i = new Info();
		i.setCognome("Rossi");
		i.setNome("Mario");
		i.setDataDiNascita(Date.from(LocalDate.of(1993, 4, 18).atStartOfDay(ZoneId.systemDefault()).toInstant()));

		UserData ud = new UserData();
		ud.getData(new InfoDataAdapter(i));

		System.out.println(ud.getNomeCompleto());
		System.out.println(ud.getEta());

	}

	public static void composite() {
		Pagina p1 = new Pagina(1);
		Pagina p2 = new Pagina(2);
		Pagina p3 = new Pagina(3);
		Pagina p4 = new Pagina(4);
		
		Sezione s1 = new Sezione("s1");
		Sezione s2 = new Sezione("s2");
		
		Libro l1 = new Libro("l1");
		
		s1.addListaC(p1);
		s1.addListaC(p2);
		s1.addListaC(p3);
		
		s2.addListaC(p4);
		
		l1.addListaC(s1);
		l1.addListaC(s2);
		
		l1.stampa();
		System.out.println(l1.getNumeroPagine());
	}

	public static void chainOfResponsibility() {
		Capitano cap = new Capitano();

		Maggiore mag = new Maggiore();

		Tenente ten = new Tenente();

		Colonnello col = new Colonnello();

		Generale gen = new Generale();

		cap.setSuperiore(mag);

		mag.setSuperiore(ten);

		ten.setSuperiore(col);

		col.setSuperiore(gen);

		cap.testStipendio(1000);
	}

}
