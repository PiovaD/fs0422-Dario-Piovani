package gestionePrenotazioni;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import gestionePrenotazioni.configs.BookingConfig;
import gestionePrenotazioni.configs.BuildingConfig;
import gestionePrenotazioni.configs.ConfigurationBooking;
import gestionePrenotazioni.configs.UserConfig;
import gestionePrenotazioni.configs.WorkstationConfig;
import gestionePrenotazioni.models.Booking;
import gestionePrenotazioni.models.Building;
import gestionePrenotazioni.models.User;
import gestionePrenotazioni.models.Workstation;
import gestionePrenotazioni.models.WorkstationType;
import gestionePrenotazioni.services.BookingService;
import gestionePrenotazioni.services.BuildingService;
import gestionePrenotazioni.services.UserService;
import gestionePrenotazioni.services.WorkstationService;
import gestionePrenotazioni.utils.LogColor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class BookingRunner implements CommandLineRunner{
	
	@Autowired
	BookingService bookingServ;
	
	@Autowired
	WorkstationService workstationServ;

	@Override
	public void run(String... args) throws Exception {
		log.info(LogColor.GREEN("START"));
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigurationBooking.class);
	
		try {
		//bookingServ.create(ctx.getBean("newBooking1", Booking.class));
		//bookingServ.create(ctx.getBean("newBooking2", Booking.class));
		
		}catch(Exception e) {
			log.error(e.getMessage());
		}
		
		List<Workstation> lw = workstationServ.searchWorkstation("Roma", WorkstationType.PRIVATE);
		for(Workstation w : lw) {
			System.out.println(w);
		}
		//bookingS.create(ctx.getBean("newBooking3", Booking.class));
		
		//bookingS.create(ctx.getBean("newBooking4", Booking.class));
		
		((AnnotationConfigApplicationContext)ctx).close();

		log.info(LogColor.YELLOW("RUNNER END"));
	}

}
