package m5w2d3lez.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import m5w2d3lez.entities.Message;
import m5w2d3lez.entities.User;
import m5w2d3lez.services.MessageService;
import m5w2d3lez.services.UserService;

public class MessageController {

	@Autowired
	MessageService ms;

	@Autowired
	UserService us;

	@GetMapping("{id}")
	public Optional<Message> getById(@PathVariable("id") Long id) {
		return ms.getById(id);
	}

	@GetMapping("content/{subString}")
	public Page<Message> getBySubString(@PathVariable("subString") String s, Pageable p) {
		return ms.getByMessageAndPaginate(s, p);
	}

	@GetMapping("author/{username}")
	public Page<Message> getByAuthor(@PathVariable("username") String s, Pageable p) {
		return ms.getByAuthorAndPaginate(s, p);
	}

	@PostMapping
	public Message postMessage(@RequestParam("title") String title, @RequestParam("content") String content,
			@RequestParam("author") Long author, @RequestParam("receiver") Long receiver) {
		Optional<User> aut = us.getById(author);
		Optional<User> rec = us.getById(receiver);
		if (aut.isPresent() && rec.isPresent()) {
			Message m = new Message(title, content, aut.get(), rec.get());

			ms.addMessage(m);
			return m;
		}
		return null;
	}
}
