package m5w2d3lez.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import m5w2d3lez.entities.Message;
import m5w2d3lez.repositories.MessageRepository;

public class MessageService {

	@Autowired
	MessageRepository mr;

	public Iterable<Message> getAll() {
		return mr.findAll();
	}

	public void addMessage(Message m) {
		mr.save(m);
	}

	public Optional<Message> getById(Long id) {
		return mr.findById(id);
	}

	public void deleteById(Long id) {
		mr.deleteById(id);
	}
	
    public Page<Message> getByMessageAndPaginate(String n, Pageable p){
        return mr.findByMessageAndPaginate(n, p);
    }

    public Page<Message> getByAuthorAndPaginate(String n, Pageable p){
        return mr.findByAuthorAndPaginate(n, p);
    }

}
