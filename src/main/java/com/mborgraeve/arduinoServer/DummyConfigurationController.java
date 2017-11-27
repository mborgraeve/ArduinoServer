package com.mborgraeve.arduinoserver;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyConfigurationController {

	@RequestMapping("/")
	public String index() {
		System.out.println("served at "+LocalDateTime.now());
		return "{"
//				+ "Temperature\":17.00,"
//				+ "\"Humidity\":51.16,"
//				+ "\"Instruction\":"
//				+ "{"
				+ "\"InstructedTemperature\":19.00,"
				+ "\"DefaultTemperature\":12.00,"
				+ "\"TimeLimit\":1511033110,"
//				+ "\"UpdateDelay\":6000,"
//				+ "},"
//				+ "\"Power\":2,"
//				+ "\"Variator\":"
//				+ "{"
				+ "\"CycleDuration\":60"
//				+ "\"VariatorRatio\":2,"
//				+ "},"
//				+ "\"Time\":1509908301"
				+ "}";
	}

}