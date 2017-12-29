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
import com.mborgraeve.arduinoserver.model.ArduinoInstruction;

@Entity
@Table(name = "planning_instruction")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlanningInstruction implements Serializable {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1239947152304184204L;

	public PlanningInstruction(float instructedTemperature, float defaultTemperature, Date start, Date end, int cycleDuration,
			float priority) {
		this.setInstructedTemperature(instructedTemperature);
		this.setDefaultTemperature(defaultTemperature);
		this.setStartDate(start);
		this.setEndDate(end);
		this.setCycleDuration(cycleDuration);
		this.setPriority(priority);
	}

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotNull
	@Min(5)
	@Column(name = "instructed_temperature")
	private float instructedTemperature = (float) 19.0;

	@NotNull
	@Min(5)
	@Column(name = "default_temperature")
	private float defaultTemperature = (float) 12.0;

	@NotNull
	@Column(name = "end_date")
	private Date endDate;

	@NotNull
	@Column(name = "start_date")
	private Date startDate;
	
	@NotNull
	@Column(name = "cycle_duration")
	private int cycleDuration = 60;

	@NotNull
	@Column(name = "priority")
	private float priority = 0f;

	public ArduinoInstruction toFlattenedInstruction() {
		return new ArduinoInstruction(this.id, this.instructedTemperature, this.defaultTemperature,
				this.endDate.getTime(), this.getCycleDuration());
	}
}