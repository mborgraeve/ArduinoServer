package com.mborgraeve.arduinoserver.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class ArduinoInstruction {

    @NotNull
    @Min(5)
    private float instructedTemperature;

    @NotNull
    @Min(5)
    private float defaultTemperature;

    @NotNull
    @Min(0)
    private long timelimit;

    @NotNull
    private int cycleDuration;
}
