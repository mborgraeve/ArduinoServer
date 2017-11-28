package com.mborgraeve.arduinoserver.models;

import java.time.LocalDateTime;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.datetime.joda.LocalDateTimeParser;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Instruction {

	@Getter
	@Setter
	@NotNull
	@Min(5)
	private float instructedTemperature = (float) 19.0;

	@Getter
	@Setter
	@NotNull
	@Min(5)
	private float defaultTemperature = (float) 12.0;

	@Getter
	@Setter
	@NotNull
	private LocalDateTime timelimit = 0;

	@Getter
	@Setter
	@NotNull
	private int cycleDuration = 60;

	public FlattenedInstruction toFlattenedInstruction() {
		return new FlattenedInstruction(this.instructedTemperature, this.defaultTemperature,
				this.timelimit.toEpochSecond(null), this.getCycleDuration());
	}

	@AllArgsConstructor
	public class FlattenedInstruction {

		@Getter
		@Setter
		@NotNull
		@Min(5)
		private float instructedTemperature = (float) 19.0;

		@Getter
		@Setter
		@NotNull
		@Min(5)
		private float defaultTemperature = (float) 12.0;

		@Getter
		@Setter
		@NotNull
		private long timelimit = 0;

		@Getter
		@Setter
		@NotNull
		private int cycleDuration = 60;

		public Instruction toInstruction() {
return new Intruction(this.instructedTemperature, this.defaultTemperature, (new LocalDateTime()).)
		}
	}
}
