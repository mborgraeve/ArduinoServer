package com.mborgraeve.arduinoserver.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Entity
public class Instruction {

	@Id
	@Getter
	@Setter
	@NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

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
	private Date timelimit;

	@Getter
	@Setter
	@NotNull
	private int cycleDuration = 60;

	public FlattenedInstruction toFlattenedInstruction() {
		return new FlattenedInstruction(this.id, this.instructedTemperature, this.defaultTemperature,
				this.timelimit.getTime(), this.getCycleDuration());
	}

	@AllArgsConstructor
	public class FlattenedInstruction {

		@Getter
		@Setter
		@NotNull
		private long id;

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
			return new Instruction(this.id, this.instructedTemperature, this.defaultTemperature,
					new Date(this.timelimit), this.cycleDuration);
		}
	}
}
