package com.manuelsenatore.security.security.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/os")
public class OtherServiceController {

	@GetMapping("people")
	public String m1() {
		RestTemplate rt = new RestTemplate();
		String url = "http://localhost:8082/app/people";
		
		ResponseEntity<String> resp = rt.getForEntity(url, String.class);
		
		return "rsp: " + resp.getBody();
	}
}
