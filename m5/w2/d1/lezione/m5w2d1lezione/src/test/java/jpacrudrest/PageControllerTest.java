package jpacrudrest;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PageControllerTest {

	@LocalServerPort
	private int port;

	@Test
	public void testEndPoint() throws Exception {
		TestRestTemplate tr = new TestRestTemplate();

		ResponseEntity<String> resp = tr.getForEntity(
				"http://localhost:" + port + "/api/users/test1", String.class
				);
		
		assertEquals(resp.getBody(), "ciao sono il test 1");
	}

}
