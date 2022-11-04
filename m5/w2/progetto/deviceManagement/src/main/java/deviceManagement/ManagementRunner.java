package deviceManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import deviceManagement.Models.Device;
import deviceManagement.Models.Role;
import deviceManagement.Models.User;
import deviceManagement.Services.DeviceService;
import deviceManagement.Services.RoleService;
import deviceManagement.Services.UserService;
import deviceManagement.configuration.ManagementConfig;
import deviceManagement.utils.LogColor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ManagementRunner implements CommandLineRunner{
	
	@Autowired
	private DeviceService ds;	
	
	@Autowired 
	private UserService us;
	
	@Autowired 
	private RoleService rs;
	
	@Override
	public void run(String... args) throws Exception {
		
		log.info(LogColor.GREEN("START"));

		ApplicationContext ctx = new AnnotationConfigApplicationContext(ManagementConfig.class);
		
		rs.save(ctx.getBean("rAdmin",Role.class));
		rs.save(ctx.getBean("rUser",Role.class));
		
		us.save(ctx.getBean("user1",User.class));
		us.save(ctx.getBean("user2",User.class));
		us.save(ctx.getBean("user3",User.class));
		
		ds.save(ctx.getBean("deviceSmartphone1", Device.class));
		ds.save(ctx.getBean("deviceSmartphone2", Device.class));
		ds.save(ctx.getBean("deviceSmartphone3", Device.class));
		
		ds.save(ctx.getBean("deviceTablet", Device.class));
		ds.save(ctx.getBean("deviceLaptop", Device.class));
				
		((AnnotationConfigApplicationContext) ctx).close();
		log.info(LogColor.YELLOW("RUNNER END"));
		
	}

}
