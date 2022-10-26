package m5w1d2lez.components;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public abstract class Teacher implements ITeacherActions {

	private String name;

}
