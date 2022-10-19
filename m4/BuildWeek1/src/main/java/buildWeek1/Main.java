package buildWeek1;

import java.time.LocalDate;
import java.util.List;

import models.Dealer;
import models.Periodicity;
import models.Reseller;
import models.Ticket;
import models.User;
import models.Vehicle;
import models.VehicleType;
import models.dao.ResellerDAO;
import models.dao.RouteDAO;
import models.dao.SeasonTicketDAO;
import models.dao.TicketDAO;
import models.dao.UserDAO;
import models.dao.VehicleDAO;
import models.display.RouteDisplay;
import models.display.UserDisplay;
import models.display.VehicleDisplay;
import models.display.VoyageDisplay;
import utils.JpaUtil;
import utils.LogColor;

public class Main {

	public static void main(String[] args) {
		
		VoyageDisplay.modaleVoyage();

		//VehicleDAO.vehicleTraker(1L,1L);
		
		//printList(TicketDAO.getTicketByTime(LocalDate.of(2021, 10, 10), LocalDate.of(2023, 11, 20)));
		
		//UserDisplay UD = new UserDisplay();
		
		//UD.modaleUtente();

		// RouteDisplay.modaleRoute();

		//VehicleDisplay.modaleVehicle();
		
//		Ticket t = TicketDAO.getById(1L);
//		
//		Vehicle v = VehicleDAO.getById(1L);
//		
//		VehicleDAO.punch(t, v);
		
		
		// JpaUtil.closeEMF();

/*		TicketDAO ticketDAO = new TicketDAO();
        SeasonTicketDAO seasonTicketDAO = new SeasonTicketDAO();
        ResellerDAO resellerDAO = new ResellerDAO();
        UserDAO userDAO = new UserDAO();
  		UserDisplay display = new UserDisplay();
 		display.modaleUtente();

        Reseller reseller = new Dealer();
        reseller.setName("Da Tonino");
        resellerDAO.save(reseller);


        User pinotto = userDAO.getById(3L);

        Reseller tonino = resellerDAO.getById(1L);
        Reseller resellerSuperClass = new Reseller();
        resellerSuperClass.makeSeasonTiket(tonino, pinotto, Periodicity.MONTHLY );
        System.out.println(ticketDAO.getTicketByReseller(1L));
        System.out.println(seasonTicketDAO.getSeasonTicketByReseller(1L));
        */

		System.out.println(LogColor.CYAN("THE END"));
	}
	
	private static <E> void printList(List<E> list) {
		System.out.println();
		for(E elm : list) {
			System.out.println(LogColor.GREEN(elm + ""));
		}
		
		System.out.printf("%n--------------------------------------%n");
	}
}
