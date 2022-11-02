package m5w2d3lez.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "messages")
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;	
	private String content;	
	private LocalDate sendDate;
	
	@ManyToOne
	@JoinColumn(name = "sender_id")
	private User sender;
	
	@ManyToOne
	@JoinColumn(name = "receiver_id")
	private User receiver;

	public Message(String title, String content, User sender, User receiver) {
		this.title = title;
		this.content = content;
		this.sendDate = LocalDate.now();
		this.sender = sender;
		this.receiver = receiver;
	}
	
	
}
