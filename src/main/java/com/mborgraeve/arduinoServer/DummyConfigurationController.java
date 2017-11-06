package com.mborgraeve.arduinoServer;

import java.lang.annotation.Target;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyConfigurationController {

	@RequestMapping("/")
	public String index() {
		return "{\"Temperature\":17.00,\"Humidity\":51.16,\"Instruction\":{\"InstrutedTemperature\":18.00,\"DefaultTemperature\":17.00,\"TimeLimit\":1509812400},\"Power\":2,\"Variator\":{\"VariatorCycle\":60,\"VariatorRatio\":2},\"Time\":1509908301}";
	}

}