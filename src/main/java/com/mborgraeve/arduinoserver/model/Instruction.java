package com.mborgraeve.arduinoserver.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "instruction")
@AllArgsConstructor
@NoArgsConstructor
public class Instruction implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1239947152304184204L;

	public Instruction(float instructedTemperature, float defaultTemperature, Date timelimit, int cycleDuration) {
		this.setInstructedTemperature(instructedTemperature);
		this.setDefaultTemperature(defaultTemperature);
		this.setTimelimit(timelimit);
		this.setCycleDuration(cycleDuration);
	}

	@Id
	@Getter
	@Setter
	@NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Getter
	@Setter
	@NotNull
	@Min(5)
	@Column(name="instructedtemperature")
	private float instructedTemperature = (float) 19.0;

	@Getter
	@Setter
	@NotNull
	@Min(5)
	@Column(name="defaulttemperature")
	private float defaultTemperature = (float) 12.0;

	@Getter
	@Setter
	@NotNull
	@Column(name="timelimit")
	private Date timelimit;

	@Getter
	@Setter
	@NotNull
	@Column(name="cycleduration")
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
		private int id;

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
