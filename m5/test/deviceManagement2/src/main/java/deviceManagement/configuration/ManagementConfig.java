package deviceManagement.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import deviceManagement.Models.Device;
import deviceManagement.Models.DeviceStatus;
import deviceManagement.Models.DeviceType;
import deviceManagement.Models.Role;
import deviceManagement.Models.RoleType;
import deviceManagement.Models.User;

@Configuration
public class ManagementConfig {

	@Bean(name = "rAdmin")
	@Scope("singleton")
	public Role roleAdmin() {
		return new Role(RoleType.ROLE_ADMIN);
	}

	@Bean(name = "rUser")
	@Scope("singleton")
	public Role roleUser() {
		return new Role(RoleType.ROLE_USER);
	}

	@Bean(name = "user1")
	@Scope("singleton")
	public User user1() {		
		User u = new User("ajeje", "Aldo", "Baglio", "dexter@garolfo.cops", "test");
		u.getRoles().add(roleAdmin());
		return u;
	}
	
	@Bean(name = "user2")
	@Scope("singleton")
	public User user2() {
		User u =  new User("piera", "Giacomino", "Poretti", "sugar@garolfo.cops", "test");
		u.getRoles().add(roleUser());
		return u;
	}
	
	@Bean(name = "user3")
	@Scope("singleton")
	public User user3() {
		User u =  new User("Pdor", "Giovanni", "Storti", "tiger@garolfo.cops", "test");
		u.getRoles().add(roleAdmin());
		u.getRoles().add(roleUser());
		return u;
	}

	@Bean
	@Scope("singleton")
	public Device deviceSmartphone1() {
		Device d = new Device(DeviceType.SMARTPHONE, DeviceStatus.ASSIGNED);
		d.setUser(user1());
		return d;
	}

	@Bean
	@Scope("singleton")
	public Device deviceSmartphone2() {
		Device d =  new Device(DeviceType.SMARTPHONE, DeviceStatus.ASSIGNED);
		d.setUser(user2());
		return d;
	}
	
	@Bean
	@Scope("singleton")
	public Device deviceSmartphone3() {
		Device d =  new Device(DeviceType.SMARTPHONE, DeviceStatus.MAINTENANCE);
		d.setUser(user3());
		return d;
	}
	
	@Bean
	@Scope("singleton")
	public Device deviceTablet() {
		Device d =  new Device(DeviceType.TABLET, DeviceStatus.ASSIGNED);
		d.setUser(user2());
		return d;
	}
	
	@Bean
	@Scope("singleton")
	public Device deviceLaptop() {
		Device d =  new Device(DeviceType.LAPTOP, DeviceStatus.ASSIGNED);
		d.setUser(user3());
		return d;
	}
	
	
	
}
