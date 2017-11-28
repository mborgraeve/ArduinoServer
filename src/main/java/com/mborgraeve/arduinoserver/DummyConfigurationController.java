package com.mborgraeve.arduinoserver;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mborgraeve.arduinoserver.models.Greeting;

@RestController
public class DummyConfigurationController {

	private static final String template = "Hello, %s";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/greetings")
	public Greeting root(@RequestParam(value="name", required=false, defaultValue="World") String name) {
		System.out.println("served at "+LocalDateTime.now());
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

}