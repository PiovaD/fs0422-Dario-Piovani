package jpacrudrest;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class PageControllerTest2 {

	@Autowired
	private MockMvc m;

	@Test
	public void test2() throws Exception {
		m.perform(MockMvcRequestBuilders.get("/api/users/test2").accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(content().string(containsString("java")));

	}
}
