package m5w1d4lez.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m5w1d4lez.entities.User;
import m5w1d4lez.repositories.IUserRepository;

@Service
public class UserService {
	
	@Autowired
	IUserRepository ur;
	
	public List<User> getAll(){
		return ur.findAll();
	}
	
	public void addUser(User u) {
		ur.save(u);
	}
	
	public List<User> getByName(String s){
		return ur.getByName(s);
	}
}
