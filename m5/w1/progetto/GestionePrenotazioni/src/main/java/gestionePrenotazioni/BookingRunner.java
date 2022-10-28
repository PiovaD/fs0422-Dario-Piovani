package gestionePrenotazioni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import gestionePrenotazioni.configs.BookingConfig;
import gestionePrenotazioni.configs.BuildingConfig;
import gestionePrenotazioni.configs.UserConfig;
import gestionePrenotazioni.configs.WorkstationConfig;
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
	BuildingService buildingServ;
	@Autowired
	BuildingConfig buildingConfig;
	
	@Autowired
	UserService userServ;
	@Autowired
	UserConfig userConfig;
	
	@Autowired
	BookingService bookingServ;
	@Autowired
	BookingConfig bookingConfig;
	
	@Autowired
	WorkstationService workstationServ;
	@Autowired
	WorkstationConfig workstationConfig;

	@Override
	public void run(String... args) throws Exception {
		log.info(LogColor.GREEN("START"));
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(BookingConfig.class);
	
		//bookingServ.create(ctx.getBean("newBooking1", Booking.class));
		
		//bookingS.create(ctx.getBean("newBooking2", Booking.class));
		
		//bookingS.create(ctx.getBean("newBooking3", Booking.class));
		
		//bookingS.create(ctx.getBean("newBooking4", Booking.class));
		
		((AnnotationConfigApplicationContext)ctx).close();

		log.info(LogColor.YELLOW("RUNNER END"));
	}

}
