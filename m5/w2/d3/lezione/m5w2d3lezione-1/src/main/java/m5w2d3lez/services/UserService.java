package m5w2d3lez.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import m5w2d3lez.entities.User;
import m5w2d3lez.repositories.UserRepository;

public class UserService {

	@Autowired
	UserRepository ur;

	public Iterable<User> getAll() {        
		return ur.findAll();
    }
    public void addUser(User u) {
        ur.save(u);
    }
    public Optional<User> getById(Long id) {
        return ur.findById(id);
    }
    public void deleteById(Long id) {
        ur.deleteById(id);
    }
    

    public Page<User> getAllAndPaginate(Pageable p){
        return ur.findAll(p);
    }
    public Page<User> getByNameAndPaginate(String n, Pageable p){
        return ur.findByNameAndPaginate(n, p);
    }

    
}
