package jpacrudrest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jpacrudrest.entities.User;
import jpacrudrest.repositories.IUserRepository;

@Service
public class UserService {
	
	@Autowired
	IUserRepository ur;
	
	public Iterable<User> getAll(){
		return ur.findAll();
	}
	
	public void addUser(User u) {
		ur.save(u);
	}
	
	public List<User> getByName(String s){
		return ur.getByName(s);
	}
	
	public Optional<User> getById(int id) {
		return ur.findById(id);
	}
	
	public void deleteById(int id){
		ur.deleteById(id);
	}
	
	public Page<User> getAllAndPaginate(Pageable p){
		Page<User> pe = ur.findAll(p);
		return pe;
	}
	
	public Page<User> getByNameAndPaginate(String n, Pageable p){
		return ur.findByNameAndPaginate(n, p);
	}
}
