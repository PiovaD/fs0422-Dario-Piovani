package m5w2d4lez.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import m5w2d4lez.entities.User;
import m5w2d4lez.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository ur;
	
	
	public Iterable<User> getAll() {        
		return ur.findAll();
    }
	
	public Optional<User> getByUsername(String username){
		return ur.findByUsername(username);
	}
	
    public void addUser(User u) {
        ur.save(u);
    }
    
    public Optional<User> getById(int id) {
        return ur.findById(id);
    }
}
