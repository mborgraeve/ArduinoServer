package com.mborgraeve.arduinoserver.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Greeting {

	@Getter
	private final long id;
	
	@Getter
	private final String content;

}
